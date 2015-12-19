/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package angryv4;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Kayhani
 */
public class point {
    int x;
    int y;
public void draw(Graphics g){
    g.setColor(Color.red);
    g.fillOval(x+7, y+25,4 , 4);
}
}
