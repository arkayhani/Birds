package angryv4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class egg {

    int x = 0;
    int y = 1000;
    boolean visible = true;
    public void set(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.white);
            g.fillOval(x, y, 20, 30);
        }

    }
}
