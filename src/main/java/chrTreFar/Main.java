package chrTreFar;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int width = 12;//12
        int height = 5;//5
        int[] content = {1, 0, 1, 0, 2, 2};
        int bag_size = width * height;
        int presents_size = 0;
        Map<Integer, Integer> presentsMap = new HashMap<Integer, Integer>();
        List<Present> presentList = new ArrayList<Present>();
        //Map<Integer, Integer> presentsMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < content.length; i++) {
            //System.out.println("Psesent type[" + i + "]: " + content[i]);
            if (content[i] > 0)
                presentsMap.put(i, content[i]);
            for (int j = 0; j < content[i]; j++) {
                presentList.add(new Present(i));
            }
        }
        for (Map.Entry<Integer, Integer> entry : presentsMap.entrySet()) {
            System.out.println("Present type[" + entry.getKey() + "]: " + entry.getValue());
        }
        presents_size = presentList.size() * 7;
        System.out.println("Is " + presentList.size() + " presents with " + presents_size + "(all) fields into bag size: " + bag_size);
        for(int i=0; i<presentList.size(); i++) {
            System.out.println("Present " + (i + 1) + ".- type: " + presentList.get(i).getType());
            presentList.get(i).showPresent();
        }

        Bag B = new Bag(height, width);
        B.clearBag();
        //B.showBag();

        boolean find = false;

        System.out.println();
        if (presents_size <= bag_size) {
            System.out.println("START find");
            for(int i=0; i<presentList.size(); i++){
                System.out.println("Present " + (i+1) + ".- type: " +  presentList.get(i).getType());
                boolean put = false;
                for (char[][] pos : getAllPositions(presentList.get(i))) {
                    //showPresentPosition(pos);
                    //for (char[][] present : pos) {

                        for (int y = 0; y < height && !put; y++) {
                            for (int x = 0; x < width && !put; x++) {
                                if (B.checkPlace(y, x, pos)) {
                                    System.out.println("PUT " + B.putPresent(y, x, pos));
                                    System.out.println("Present(" + i + "), y: " + y + ", x: " + x);
                                    B.showBag();
                                    put = true;
                                }
                            }
                        }
                        if(put){
                            break;
                        }
                    //}

                    //showPresentPosition(pos);
                    //System.out.println();
                }
            }
        } else {
            System.out.println("TO MANY PRESENTS");
        }
        System.out.println("END find");
        B.showBag();


        System.out.println("Goodbye!");
    }

    private static List<char[][]> getAllPositions (Present present){
        List<char[][]> listAll = new ArrayList<>();

        Present copy = present.getCopy();
        for(int i = 0; i < 4; i++){
            listAll.add(presentCopy(copy.getPresent()));
            copy.flipH();
            listAll.add(presentCopy(copy.getPresent()));
            copy.flipH();
            copy.flipV();
            listAll.add(presentCopy(copy.getPresent()));
            copy.flipV();
            copy.rotate();
        }

        List<char[][]> finalList = new ArrayList<>();
        for(char[][] all : listAll){
            boolean exists = false;
            for(char[][] fin : finalList){
                if(Arrays.deepEquals(all, fin)){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                finalList.add(all);
            }
        }
        return finalList;
    }

    private static void showPresentPosition(char[][] present){
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                System.out.print("[" + present[y][x] + "]");
            }
            System.out.println();
        }
    }

    private static char[][] presentCopy (char[][] present){
        char[][] copy = new char[3][3];
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                copy[y][x] = present[y][x];
            }
        }
        return copy;
    }
}