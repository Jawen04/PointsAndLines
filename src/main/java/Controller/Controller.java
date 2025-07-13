package Controller;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

import Model.File.FileManager;
import Model.Settings.Settings;
import view.*;

public class Controller {
    private DrawingPlate drawingPlate;
    private Drawer d;
    private Settings settings;
  
    public Controller(DrawingPlate drawingPlate) {
        this.drawingPlate = drawingPlate;
        this.settings = new Settings();

        Dots dots = new Dots();
        Lines lines = new Lines();
        d = new Drawer(dots, lines, settings);

        drawingPlate.add(d);
        drawingPlate.setJMenuBar(new MenuBar(drawingPlate, d, settings, new FileManager(d)));
        drawingPlate.setVisible(true);

         drawingPlate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the mouse position relative to the JFrame
                int x = e.getX();
                int y = e.getY();
                System.out.println("Mouse pressed at: X=" + x + ", Y=" + y);
                dots.addDot(x, y, 20);
                if(dots.hasAtLeastTwoDots()) {
                    int x1 = dots.getTwoLatestDots()[0].getPos().getX();
                    int y1 = dots.getTwoLatestDots()[0].getPos().getY();
                    int x2 = dots.getTwoLatestDots()[1].getPos().getX();
                    int y2 = dots.getTwoLatestDots()[1].getPos().getY();


                    lines.addLine(x1, y1, x2, y2);
                }
                d.repaint();
            }
        });

        drawingPlate.addKeyListener(new KeyListener() {


            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == (KeyEvent.VK_L)) {
                    toggleLinesVisibility();
                }
                if(e.getKeyCode() == (KeyEvent.VK_D)) {
                    settings.toggleDotsVisibility();
                    drawingPlate.refresh(d);
                }
                if(e.getKeyCode() == (KeyEvent.VK_C)) {
                    lines.removeAll();
                    dots.removeAll();
                    drawingPlate.refresh(d);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyTyped(KeyEvent e) {}
        });
    }

    public void toggleLinesVisibility() {
        settings.toggleLinesVisibility();
        drawingPlate.refresh(d);
    }

    public void toggleDotsVisibility() {
        settings.toggleDotsVisibility();
        drawingPlate.refresh(d);
    }




    public void disposeDrawing() {
        drawingPlate.dispose();
    }



}
