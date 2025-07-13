package view;

import Model.Dot;
import Model.Line;
import Model.Settings.Settings;

import javax.swing.*;
import java.awt.*;



public class Drawer extends JPanel {
    Dots dots;
    Lines lines;
    Settings settings;

    private final int OFFSET = 20;

    public Drawer(Dots dots, Lines lines, Settings settings) {
        this.dots = dots;
        this.lines = lines;
        this.settings = settings;
    }

    public Dots getDots() {
        return dots;
    }

    public Lines getLines() {
        return lines;
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(settings.dotsVisible) {
            for(Dot dot : dots.getDotStack()) {
                int centerX = dot.getPos().getX() - dot.getDiameter()/2;
                int centerY = dot.getPos().getY() - dot.getDiameter()/2 - OFFSET;
                g2d.setColor(Color.RED);
                g2d.fillOval(centerX, centerY, dot.getDiameter(), dot.getDiameter());
            }
        }

        if(settings.linesVisible) {
            for(Line line : lines.getLines()) {
                g2d.setColor(Color.BLACK);
                g2d.drawLine(line.getX1(), line.getY1() - OFFSET, line.getX2(), line.getY2() - OFFSET);
            }
        }
    }
}
