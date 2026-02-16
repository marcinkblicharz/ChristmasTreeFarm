package chrTreFar;

import com.sun.source.tree.BreakTree;

public class Bag {

    private int row;
    private int col;
    private char[][] bag;

    public Bag(int row, int col) {
        this.row = row;
        this.col = col;
        bag = new char[row][col];
    }

    public void clearBag(){
        for(int y =0; y<row; y++){
            for(int x =0; x<col; x++){
                bag[y][x] = ' ';
            }
        }
    }

    public void showBag(){
        for(int y =0; y<row; y++){
            for(int x =0; x<col; x++){
                System.out.print("[" + bag[y][x] + "]");
            }
            System.out.println();
        }
    }

    public boolean checkPlace(int indexY, int indexX, char[][] present){
        //System.out.println("indexY: " + indexY + ", indexX: " + indexX + ", row: " + row + ", col: " + col);
        if(indexY < row-2 && indexX < col-2){
            for(int y =0; y<3; y++){
                for(int x =0; x<3; x++){
                    //System.out.print("B:" + (indexY+y) + "-" + (indexX+x) + "=" + bag[indexY+y][(indexX+x)] + "|P:" + y + "-" + x + "=" + present[y][x] + "|| ");
                    if(present[y][x] != ' '){
                        if(bag[indexY+y][indexX+x] != ' '){
                            //System.out.println("BAG [" + (indexY+y) + "][" + (indexX+x) + "] NOT FREE");
                            return false;
                        }
                    }
                }
            }
        } else {
            //System.out.println("!!! Indexes are incorrect !!!");
            return false;
        }
        return true;
    }

    public boolean putPresent(int indexY, int indexX, char[][] present){
        //System.out.println("indexY: " + indexY + ", indexX: " + indexX + ", row: " + row + ", col: " + col);
        if(indexY < row-2 && indexX < col-2){
            for(int y =0; y<3; y++){
                for(int x =0; x<3; x++){
                    //System.out.print("B:" + (indexY+y) + "-" + (indexX+x) + "=" + bag[indexY+y][(indexX+x)] + "|P:" + y + "-" + x + "=" + present[y][x] + "|| ");
                    if(present[y][x] != ' '){
                        if(bag[indexY+y][indexX+x] == ' '){
                            bag[indexY+y][indexX+x] = present[y][x];
                        }else{
                            //System.out.println("BAG [" + (indexY+y) + "][" + (indexX+x) + "] NOT FREE");
                            return false;
                        }
                    } else {
                        //bag[indexY+y][indexX+x] = '-';
                    }
                    //System.out.print("[" + present[y][x] + "]");
                }
                //System.out.println();
            }
            //System.out.println("END LOG FILL BAG");
        } else {
            //System.out.println("!!! Indexes are incorrect !!!");
            return false;
        }
    return true;
    }

    public void removePresent(int indexY, int indexX, char[][] present){
            for(int y =0; y<3; y++){
                for(int x =0; x<3; x++){
                    if(present[y][x] != ' '){
                        bag[indexY+y][indexX+x] = ' ';
                    }
                }
            }
    }
}
