package Model.Settings;

public class Settings {
    public boolean linesVisible;
    public boolean dotsVisible;

    public Settings() {
        linesVisible = true;
        dotsVisible = true;
    }

    public void toggleLinesVisibility() {
        linesVisible = !linesVisible;
    }

    public void toggleDotsVisibility() {
        dotsVisible = !dotsVisible;
    }
}
