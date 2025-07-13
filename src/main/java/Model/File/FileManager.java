package Model.File;

import Model.Dot;
import Model.Position;
import view.Dots;
import view.Drawer;
import view.Lines;
import Model.Line;

import java.io.*;

public class FileManager {
    Lines lines;
    Dots dots;
    String filePath = "data.csv";
    Drawer d;
    public FileManager(Drawer d) {
        this.d = d;
        lines = d.getLines();
        dots = d.getDots();
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Dot dot : dots.getDotStack()) {
                writer.write(dot.toString());
                writer.newLine();
            }
            for(Line line : lines.getLines()) {
                writer.write(line.toString());
                writer.newLine();
            }
            System.out.println("CSV file written successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public void openFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            lines.removeAll();
            dots.removeAll();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                if(values[0].equals("Dot")) {
                    dots.addDot(
                            Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]),
                            Integer.parseInt(values[3])
                    );
                }
                if(values[0].equals("Line")) {
                    lines.addLine(
                            Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]),
                            Integer.parseInt(values[3]),
                            Integer.parseInt(values[4])
                    );
                }
            }

            d.repaint();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
