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
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Marisa Abril
 */
public abstract class GameObject implements Observer {

    Image img;
    int x;
    int y;
    int speed;
    int width;
    int height;
    Rectangle bbox;
    ImageObserver obs;
    

    public GameObject(Image img, int x, int y, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        bbox = new Rectangle(x, y, img.getWidth(this.obs), img.getHeight(this.obs));
    }

    public void draw(Graphics g, ImageObserver obs) {
        g.drawImage(img, x, y, obs);
    }

    public void update(Observable obj, Object arg) {
    }

    public int getX() {
        return this.x;

    }

    public int getY() {
        return this.y;

    }
}
