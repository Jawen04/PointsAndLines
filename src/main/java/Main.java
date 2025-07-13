import Controller.Controller;
import view.DrawingPlate;

public class Main{
    public static void main(String[] args) {
        new Controller(new DrawingPlate());
        // int seconds = 10;
        // while(seconds > 0) {
        //     System.out.println(c.getPos());
        //     try {
        //         Thread.sleep(1000);
        //         seconds--;
        //     } catch(Exception e) {
        //         e.printStackTrace();
        //     }
        // }
        // c.disposeDrawing();
    }

}