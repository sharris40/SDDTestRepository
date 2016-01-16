package view;

import controller.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JPanel;
import model.GameFigure;

public class GamePanel extends JPanel {

    public static final int PWIDTH = 600; // size of the game panel
    public static final int PHEIGHT = 400;

    public Rectangle areaSelector = null;

    // off screen rendering
    private Graphics graphics;
    private Image dbImage = null;

    public GamePanel() {
        setBackground(Color.blue);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
    }

    public void gameRender() {
        if (dbImage == null) {
            dbImage = createImage(PWIDTH, PHEIGHT);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = dbImage.getGraphics();
            }
        }

        graphics.clearRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);

        synchronized (Main.gameData.figures) {
            for (GameFigure f : Main.gameData.figures) {
                f.render(graphics);
            }
        }

        if (areaSelector != null) {
            graphics.setColor(Color.blue);
            graphics.drawRect(areaSelector.x, areaSelector.y,
                    areaSelector.width, areaSelector.height);
        }

    }

    // use active rendering to put the buffered image on-screen
    public void printScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            if (g != null) {
                g.dispose();
            }
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }
}
