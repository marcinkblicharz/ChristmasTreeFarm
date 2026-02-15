package chrTreFar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int width = 4;//12
        int height = 4;//5

        /*for(int y =0; y<height; y++){
            for(int x =0; x<width; x++){
                System.out.print("x:" + x + " y:" + y + " ");
            }
            System.out.println();
        }*/


        Bag B = new Bag(height, width);
        //B.clearBag();
        //B.showBag();

        Present P0_1 = new Present(4);
        Present P0_2 = new Present(4);
        Present P1 = new Present(1);
        System.out.println("--P0_1");
        P0_1.showPresent();
        System.out.println("--P0_2");
        //P0_2.rotate();
        //P0_2.rotate();
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
        System.out.println("PUT " + B.putPresent(0, 0, P0_1.getPresent()));
        System.out.println("PUT " + B.putPresent(0, 0, P0_2.getPresent()));
        B.showBag();

        P0_2.rotate();
        P0_2.rotate();
        System.out.println("--P0_2 rotate,rotate");
        P0_2.showPresent();
        System.out.println("PUT " + B.putPresent(1, 1, P0_2.getPresent()));
        B.showBag();*/

        boolean find = false;
        B.clearBag();
        System.out.println("PUT " + B.putPresent(0, 0, P0_1.getPresent()));
        B.showBag();
        System.out.println();
        for(int y = 0; y < height-2; y++) {
            for (int x = 0; x < width-2; x++) {
                for (int r = 0; r < 4; r++) {
                    System.out.println();
                    P0_2.rotate();
                    System.out.println("--P0_2, y: " + y + ", x: " + x + ", r: " + r);
                    P0_2.showPresent();
                    B.showBag();
                    if (B.putPresent(y, x, P0_2.getPresent())) {
                        find = true;
                        break;
                    }
                }
            }
        }
        if(find)
            System.out.println("FIND");
        else
            System.out.println("NOT FIND");
        //System.out.println("PUT " + B.putPresent(0, 0, P0_2.getPresent()));
        B.showBag();


        System.out.println("Goodbye!");
    }
}