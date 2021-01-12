package rover;

import java.util.ArrayList;
import java.util.HashMap;

public class Rover {

    private static int mX, mY;
    private int coordinate;
    private char rotation;
    //rotation coordinate etkisi
    private static HashMap<Character, Integer> keyMap = new HashMap<Character, Integer>();
    //iterasyon icin
    private static ArrayList<Character> rotateList = new ArrayList<Character>() {{
        add('N');
        add('E');
        add('S');
        add('W');
    }};


    /* x ve y degerleri coordinate adlı tek degiskende tutulur*/
    public Rover(int x, int y, char rotation) {
        this.coordinate = mY * y + x;
        this.rotation = rotation;
    }

    /*hareket mapdeki integer bilgisi ile yapılır*/
    public void move() {
        int x = coordinate % mY;
        int y = coordinate / mY;

        if (rotation == 'N' && y == mY - 1 || (rotation == 'S' && y == 0) || (rotation == 'W' && x == 0) || (rotation == 'E' && x == mX - 1)) {
            return;
        }
        coordinate += keyMap.get(rotation);
       /*
        if (rotation == 'N' && y != mY) y +=1;
        if (rotation == 'S' && y != 0) y -=1;
        if (rotation == 'E' && x != mX) x +=1;
        if (rotation == 'W' && x != 0) x -=1;
*/
    }


    public String getCoordinate() {
        return coordinate % mY + " " + coordinate / mY + " " + rotation;
    }

    public void l_rotate() {
        for (int i = 0; i < rotateList.size(); i++) {
            if (rotateList.get(i) == rotation) {
                if (i == 0) rotation = 'W';
                else rotation = rotateList.get(i - 1);
                return;
            }
        }
    }

    public void r_rotate() {
        for (int i = 0; i < rotateList.size(); i++) {
            if (rotateList.get(i) == rotation) {
                if (i == rotateList.size() - 1) rotation = 'N';
                else rotation = rotateList.get(i + 1);
                return;
            }
        }
    }

    /* Alanın Max boyutu belirlenir*/
    public static void setEndCord(String input) {
        int spc = input.indexOf(' ');
        mX = Integer.parseInt(input.substring(0, spc)) + 1;
        mY = Integer.parseInt(input.substring(spc + 1)) + 1;
        /*Rover Y hareketi icin Alan boyutu bilinmesi gerekli*/
        keyMap.clear();
        keyMap.put('N', mX);
        keyMap.put('E', +1);
        keyMap.put('S', -1 * mX);
        keyMap.put('W', -1);
    }


}
