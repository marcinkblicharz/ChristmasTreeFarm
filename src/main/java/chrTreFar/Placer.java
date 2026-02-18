package chrTreFar;

import lombok.Getter;

import java.util.*;

@Getter
public class Placer {

    private int[] content;
    int presents_size;
    int step;
    Map<Integer, Integer> presentsMap = new HashMap<Integer, Integer>();
    List<Present> presentList = new ArrayList<Present>();
    Bag bag;

    private Placer(){
        content = new int[5];
        step = 0;
    }

    public Placer(Bag bag, int[] content) {
        this.bag = bag;
        this.content = content;
        int present_index = 0;
        step = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i] > 0)
                presentsMap.put(i, content[i]);
            for (int j = 0; j < content[i]; j++) {
                presentList.add(new Present(i, (char)('A' + present_index++)));
            }
        }
        presents_size = presentList.size() * 7;
    }

    public void showListOfTypes(){
        for (Map.Entry<Integer, Integer> entry : presentsMap.entrySet()) {
            System.out.println("Present type[" + entry.getKey() + "]: " + entry.getValue());
        }
    }

    public void showFieldsInfo(){
        int bag_size = bag.getCols()*bag.getRows();
        System.out.println("Is " + presentList.size() + " presents with " + presents_size + "(all) fields into bag size: " + bag_size);
    }

    public void showPresents(){
        for(int i=0; i<presentList.size(); i++) {
            System.out.println("Present " + (i + 1) + ".- type: " + presentList.get(i).getType());
            presentList.get(i).showPresent();
        }
    }

    private char[][] presentCopy (char[][] present){
        char[][] copy = new char[3][3];
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                copy[y][x] = present[y][x];
            }
        }
        return copy;
    }

    private List<char[][]> getAllPositions (Present present){
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

    public boolean findPlace(Bag bag, List<Present> presentsList, int index) {

        step++;

        if(index >= presentsList.size()) {
            return true;
        }
            Present present = presentsList.get(index);
            List<char[][]> allPos = getAllPositions(present);

            for (char[][] current : allPos) {
                for (int y = 0; y <= bag.getRows() - 3; y++) {
                    for (int x = 0; x <= bag.getCols() - 3; x++) {
                        if (bag.checkPlace(y, x, current)) {
                            bag.putPresent(y, x, current);
                            if (findPlace(bag, presentsList, index + 1)) {
                                //System.out.println("Found place at next present: " + index + " on location [" + y + "][" + x + "]");
                                //showPresentPosition(current);
                                return true;
                            }
                            //System.out.println("Not found place at next present: " + index + " on location [" + y + "][" + x + "]");
                            //showPresentPosition(current);
                            bag.removePresent(y, x, current);
                        }
                    }
                }
            }
            //System.out.println("Not found place return FALSE");
            return false;
    }

    public void showPresentPosition(char[][] present){
        for(int y =0; y<3; y++){
            for(int x =0; x<3; x++){
                System.out.print("[" + present[y][x] + "]");
            }
            System.out.println();
        }
    }
}
