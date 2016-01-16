package model;

import view.GamePanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameData {

    private final int RADIUS = 6;
    public final List<GameFigure> figures;

    public GameData() {
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());

        figures.add(new Shooter(GamePanel.PWIDTH / 2, GamePanel.PHEIGHT - 30));

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int red = r.nextInt(155) + 100;
            int green = r.nextInt(155) + 100;
            int blue = r.nextInt(155) + 100;
            figures.add(new Ball(r.nextInt(GamePanel.PWIDTH),
                    r.nextInt(GamePanel.PHEIGHT), RADIUS, new Color(red, green, blue)));
        }
    }

    public void add(int n) {
        Random r = new Random();
        synchronized (figures) {
            for (int i = 0; i < n; i++) {
                int red = r.nextInt(155) + 100;
                int green = r.nextInt(155) + 100;
                int blue = r.nextInt(155) + 100;
                figures.add(new Ball(r.nextInt(GamePanel.PWIDTH),
                        r.nextInt(GamePanel.PHEIGHT), RADIUS, new Color(red, green, blue)));
            }
        }
    }

    public void update() {
        synchronized (figures) {
            for (GameFigure f : figures) {
                f.update();
            }
        }
    }
}
