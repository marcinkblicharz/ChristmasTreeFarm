package chrTreFar;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    static long step = 0;

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int width = 12;//12
        int height = 5;//5
        int[] content = {1, 0, 1, 0, 2, 2};
        int bag_size = width * height;
        int presents_size = 0;
        int step = 0;
        boolean placedAll = false;
        DecimalFormat df = new DecimalFormat("###.###");
        Map<Integer, Integer> presentsMap = new HashMap<Integer, Integer>();
        List<Present> presentList = new ArrayList<Present>();

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
            String finded = "";
            System.out.println("START searching");

            long start = System.currentTimeMillis();
            placedAll = findPlace(B, presentList, 0);
            long end = System.currentTimeMillis();

            if(placedAll)
                finded = "FIND";
            else
                finded = "NOT FIND";
            System.out.println(finded + " in " + Main.step + " steps on " + (end - start) + " ms");
        } else {
            System.out.println("TO MANY PRESENTS");
        }
        if(placedAll)
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

    public static boolean findPlace(Bag B, List<Present> presentsList, int index) {

        step++;

        while(index < presentsList.size()) {
            Present present = presentsList.get(index);
            List<char[][]> allPos = getAllPositions(present);

            for (char[][] current : allPos) {
                for (int y = 0; y <= B.getRow() - 3; y++) {
                    for (int x = 0; x <= B.getCol() - 3; x++) {
                        if (B.checkPlace(y, x, current)) {
                            B.putPresent(y, x, current);
                            if (findPlace(B, presentsList, index + 1))
                                return true;
                            B.removePresent(y, x, current);
                        }
                    }
                }
            }

            return false;
        }
        return true;
    }
}