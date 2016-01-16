package controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import model.GameFigure;
import view.MainWindow;

public class MouseController implements MouseListener, MouseMotionListener {

    private int px;
    private int py;

    @Override
    public void mousePressed(MouseEvent me) {
        px = me.getX();
        py = me.getY();
        Main.gamePanel.areaSelector = new Rectangle();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        List<GameFigure> remove = new ArrayList<GameFigure>();

        synchronized (Main.gameData.figures) {
            for (GameFigure f : Main.gameData.figures) {
                if (Main.gamePanel.areaSelector.contains(f.x, f.y)) {
                    remove.add(f);
                }
            }
            int killed = remove.size();
            Main.gameData.figures.removeAll(remove);
            int alive = Main.gameData.figures.size();
            MainWindow.message.
                    setText("Enemies killed:" + killed + " alive:" + alive);
        }

        Main.gamePanel.areaSelector = null;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        int dx = me.getX(); // drag point
        int dy = me.getY();
        int x, y, w, h;
        if (px < dx) {
            x = px;
            w = dx - px;
        } else {
            x = dx;
            w = px - dx;
        }
        if (py < dy) {
            y = py;
            h = dy - py;
        } else {
            y = dy;
            h = py - dy;
        }
        Main.gamePanel.areaSelector.setRect(x, y, w, h);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
