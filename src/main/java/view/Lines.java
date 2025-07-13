package view;

import Model.Dot;
import Model.Line;
import Model.Position;

import java.util.Stack;

public class Lines {
    private final Stack<Line> lineStack;

    public Lines() {
        lineStack = new Stack<>();
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        lineStack.push(new Line(x1, y1, x2, y2));
    }

    public void removeAll() {
        lineStack.clear();
    }

    public Stack<Line> getLines() {
        return lineStack;
    }
}
