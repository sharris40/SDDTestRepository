package model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Shooter extends GameFigure {

    private final Image launcherImage;

    public Shooter(int x, int y) {
        super(x, y);
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");

        // put images in 'ImagesFolder' folder, which is on the top level of
        // the NetBeans project folder.
        // Using "Files" tab of the NetBeans explorer window, right click on
        // the project folder name, and create a folder named "ImagesFolder"
        // You cannot see "ImagesFolder" folder in 'Project' tab, though
        //launcherImage = getImage(imagePath + separator + "images" + separator
        launcherImage = getImage(imagePath + separator + "ImagesFolder" + separator
                + "shooter.png");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(launcherImage, super.x, super.y, 30, 30, null);
    }

    @Override
    public void update() {
        // no periodic update is required
        // update is done via 'translate' when a key is pressed
    }

    public void translate(int dx, int dy) {
        super.x += dx;
        super.y += dy;
    }

    public static Image getImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }

    @Override
    public String toString() {
        return super.x + ", " + super.y;
    }

}
