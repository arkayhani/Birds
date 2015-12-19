package angryv4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class stone {

    boolean live = true;
    int x = 900;
    int y = 600;
    int vy = 10;
    int vx = 0;
    boolean visible = true;

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class sakhre extends stone {

    sakhre(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        ImageIcon img = new ImageIcon(this.getClass().getResource("sakhre.png"));
        if (visible) {

            g.setColor(Color.red);
            g.drawImage(img.getImage(), x, y, 100, 100, null);
        }

    }
}

class box1 extends stone {

    box1(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        ImageIcon img = new ImageIcon(this.getClass().getResource("box1.png"));
        if (visible) {

            g.setColor(Color.red);
            g.drawImage(img.getImage(), x, y, 100, 100, null);
        }

    }
}

class box2 extends stone {

    box2(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        ImageIcon img = new ImageIcon(this.getClass().getResource("box2.png"));
        if (visible) {

            g.setColor(Color.red);
            g.drawImage(img.getImage(), x, y, 100, 100, null);
        }

    }
}

class box3 extends stone {

    box3(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        ImageIcon img = new ImageIcon(this.getClass().getResource("box3.png"));
        if (visible) {

            g.setColor(Color.red);
            g.drawImage(img.getImage(), x, y, 100, 100, null);
        }

    }
}