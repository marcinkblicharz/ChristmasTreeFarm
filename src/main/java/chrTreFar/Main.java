package chrTreFar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int width = 4;//12
        int height = 4;//5
        int[] content = {0, 0, 0, 0, 2, 0};
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
        //B.clearBag();
        //B.showBag();

        Present P0_1 = new Present(0);
        Present P0_2 = new Present(1);
        Present P1 = new Present(1);
        System.out.println("--P0_1, type: " + P0_1.getType());
        P0_1.showPresent();
        System.out.println("--P0_2, type: " + P0_2.getType());
        P0_2.showPresent();
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
        B.clearBag();
        System.out.println("PUT " + B.putPresent(0, 0, P0_1.getPresent()));
        B.showBag();
        B.removePresent(0, 0, P0_1.getPresent());
        System.out.println("---");
        B.showBag();

        System.out.println();
        if (presents_size <= bag_size) {
        System.out.println("START find");
            for (int y = 0; y < height - 2; y++) {
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
                System.out.println("NOT FIND");
            //System.out.println("PUT " + B.putPresent(0, 0, P0_2.getPresent()));
        } else {
            System.out.println("TO MANY PRESENTS");
        }
        B.showBag();


        System.out.println("Goodbye!");
    }
}