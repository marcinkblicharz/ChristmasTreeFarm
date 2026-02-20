package farm;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public class Present {

    private char[][] block;
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private int type;
    private char label;

    public Present(){
        block = new char[HEIGHT][WIDTH];
        for(int y = 0; y< HEIGHT; y++){
            for(int x = 0; x< WIDTH; x++){
                block[y][x] = '0';
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Present presentObject = (Present) obj;
        return Arrays.deepEquals(block, presentObject.block);
    }

    @Override
    public int hashCode() {
        return Objects.hash(block, type, label);
    }

    public Present(int type, char label){
        this.type = type;
        this.label = label;
        block = new char[HEIGHT][WIDTH];
        for(int y = 0; y< HEIGHT; y++){
            for(int x = 0; x< WIDTH; x++){
                block[y][x] = label;
            }
        }
        if(type == 0){
            block[1][2] = ' ';
            block[2][2] = ' ';
        } else if(type == 1){
            block[1][2] = ' ';
            block[2][0] = ' ';
        } else if(type == 2){
            block[0][0] = ' ';
            block[2][2] = ' ';
        } else if(type == 3){
            block[0][2] = ' ';
            block[2][2] = ' ';
        } else if(type == 4){
            block[1][1] = ' ';
            block[1][2] = ' ';
        } else if(type == 5){
            block[1][0] = ' ';
            block[1][2] = ' ';
        }
    }

    public void showPresent(){
        for(int y = 0; y< HEIGHT; y++){
            for(int x = 0; x< WIDTH; x++){
                System.out.print("[" + block[y][x] + "]");
            }
            System.out.println();
        }
    }

    public void rotate(){
        char[][] temp = new char[3][3];
        for(int y = 0; y< HEIGHT; y++){
            System.arraycopy(block[y], 0,temp[y], 0, WIDTH);
        }
        for(int y =0; y<HEIGHT; y++){
            for(int x =0; x<WIDTH; x++){
                block[y][x] = temp[2-x][y];
            }
        }
    }

    public void flipH(){
        char[][] temp = new char[3][3];
        for(int y = 0; y< HEIGHT; y++){
            System.arraycopy(block[y], 0,temp[y], 0, WIDTH);
        }
        for(int y = 0; y< HEIGHT; y++){
            for(int x = 0; x< WIDTH; x++){
                if(x == 0)
                    block[y][x] = temp[y][2];
                else if(x == 2)
                    block[y][x] = temp[y][0];
            }
        }
    }

    public void flipV(){
        char[][] temp = new char[3][3];
        for(int y = 0; y< HEIGHT; y++){
            System.arraycopy(block[y], 0,temp[y], 0, WIDTH);
        }
        for(int y = 0; y< HEIGHT; y++){
            for(int x = 0; x< WIDTH; x++){
                if(y == 0)
                    block[y][x] = temp[2][x];
                else if(y == 2)
                    block[y][x] = temp[0][x];
            }
        }
    }

    public Present getCopy(){
        Present temp = new Present(this.type, this.label);
        temp.type = this.type;
        temp.label = this.label;
        for(int y = 0; y< HEIGHT; y++){
            System.arraycopy(block[y], 0, temp.block[y], 0, WIDTH);
        }
        return temp;
    }

}
