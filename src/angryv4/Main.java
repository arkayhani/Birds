package angryv4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Main {

    static int i = 0;
    static double vx = 5;
    static double vy = 20;
    static float a = (float) 0.25;
    static Start h;
    static mh hand;

    public static void main(String args[]) throws InterruptedException {
        INTRODUCT newIntro = new INTRODUCT();

        //newIntro.setLocation(200, 200);
        newIntro.setVisible(true);
        Monitor.newpage(10);
       // newIntro.setAlwaysOnTop(true);
        h = new Start();
        h.setLocation(1040, 5);
        newIntro.hmade = true;
        hand = new mh();
        barname.frame.addMouseListener(hand);
        barname.frame.addMouseMotionListener(hand);
    }
}
