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
public class HealthBar extends GameObject {

    Wingman wingman;
    Image health, health1, health2, health3, life;
    Image[] explosion2;

    static int healthPoints1 = 4, healthPoints2 = 4, lives1 = 2, lives2 = 2;

    HealthBar(Image health, Image health1, Image health2, Image health3, Image img, Image[] explosion2, int x,
            int y, Wingman wingman) {
        super(img, x, y, 0);
        this.wingman = wingman;
        this.health = health;
        this.health1 = health1;
        this.health2 = health2;
        this.health3 = health3;
        this.life = img;
        this.explosion2 = explosion2;

    }

    public void update() {

    }

    public void draw(Graphics g, ImageObserver obs) {

        if (lives1 > 0) {
            if (healthPoints1 == 4) {
                g.drawImage(health, 420, 410, obs);

            } else if (healthPoints1 == 3) {
                g.drawImage(health1, 420, 410, obs);

            } else if (healthPoints1 == 2) {
                g.drawImage(health2, 420, 410, obs);

            } else if (healthPoints1 == 1) {
                g.drawImage(health3, 420, 410, obs);

            } else if (healthPoints1 == 0) {
                lives1--;
                Timeline.explosions.add(new Explosion(wingman.m.getX(), wingman.m.y, wingman.explosion2, wingman));
//                Explosion explode = new Explosion(wingman.m.getX(), wingman.m.getY(),wingman.explosion2, wingman);
//                explode.draw(g, obs);
                wingman.exp_2.play();
                healthPoints1 = 4;

            }

            if (lives1 == 2) {
                g.drawImage(life, 520, 375, obs);
                g.drawImage(life, 495, 375, obs);
            } else if (lives1 == 1) {
                g.drawImage(life, 520, 375, obs);
            } else if (lives1 == 0) {
                //g.drawString("Player 1 dead", 440, 430);
                wingman.m.x = 1000;

            }
        }

        if (lives2 > 0) {
            if (healthPoints2 == 4) {
                g.drawImage(health, 75, 410, obs);

            } else if (healthPoints2 == 3) {
                g.drawImage(health1, 75, 410, obs);

            } else if (healthPoints2 == 2) {
                g.drawImage(health2, 75, 410, obs);

            } else if (healthPoints2 == 1) {
                g.drawImage(health3, 75, 410, obs);

            } else if (healthPoints2 == 0) {
                lives2--;
                Timeline.explosions.add(new Explosion(wingman.n.getX(), wingman.n.y, wingman.explosion2, wingman));
                wingman.exp_2.play();
                healthPoints2 = 4;

            }
            if (lives2 == 2) {
                g.drawImage(life, 175, 375, obs);
                g.drawImage(life, 150, 375, obs);
            } else if (lives2 == 1) {
                g.drawImage(life, 170, 375, obs);
            } else if (lives2 == 0) {
                //g.drawString("Player 2 dead", 90, 410);
                wingman.n.x = 1000;
            }
        }

        if (lives1 == 0 && lives2 == 0) {
            wingman.gameOver = true;
        }
    }

}
