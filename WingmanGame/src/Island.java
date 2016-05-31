/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 *
 * @author Marisa Abril
 */
public class Island extends GameObject{
    
    Random gen;
    private final Wingman outer;

    Island(Image img, int x, int y, int speed, Random gen, final Wingman outer) {
        super(img, x,y,speed);
        this.outer = outer;
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gen = gen;
    }

    public void update() {
        y += speed;
        if (y >= outer.h) {
            y = -100;
            x = Math.abs(gen.nextInt() % (outer.w - 30));
        }
    }

    public void draw(ImageObserver obs) {
        outer.g2.drawImage(img, x, y, obs);
    }
    
}
