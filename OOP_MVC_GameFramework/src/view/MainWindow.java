package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

    public static JTextField message;

    public static JButton startButton;
    public static JButton addButton;
    public static JButton quitButton;

    public MainWindow() {

        Container c = getContentPane();

        message = new JTextField("<Start>, then Shoot or Drag to kill enemies");
        message.setEditable(false);
        c.add(message, "North");

        c.add(Main.gamePanel, "Center");

        JPanel southPanel = new JPanel();
        startButton = new JButton("Start");
        southPanel.add(startButton);
        addButton = new JButton("Add 10");
        southPanel.add(addButton);
        quitButton = new JButton("Quit");
        southPanel.add(quitButton);
        c.add(southPanel, "South");

        ButtonListener buttonListener = new ButtonListener();

        startButton.addActionListener(buttonListener);
        addButton.addActionListener(buttonListener);
        quitButton.addActionListener(buttonListener);

        MouseController mouseController = new MouseController();

        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        startButton.addKeyListener(keyListener);
        startButton.setFocusable(true);
        addButton.setFocusable(false);
        quitButton.setFocusable(false);
    }

}
