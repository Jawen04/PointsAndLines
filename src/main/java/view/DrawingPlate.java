package view;

import javax.swing.JFrame;

public class DrawingPlate extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    public DrawingPlate() {
        this.setSize(HEIGHT, WIDTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void refresh(Drawer d) {
        getContentPane().removeAll();
        repaint();
        revalidate();
        add(d);
        d.repaint();
    }


}