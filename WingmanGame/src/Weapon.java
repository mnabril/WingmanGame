/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 *
 * @author Marisa Abril
 */
public abstract class Weapon extends GameObject{
    
    int img_width;
    int img_height;
    
    Weapon(Image img, int x, int y, int speed) {
        super(img,x,y,speed);
    }

    public void update() {
        
    }

    public void draw(Graphics g) {
        g.drawImage(img, this.x, this.y, obs);
    }
    
}
