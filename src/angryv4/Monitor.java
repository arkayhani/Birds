package angryv4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.IconUIResource;

public class Monitor extends JPanel {

    int x = 10;
    int y = 400;
    static bird bird1;
    background bground = new bg1();
    JLabel bird = new JLabel();
    egg newegg = new egg();
    public static stone target[];
    icons icon1 = new exite_icon();
    icons icon2 = new refresh_icon();
    icons icon3 = new changebird_icon();
    icons icon4 = new changepage_icon();
    static int change = 0;
    static int changepage = 0;
    static boolean end = false;

    public static void changebird() {
        if (change == 0) {
            bird1 = new boomber();
            change++;
        } else {
            bird1 = new tokhmgozar();
            change--;
        }
    }

    public Monitor() {
        if (changepage == 0) {
            bground = new bg1();
            //changepage++;
        } else {
            bground = new bg2();
            //changepage--;
        }
        bird1 = new boomber();
    }

    public static void newpage(int n) {
        target = new stone[n];
        for (int i = 0; i < target.length; i++) {
            target[i] = new sakhre((int) (Math.random() * 700) + 500, (int) (Math.random() * 500) + 200);
        }
        barname.first = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        if(end)
        {
            ImageIcon img = new ImageIcon(this.getClass().getResource("end.jpg"));
            g.drawImage(img.getImage(),0,0, 1280, 800, null);
        }
else
        {
        bground.draw(g);
        icon1.draw(g);
        icon2.draw(g);
        icon3.draw(g);
        icon4.draw(g);
        bird1.draw(g);
        for(int i=0;i<barname.points.length;i++){
            barname.points[i].draw(g);
        }
        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                target[i].draw(g);
            }
        }

        newegg.draw(g);
        }
        icon1.draw(g);
    }
}
