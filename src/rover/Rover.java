package rover;

import java.util.ArrayList;


public class Rover {

    private int x, y;
    private char rotation;
    private Plateau plateau;

    public char getRotation() {
        return rotation;
    }

    public void setRotation(char rotation) {
        this.rotation = rotation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //iterasyon icin
    private static ArrayList<Character> rotateList = new ArrayList<Character>() {{
        add('N');
        add('E');
        add('S');
        add('W');
    }};


    /* x ve y degerleri coordinate adlı tek degiskende tutulur*/
    public Rover(int x, int y, char rotation, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.plateau = plateau;
    }

    /*hareket mapdeki integer bilgisi ile yapılır*/
    public void move() {

        int tx = x;
        int ty = y;

        if (rotation == 'N' && y != plateau.getmY()) y += 1;
        if (rotation == 'S' && y != 0) y -= 1;
        if (rotation == 'E' && x != plateau.getmX()) x += 1;
        if (rotation == 'W' && x != 0) x -= 1;

        for (int i = 0; i < (plateau.getRovers().size() - 1); i++) {
            Rover rover = plateau.getRovers().get(i);
            if (rover.x == x && rover.y == y) {
                System.out.println("İstenilen Konumda Başka Bir Rover Bulunuyor");
                x = tx;
                y = ty;
                return;
            }

        }

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


}
