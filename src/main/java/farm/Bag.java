package farm;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public class Bag {

    private int rows;
    private int cols;
    private char[][] space;

    public Bag(int row, int col) {
        this.rows = row;
        this.cols = col;
        space = new char[row][col];
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass())
            return false;
        Bag bagObject = (Bag)obj;
        return Arrays.deepEquals(space, bagObject.space);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, space);
    }

    public void clearBag(){
        for(int y =0; y<rows; y++){
            for(int x = 0; x< cols; x++){
                space[y][x] = ' ';
            }
        }
    }

    public void showBag(){
        for(int y =0; y<rows; y++){
            for(int x = 0; x< cols; x++){
                System.out.print("[" + space[y][x] + "]");
            }
            System.out.println();
        }
    }

    public boolean checkPlace(int indexY, int indexX, char[][] present){
        if(!isInRange(indexY, indexX))
            return false;
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                if(present[y][x] != ' ' && space[indexY+y][indexX+x] != ' ')
                    return false;
            }
        }
        return true;
    }

    public boolean putPresent(int indexY, int indexX, char[][] present){
        if(!isInRange(indexY, indexX))
            return false;
        if(!checkPlace(indexY, indexX, present))
            return false;

        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                if(present[y][x] != ' '){
                        space[indexY+y][indexX+x] = present[y][x];
                }
            }
        }
    return true;
    }

    public void removePresent(int indexY, int indexX, char[][] present){
            for(int y =0; y<3; y++){
                for(int x =0; x<3; x++){
                    if(present[y][x] != ' ')
                        space[indexY+y][indexX+x] = ' ';
                }
            }
    }

    private boolean isInRange(int indexY, int indexX){
        return indexY < rows-2 && indexX < cols -2;
    }
}
