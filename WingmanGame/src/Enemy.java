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
import java.util.Random;

/**
 *
 * @author Marisa Abril
 */
public class Enemy extends GameObject {
    
    Random gen;
    boolean show;
    Wingman wingman;
    Image[] explosion;
    Rectangle ebox;
    Explosion exp;
    static int scoreP1 = 0;
    static int scoreP2 = 0;

    Enemy(Image img, int x, int y, int speed, Random gen, Image[] explosion, Wingman wingman) {

        super(img, x, y, speed);

        this.wingman = wingman;
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gen = gen;
        this.show = true;
        this.explosion = explosion;
        width = img.getWidth(null);
        height = img.getHeight(null);
        
    }

    public void update() {
        
            y += speed;

//        if (Collisions.enemyVSplayer(wingman.m, this, wingman)){
//            wingman.gameEvents.setValue("Plane1/Enemy Collision");
//            wingman.gameEvents.setValue("");
//            
//        }else if (Collisions.enemyVSplayer(wingman.n, this, wingman)){
//            wingman.gameEvents.setValue("Plane2/Enemy Collision");
//            wingman.gameEvents.setValue("");
//            
//        }else if (Collisions.enemyVSplayerBullet(wingman.m.bullets, this, wingman) ||
//            Collisions.enemyVSplayerBullet(wingman.n.bullets2, this, wingman)){
//            wingman.gameEvents.setValue("Bullet/Enemy Collision");
//            wingman.gameEvents.setValue("");
//        }
    }

    public void update(Observable obj, Object arg) {
        GameEvents ge = (GameEvents) arg;
        if (ge.type == 2) {
//            String msg = (String) ge.event;
//            if (msg.equals("Plane1/Enemy Collision")) {
//                //System.out.println("Enemy exploded");
//                //lose health here! healthpoints--;
//                //trigger explosion
//                //HealthBar.healthPoints1--; 
//            }else if (msg.equals("Plane2/Enemy Collision")) {
//                //System.out.println("Enemy exploded");
//                //lose health here! healthpoints--;
//                //trigger explosion
//                //HealthBar.healthPoints2--; 
//            }else if (msg.equals("Bullet/Enemy Collision")) {
//                        
//            }   
//                
        }
    }

    public void reset() {
        this.x = Math.abs(gen.nextInt() % (600 - 30));
        this.y = -10;
    }

    public void draw(Graphics g, ImageObserver obs) {
        g.drawImage(img, x, y, obs);

    }

}
