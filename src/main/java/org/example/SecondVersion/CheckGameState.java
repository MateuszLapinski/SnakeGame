package org.example.SecondVersion;

public class CheckGameState {
    private static CheckGameState instance;
    private boolean isPlay=true;

    private CheckGameState() {}

    public static CheckGameState getInstance() {
        if (instance == null) {
            instance = new CheckGameState();
        }
        return instance;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }
}
