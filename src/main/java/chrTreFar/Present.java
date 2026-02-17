package chrTreFar;

import lombok.Getter;

@Getter
public class Present {

    private char[][] present;
    private int type;

    public Present(){
        present = new char[3][3];
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                present[y][x] = '0';
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Present(int type){
        this.type = type;
        present = new char[3][3];
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                present[y][x] = (char)('0' + type);
            }
        }
        if(type == 0){
            present[1][2] = ' ';
            present[2][2] = ' ';
        } else if(type == 1){
            present[1][2] = ' ';
            present[2][0] = ' ';
        } else if(type == 2){
            present[0][0] = ' ';
            present[2][2] = ' ';
        } else if(type == 3){
            present[0][2] = ' ';
            present[2][2] = ' ';
        } else if(type == 4){
            present[1][1] = ' ';
            present[1][2] = ' ';
        } else if(type == 5){
            present[1][0] = ' ';
            present[1][2] = ' ';
        }
    }

    public void showPresent(){
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                System.out.print("[" + present[y][x] + "]");
            }
            System.out.println();
        }
    }

    public void rotate(){
        char[][] temp = new char[3][3];
        int c = 0;
        for(int y =0; y<3; y++){
            //temp[y] = new char[3];
            for(int x =0; x<3; x++){
                temp[y][x] = present[y][x];
                if(present[y][x] == '0'){
                    c++;
                }
            }
        }
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                present[y][x] = temp[2-x][y];
            }
        }
    }

    public void flipH(){
        char[][] temp = new char[3][3];
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                temp[y][x] = present[y][x];
            }
        }
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                if(x == 0)
                    present[y][x] = temp[y][2];
                else if(x == 2)
                    present[y][x] = temp[y][0];
            }
        }
    }

    public void flipV(){
        char[][] temp = new char[3][3];
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                temp[y][x] = present[y][x];
            }
        }
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                if(y == 0)
                    present[y][x] = temp[2][x];
                else if(y == 2)
                    present[y][x] = temp[0][x];
            }
        }
    }

    public Present getCopy(){
        Present temp = new Present(this.type);
        temp.type = this.type;
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                temp.present[y][x] = this.present[y][x];
            }
        }
        return temp;
    }

}
