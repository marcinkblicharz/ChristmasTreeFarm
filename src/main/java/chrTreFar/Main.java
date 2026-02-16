package chrTreFar;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int width = 4;//12
        int height = 4;//5
        int[] content = {1, 0, 0, 0, 1, 0};
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

        /*for(int y =0; y<height; y++){
            for(int x =0; x<width; x++){
                System.out.print("x:" + x + " y:" + y + " ");
            }
            System.out.println();
        }*/


        Bag B = new Bag(height, width);
        B.clearBag();
        B.showBag();

        /*Present P0_1 = new Present(0);
        Present P0_2 = new Present(1);
        Present P1 = new Present(1);
        System.out.println("--P0_1, type: " + P0_1.getType());
        P0_1.showPresent();
        System.out.println("--P0_2, type: " + P0_2.getType());
        P0_2.showPresent();*/
        /*System.out.println("--P1");
        P1.showPresent();
        System.out.println("---show 0");
        P0_1.showPresent();
        System.out.println();
        P0_1.rotate();
        System.out.println("---show 90");
        P0_1.showPresent();
        System.out.println();
        P0_1.rotate();
        System.out.println("---show 180");
        P0_1.showPresent();
        System.out.println();
        P0_1.rotate();
        System.out.println("---show 270");
        P0_1.showPresent();
        System.out.println();
        P0_1.rotate();
        System.out.println("---show 360");
        P0_1.showPresent();
        System.out.println();
        P0_1.flipH();
        System.out.println("---flip H");
        P0_1.showPresent();
        System.out.println();
        P0_1.flipV();
        System.out.println("---flip V");
        P0_1.showPresent();
        System.out.println();*/

        /*Present P0_1 = new Present(4);
        System.out.println("--P0_1");
        P0_1.showPresent();
        System.out.println("--P0_1, rotate, rotate");
        P0_1.rotate();
        P0_1.rotate();
        P0_1.showPresent();*/

        /*B.clearBag();
        P0_2.rotate();
        P0_2.rotate();
        System.out.println("--P0_2, rotate, rotate");
        P0_2.showPresent();
        System.out.println("PUT " + B.putPresent(0, 0, P0_1.getPresent()));
        B.showBag();
        System.out.println("PUT " + B.putPresent(1, 1, P0_2.getPresent()));
        B.showBag();*/


       /* B.clearBag();
        System.out.println("PUT " + B.putPresent(0, 0, P0_1.getPresent()));
        System.out.println("PUT " + B.putPresent(0, 0, P0_2.getPresent()));
        B.showBag();

        P0_2.rotate();
        P0_2.rotate();
        System.out.println("--P0_2 rotate,rotate");
        P0_2.showPresent();
        System.out.println("PUT " + B.putPresent(1, 1, P0_2.getPresent()));
        B.showBag();
        System.out.println();
        System.out.println();*/

        boolean find = false;
       /* B.clearBag();
        System.out.println("PUT " + B.putPresent(0, 0, P0_1.getPresent()));
        B.showBag();
        B.removePresent(0, 0, P0_1.getPresent());
        System.out.println("---");
        B.showBag();*/

        System.out.println();
        if (presents_size <= bag_size) {
            System.out.println("START find");
            for(int i=0; i<presentList.size(); i++){
                System.out.println("Present " + (i+1) + ".- type: " +  presentList.get(i).getType());
                for (char[][] pos : getAllPositions(presentList.get(i))) {
                    showPresentPosition(pos);
                    System.out.println();
                }
            }
            /*for (int y = 0; y < height - 2; y++) {
                for (int x = 0; x < width - 2; x++) {
                    for (int r = 0; r < 4; r++) {
                        //System.out.println();
                        P0_2.rotate();
                        //System.out.println("--P0_2, y: " + y + ", x: " + x + ", r: " + r);
                        P0_2.showPresent();
                        B.showBag();
                        if (B.checkPlace(y, x, P0_2.getPresent())) {
                            System.out.println("PUT " + B.putPresent(y, x, P0_2.getPresent()));
                            find = true;
                            break;
                        }
                    }
                }
            }
            if (find)
                System.out.println("FIND");
            else
                System.out.println("NOT FIND");*/
            //System.out.println("PUT " + B.putPresent(0, 0, P0_2.getPresent()));
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