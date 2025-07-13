package view;

import Model.Dot;
import Model.Position;


import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
import java.util.Collections;

public class Dots {
    // private final ArrayList<Dot> dotList = new ArrayList<>();
    private final Stack<Dot> dotStack;

    public Dots() {
        dotStack = new Stack<>();
    }

    public void addDot(int x, int y, int diameter) {
        dotStack.push(new Dot(new Position(x, y), diameter));
    }

    public double calculateDistance(Dot d1, Dot d2) {
        if(dotStack.size() < 2) {
            return -1;
        }
        int x1 = d1.getPos().getX();
        int y1 = d1.getPos().getY();
        int x2 = d2.getPos().getX();
        int y2 = d2.getPos().getY();

        int base = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);
        return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    public Dot[] getTwoLatestDots() {
        Dot[] a = new Dot[2];
        a[0] = getReversedList().get(0);
        a[1] = getReversedList().get(1);
        return a;
    }

    public void removeAll() {
        dotStack.clear();
    }

    public boolean hasAtLeastTwoDots() {
        return dotStack.size() >= 2;
    }



    public void printList() {
        for(Dot dot : getReversedList()) {
            System.out.println(dot);
        }
    }

    public List<Dot> getReversedList() {
        List<Dot> reversedList = new ArrayList<>(dotStack);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public Stack<Dot> getDotStack() {
        return dotStack;
    }
}

