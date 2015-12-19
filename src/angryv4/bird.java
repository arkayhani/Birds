package angryv4;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class bird {

    static int x = 55;
    static int y = 610;
    static int boomber_change = 3;
    boolean visible = true;

    public static int getx() {
        return x;
    }

    public static int gety() {
        return y;
    }

    public static void setx(int x) {
        bird.x = x;

    }

    public static void sety(int y) {

        bird.y = y;
    }

    public static void set(int x, int y) {
        bird.x = x;
        bird.y = y;
    }

    public abstract void draw(Graphics g);
}

class boomber extends bird {

    public void draw(Graphics g) {
        
        ImageIcon img=new ImageIcon(this.getClass().getResource("atom1.png"));
        ImageIcon img2=new ImageIcon(this.getClass().getResource("atom2.png"));
        ImageIcon img3=new ImageIcon(this.getClass().getResource("atom12.png"));
        
        if (visible) {
            if (boomber_change == 3) {
                g.setColor(Color.red);
                g.drawImage(img.getImage(), x, y, 50, 50, null);
                //g.fillOval(x, y, 10, 10);
            }
            if (boomber_change == 1) {
                g.setColor(Color.red);
                g.drawImage(img2.getImage(), x, y, 60, 60, null);
                //g.fillOval(x, y, 10, 10);
            }
            if (boomber_change == 0) {
                g.setColor(Color.red);
                g.drawImage(img3.getImage(), x, y, 60, 60, null);
            }

        }
    }
}

class tokhmgozar extends bird {

    @Override
    public void draw(Graphics g) {
        Toolkit tool = Toolkit.getDefaultToolkit();
        //Image img = tool.getImage("C:\\Users\\yaser\\Desktop\\New folder (2)\\g5.png");
         ImageIcon img=new ImageIcon(this.getClass().getResource("tokhmgozar.png"));
       
        g.drawImage(img.getImage(), x, y, 75, 75, null);
    }
}
