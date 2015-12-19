package angryv4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public abstract class background {

    int x = 0;
    int y = 0;
    boolean visible = true;

    public abstract void draw(Graphics g);
}

class bg1 extends background {

    public void draw(Graphics g) {

        ImageIcon img = new ImageIcon(this.getClass().getResource("background1.jpg"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (visible) {
            g.drawImage(img.getImage(), 0, 0, screenSize.width, screenSize.height, null);

        }
    }
}

class bg2 extends background {

    public void draw(Graphics g) {

        ImageIcon img = new ImageIcon(this.getClass().getResource("background2.jpg"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (visible) {
            g.drawImage(img.getImage(), 0, 0, screenSize.width, screenSize.height, null);

        }
    }
}