package angryv4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.FilteredImageSource;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public abstract class icons {

    int x;
    int y;
    static String activity = "normal";

    public static void refresh() {
        set_activity("normal");
        exite_icon.mouse_entered = 0;
        refresh_icon.mouse_entered = 0;
        changebird_icon.mouse_entered = 0;
        changepage_icon.mouse_entered = 0;
    }

    public static void set_activity(String activity) {
        icons.activity = activity;

    }

    public static String get_activity() {
        return activity;

    }

    public abstract void draw(Graphics g);
}

class exite_icon extends icons {

    static int mouse_entered = 0;

    @Override
    public void draw(Graphics g) {
        x = 1230;
        y = 2;
        if (mouse_entered == 0) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("close-button.png"));

            g.drawImage(img.getImage(), x, y, 50, 50, null);
        }
        if (mouse_entered == 1) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("windows-close-program-1.png"));
            g.drawImage(img.getImage(), x - 10, y - 2, 70, 70, null);

        }
    }
}

class refresh_icon extends icons {

    static int mouse_entered = 0;

    @Override
    public void draw(Graphics g) {
        x = 1170;
        y = 2;
        if (mouse_entered == 0) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("abr.jpg"));


            g.drawImage(img.getImage(), x, y, 50, 50, null);


        }
        if (mouse_entered == 1) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("abr2.jpg"));
            g.drawImage(img.getImage(), x - 10, y - 2, 70, 70, null);

        }
    }
}

class changepage_icon extends icons {

    static int mouse_entered = 0;

    @Override
    public void draw(Graphics g) {
        x = 1110;
        y = 2;
        if (mouse_entered == 0) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("quake.png"));
            g.drawImage(img.getImage(), x, y, 50, 50, null);
        }
        if (mouse_entered == 1) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("quake2.png"));
            g.drawImage(img.getImage(), x - 10, y - 2, 70, 70, null);

        }
    }
}

class changebird_icon extends icons {

    static int mouse_entered = 0;

    @Override
    public void draw(Graphics g) {
        x = 1050;
        y = 2;
        if (mouse_entered == 0) {
            ImageIcon img = new ImageIcon(this.getClass().getResource("Sign Refresh Edited.png"));
            g.drawImage(img.getImage(), x, y, 50, 50, null);
        }
        if (mouse_entered == 1) {

            ImageIcon img = new ImageIcon(this.getClass().getResource("Sign Refresh Edited2.png"));
            g.drawImage(img.getImage(), x - 10, y - 2, 70, 70, null);

        }
    }
}