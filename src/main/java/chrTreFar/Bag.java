package chrTreFar;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public class Bag {

    private int rows;
    private int cols;
    private char[][] bag;

    public Bag(int row, int col) {
        this.rows = row;
        this.cols = col;
        bag = new char[row][col];
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass())
            return false;
        Bag bagObject = (Bag)obj;
        return Arrays.deepEquals(bag, bagObject.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, bag);
    }

    public void clearBag(){
        for(int y =0; y<rows; y++){
            for(int x = 0; x< cols; x++){
                bag[y][x] = ' ';
            }
        }
    }

    public void showBag(){
        for(int y =0; y<rows; y++){
            for(int x = 0; x< cols; x++){
                System.out.print("[" + bag[y][x] + "]");
            }
            System.out.println();
        }
    }

    public boolean checkPlace(int indexY, int indexX, char[][] present){
        //System.out.println("indexY: " + indexY + ", indexX: " + indexX + ", row: " + row + ", col: " + col);
        if(indexY < rows-2 && indexX < cols -2){
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
            return false;
        }
        return true;
    }

    public boolean putPresent(int indexY, int indexX, char[][] present){
        if(indexY < rows-2 && indexX < cols -2){
            for(int y =0; y<3; y++){
                for(int x =0; x<3; x++){
                    if(present[y][x] != ' '){
                        if(bag[indexY+y][indexX+x] == ' '){
                            bag[indexY+y][indexX+x] = present[y][x];
                        }else{
                            return false;
                        }
                    }
                }
            }
        } else {
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
