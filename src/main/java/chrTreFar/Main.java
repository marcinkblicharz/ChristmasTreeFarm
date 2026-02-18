package chrTreFar;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int width = 12;                         //12, 4
        int height = 5;                         //5, 4
        int[] content = {1, 0, 1, 0, 2, 2};     //{1, 0, 1, 0, 2, 2}, {1, 0, 1, 0, 3, 2}, {0, 0, 0, 0, 2, 0};
        Bag bag = new Bag(height, width);
        bag.clearBag();
        boolean placedAll = false;
        Placer placer = new Placer(bag, content);

        placer.showListOfTypes();
        placer.showFieldsInfo();
        placer.showPresents();

        boolean find = false;

        System.out.println();
        if (placer.getPresents_size() < bag.getRow()*bag.getCol()) {
            String finded = "";
            System.out.println("START searching");

            long start = System.currentTimeMillis();
            placedAll = placer.findPlace(bag, placer.getPresentList(), 0);
            long end = System.currentTimeMillis();

            if(placedAll)
                finded = "FIND";
            else
                finded = "NOT FIND";
            System.out.println(finded + " in " + placer.getStep() + " steps on " + (end - start) + " ms");
        } else {
            System.out.println("TO MANY PRESENTS");
        }
        if(placedAll)
            bag.showBag();


        System.out.println("Goodbye!");
    }
}