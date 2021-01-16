package rover;

import java.util.ArrayList;


public class Plateau {
    private int mX, mY;
    private ArrayList<Rover> rovers = new ArrayList<Rover>();

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(ArrayList<Rover> rovers) {
        this.rovers = rovers;
    }

    public Plateau(int mX, int mY) {
        this.mX = mX;
        this.mY = mY;

    }

    public int getmX() {
        return mX;
    }

    public void setmX(int mX) {
        this.mX = mX;
    }

    public int getmY() {
        return mY;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }


}
