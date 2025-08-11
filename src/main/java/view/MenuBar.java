package view;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DragGestureEvent;

import Model.File.FileManager;
import Model.Settings.Settings;

public class MenuBar extends JMenuBar {
    Settings settings;
    DrawingPlate frame;
    Drawer d;
    FileManager fileManager;

    public MenuBar(DrawingPlate frame, Drawer d, Settings settings, FileManager fileManager) {
        this.settings = settings;
        this.frame = frame;
        this.d = d;
        this.fileManager = fileManager;
        setBackground(Color.GRAY);

        add(file());
        add(view());

    }

    private JMenu view() {
        JMenu view = new JMenu("View");
        JMenuItem m1 = new JMenuItem("Hide lines");
        JMenuItem m2 = new JMenuItem("Hide dots");

        view.add(m1);
        view.add(m2);

        m1.addActionListener(e -> {
            settings.toggleLinesVisibility();
            if(settings.linesVisible) {
                m1.setText("Hide lines");
            } else {
                m1.setText("Show lines");
            }
            frame.refresh(d);
        });

        m2.addActionListener(e -> {
            settings.toggleDotsVisibility();
            if(settings.dotsVisible) {
                m2.setText("Hide dots");
            } else {
                m2.setText("Show dots");
            }
            frame.refresh(d);
        });

        return view;
    }

    private  JMenu file() {
        JMenu file = new JMenu("File");
        JMenuItem m1 = new JMenuItem("Save");
        JMenuItem m2 = new JMenuItem("Open");

        file.add(m1);
        file.add(m2);

        m1.addActionListener(e -> {
            fileManager.writeToFile();
        });

        m2.addActionListener(e -> {
            fileManager.openFile();
        });

        return file;
    }


    // add menu to menu bar

}
