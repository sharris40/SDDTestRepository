package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Shooter;
import view.MainWindow;

public class KeyController implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        Shooter shooter = (Shooter) Main.gameData.figures.get(0);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                shooter.translate(-5, 0);
                break;
            case KeyEvent.VK_RIGHT:
                shooter.translate(5, 0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
