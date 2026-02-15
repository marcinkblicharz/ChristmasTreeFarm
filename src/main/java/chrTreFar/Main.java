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

        Present P0 = new Present(2);
        P0.showPresent();
        /*System.out.println("---show 0");
        P0.showPresent();
        System.out.println();
        P0.rotate();
        System.out.println("---show 90");
        P0.showPresent();
        System.out.println();
        P0.rotate();
        System.out.println("---show 180");
        P0.showPresent();
        System.out.println();
        P0.rotate();
        System.out.println("---show 270");
        P0.showPresent();
        System.out.println();
        P0.rotate();
        System.out.println("---show 360");
        P0.showPresent();
        System.out.println();
        P0.flipH();
        System.out.println("---flip H");
        P0.showPresent();
        System.out.println();
        P0.flipV();
        System.out.println("---flip V");
        P0.showPresent();
        System.out.println();*/

        B.clearBag();
        B.putPresent(1, 1, P0.getPresent());
        B.showBag();

        System.out.println("Goodbye!");
    }
}