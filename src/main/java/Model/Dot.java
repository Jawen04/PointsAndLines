package Model;

public class Dot {
    private Position pos;
    private int diameter;

    public Dot(Position pos, int diameter) {
        this.pos = pos;
        this.diameter = diameter;
    }

    public Position getPos() {
        return pos;
    }

    public int getDiameter() {
        return diameter;
    }


    @Override
    public  String toString() {
        return "Dot " + pos.getX() + " " + pos.getY() + " " + diameter;
    }

    



}
