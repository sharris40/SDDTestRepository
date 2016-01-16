package model;

import java.awt.Graphics;

public abstract class GameFigure {

    public int x; // for a faster access
    public int y;

    public GameFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void render(Graphics g);

    public abstract void update();
}
