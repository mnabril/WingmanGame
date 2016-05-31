/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 *
 * @author Marisa Abril
 */
public class PowerUp extends GameObject{
    
    Random gen;
    Wingman wingman;

    PowerUp(Image img, int x, int y, int speed, Random gen, Wingman wingman) {
        super(img, x,y, speed);
        this.wingman = wingman;
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gen = gen;
        
        height = img.getHeight(null);
        width = img.getWidth(null);
    }

    public void update() {
        y += speed;

    }

    public void draw(Graphics g, ImageObserver obs) {
        g.drawImage(img, x, y, obs);
    }
    
}

