/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author Marisa Abril
 */
public class Bullet extends Weapon {
    Wingman wingman;
    
    Bullet(Image img, int x, int y, int speed, Wingman wingman){
        super(img,x,y, speed);
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.wingman = wingman;
        
        width = img.getWidth(null);
        height = img.getHeight(null);
        
    }
    public boolean collision(int x, int y, int w, int h) {
        bbox = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle otherBBox = new Rectangle(x, y, w, h);
        if (this.bbox.intersects(otherBBox)) {
            return true;
        }
        return false;
    }
    public void update() {
        y -= speed;
    }
    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }
}
