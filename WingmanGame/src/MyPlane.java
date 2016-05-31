/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wingman;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Marisa Abril
 */
public class MyPlane extends Player {
    Wingman wingman;
    MyPlane(Image img, int x, int y, int speed, Wingman wingman) {

        super(img, x, y, speed);
        
        this.wingman = wingman;
        width = img.getWidth(null);
        height = img.getHeight(null);
    }

    public void update(Observable obj, Object arg) {
        GameEvents ge = (GameEvents) arg;
        if (ge.type == 1) {
            KeyEvent e = (KeyEvent) ge.event;
            
            int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT && wingman.m.getX() > 0) {
                
                wingman.m.x -= speed;
            } else if (key == KeyEvent.VK_RIGHT && wingman.m.getX() < (wingman.w - 67)) {
                
                wingman.m.x += speed;
            } else if (key == KeyEvent.VK_UP && wingman.m.getY() > 0) {
                
                wingman.m.y -= speed;
            } else if (key == KeyEvent.VK_DOWN && wingman.m.getY() < (wingman.h - 85)) {
                
                wingman.m.y += speed;
            }
            if (key == KeyEvent.VK_SPACE && e.getID() == KeyEvent.KEY_PRESSED) {
                bullets.add(new Bullet(wingman.myBullet, wingman.m.getX()+17, wingman.m.getY(), 5, wingman));
            }

            if (key == KeyEvent.VK_A && wingman.n.getX() > 0) {
                
                wingman.n.x -= speed;
            } else if (key == KeyEvent.VK_D && wingman.n.getX() < (wingman.w - 67)) {
                
                wingman.n.x += speed;
            } else if (key == KeyEvent.VK_W && wingman.n.getY() > 0) {
               
                wingman.n.y -= speed;
            } else if (key == KeyEvent.VK_S  && wingman.n.getY() < (wingman.h - 85)) {
                
                wingman.n.y += speed;
            }
            if (key == KeyEvent.VK_Q && e.getID() == KeyEvent.KEY_PRESSED) {

                bullets2.add(new Bullet(wingman.myBullet, wingman.n.getX()+17, wingman.n.getY(), 5, wingman));
            }
        } else if (ge.type == 2) {
            String msg = (String) ge.event;
            
        }

    }

    public boolean collision(int x, int y, int w, int h) {
        bbox = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle otherBBox = new Rectangle(x, y, w, h);
        if (this.bbox.intersects(otherBBox)) {
            return true;
        }
        return false;
    }
    
}
