package angryv4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class barname extends Thread {

    static point[] points = new point[1];
    int pointnum;
    mh hand;
    int num;
    int x0 = 60;
    int y0 = 670;
    float time;
    static int flag1 = 0;
    static int flag2 = 0;
    public static JFrame frame;
    Monitor page;
    double vx = 20;
    double vy = 20;
    float a = (float) 0.025;
    boolean end = false;
    static boolean first = true;
    int ttime = 100;
    Thread gh;

    public void add_point(point k) {
        point[] temp = new point[num];
        for (int index = 0; index < num - 1; index++) {
            temp[index] = points[index];
        }
        temp[num - 1] = k;
        points = new point[num];
        for (int index = 0; index < num; index++) {
            points[index] = temp[index];
        }

    }

    void bazsazi() {
        frame.remove(page);
        page = new Monitor();

        frame.repaint();
    }

    public barname(int vx, int vy, float a) {
        points[0] = new point();
        this.a = a;
        this.vx = vx;
        this.vy = vy;
        page = new Monitor();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame();
        frame.setBounds(0, 0, screenSize.width, screenSize.height);
        frame.setUndecorated(true);
        frame.add(page);
        frame.setVisible(true);
        gh = new Thread(new Runnable() {

            public void run() {
                int vb = 5;
                int flag3 = 0;
                for (int index = 0; index < 100000; index++) {
                    if (Monitor.target[2] != null && Monitor.target[2].live) {
                        try {
                            if (flag3 == 0) {
                                (Monitor.target[2].y) += (vb--);
                            } else {
                                (Monitor.target[2].y) += (vb++);
                            }
                            if (vb < -5) {
                                flag3 = 1;
                            }
                            if (vb > 5) {
                                flag3 = 0;
                            }
                            if (first == false) {
                                break;
                            }
                            Thread.sleep(100);
                            frame.add(page);
                            frame.repaint();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        gh.start();

    }

    public void set(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public boolean barkhord() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (Monitor.target[i] != null && Monitor.target[i].live && page.bird1.x >= Monitor.target[i].x - 47 && page.bird1.x <= Monitor.target[i].x + 100 && page.bird1.y >= Monitor.target[i].y - 48 && page.bird1.y <= Monitor.target[i].y + 90) {
                if (page.bird1 instanceof tokhmgozar) {
                    if (vy < 1 / 2) {
                        Thread.sleep(2000);
                        return false;
                    }
                    Monitor.target[i].vy = (int) vy;

                    Monitor.target[i].live = false;
                    num = i;
                    Thread thread = new Thread(new Runnable() {

                        public void run() {
                            try {
                                newmover(page, num);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    thread.start();
                    if (page.bird1.y > Monitor.target[i].y) {
                        x0 = page.bird1.x;
                        y0 = page.bird1.y;
                        vx = -vx / 4;
                        time = 0;
                    } else {
                        vy = vy / 2;
                        vx = vx / 2;
                        x0 = page.bird1.x;
                        y0 = page.bird1.y;
                        time = 0;
                    }
                } else {
                    
                    ttime = 500;
                    for (int j = 0; j < 10; j++) {
                        if (Monitor.target[j] != null) {
                            Monitor.target[j].vx = (Monitor.target[j].x - page.bird1.x);

                            Monitor.target[j].vy = (Monitor.target[j].y - page.bird1.y);
                            if (Math.abs(Monitor.target[j].vx) + Math.abs(Monitor.target[j].vy) < 300) {
                                Monitor.target[j].live = false;
                                if (Monitor.target[j].vx > 0) {
                                    Monitor.target[j].vx = 5;
                                } else {
                                    Monitor.target[j].vx = -5;
                                }
                                if (Monitor.target[j].vy > 0) {
                                    Monitor.target[j].vy = 5;
                                } else {
                                    Monitor.target[j].vy = -5;
                                }






                            } else {
                                Monitor.target[j].vx = 0;
                                Monitor.target[j].vy = 0;
                            }


                        }
                    }

                    Thread tr = new Thread(new Runnable() {

                        public void run() {
                            try {
                                allstonesmover(page);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    tr.start();
                    frame.repaint();
                    for (i = 100; i > 0; i -= 1) {
                        if (bird.boomber_change != 1) {
                            bird.boomber_change = 1;
                            frame.repaint();
                            Thread.sleep(i);

                        } else {
                            bird.boomber_change = 0;
                            frame.repaint();
                            Thread.sleep(i);

                        }
                    }


                    for (int j = 0; j < 10; j++) {
                        if (Monitor.target[j] != null) {
                            Monitor.target[j].vx *= 2;
                            Monitor.target[j].vy *= 2;
                        }
                    }
                    for (i = 0; i < 400; i++) {


                        ttime = 10;
                        frame.repaint();
                        Thread.sleep(10);

                    }

                    return false;



                }
            }

        }
        return true;
    }

    public void barkhord(stone mover) {

        for (int i = 0; i < 10; i++) {
            if (Monitor.target[i] != null && mover!=null&&Monitor.target[i].live && mover != Monitor.target[i] && mover.x >= Monitor.target[i].x - 100 && mover.x <= Monitor.target[i].x + 100 && mover.y >= Monitor.target[i].y - 90 && mover.y <= Monitor.target[i].y + 70) {
                Monitor.target[i].vy = mover.vy;

                num = i;
                Monitor.target[i].live = false;
                Thread thread = new Thread(new Runnable() {

                    public void run() {
                        try {
                            newmover(page, num);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                thread.start();
                vy = vy / 4;
                x0 = page.bird1.x;
                y0 = page.bird1.y;
                time = 1;
            }
        }

    }

    @Override
    public void run() {
        try {
            int template = 0;
            gh = new Thread();
            first = false;
            for (time = 0; time < 150; time += 0.5) {
                try {
                    Thread.sleep(40);
                    frame.repaint();
                    bird.setx((int) (time * vx) + x0);
                    bird.sety((int) (time * time * a - vy * time) + y0);
                    //page.newegg.y += 10;
                    frame.add(page);
                    if (template == 1) {
                        num++;
                        point k = new point();
                        k.x = bird.getx();
                        k.y = bird.gety();
                        add_point(k);
                        template = 0;
                    } else {
                        template++;
                    }
                    if (bird.getx() > 2000 || bird.gety() > 1000) {
                        break;
                    }
                    if (!barkhord()) {
                        break;
                    }
                    if (flag1 == 1) {
                        page.newegg.x = bird.getx();
                        page.newegg.y = bird.gety() + 15;
                        flag1 = 0;
                        Thread eggthread = new Thread(new Runnable() {

                            public void run() {
                                try {
                                    newegg();
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                        eggthread.start();
                    }
                    if (flag2 == 1) {
                        frame.remove(page);
                        page = new Monitor();
                        bird.setx((int) (time * vx));
                        bird.sety((int) (500 + time * time * a - vy * time));
                        flag2 = 0;
                    }

                    frame.setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Boolean end = true;
            for (int i = 0; i < 10; i++) {
                if (Monitor.target[i] != null && Monitor.target[i].live == false) {
                    Monitor.target[i] = null;
                }

            }
            Thread.sleep(1000);
            for (int i = 0; i < 10; i++) {
                if (Monitor.target[i] != null) {
                    frame.setVisible(false);
                    end = false;
                    Main.h.New();
                    break;
                }
            }
            if (end) {
                Monitor.end = true;
                frame.repaint();
                Thread.sleep(5000);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(barname.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newmover(Monitor u, int kk) throws InterruptedException {
        stone mover = Monitor.target[kk];

        int x = mover.x;
        int y = mover.y;
        for (int index = 0; index < 100; index++) {
            y += mover.vy / 2;
            x += mover.vx / 2;
            Thread.sleep(ttime);
            mover.set(x, y);
            barkhord(mover);

        }

    }

    public void allstonesmover(Monitor u) throws InterruptedException {
        stone[] mover = new stone[10];
        for (int i = 0; i < 10; i++) {
            mover[i] = Monitor.target[i];
        }

        for (int index = 0; index < 100; index++) {
            for (int i = 0; i < 10; i++) {
                if (mover[i] != null) {

                    mover[i].y += mover[i].vy / 2;
                    mover[i].x += mover[i].vx / 2;
                }


              //  barkhord(mover[i]);



            }
            Thread.sleep(ttime);
        }


    }

    public void newegg() throws InterruptedException {
        egg mover = page.newegg;

        int x = mover.x;
        int y = mover.y;
        for (int index = 0; index < 100; index++) {
            y += 20;
            Thread.sleep(50);
            mover.set(x, y);

            for (int i = 0; i < 10; i++) {
                if (Monitor.target[i] != null && page.newegg.x >= Monitor.target[i].x && page.newegg.x <= Monitor.target[i].x + 100 && page.newegg.y >= Monitor.target[i].y && page.newegg.y <= Monitor.target[i].y + 50) {
                    Monitor.target[i] = null;

                }
                frame.repaint();

            }

        }

    }
}
