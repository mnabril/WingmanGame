/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wingman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

/**
 *
 * @author Marisa Abril
 */
public class Timeline {

    static int frame = 0;
    int x, y;
    Random gen;
    Wingman wingman;
    Enemy e1;
    MyPlane m;
    //Sound s;
    ImageObserver obs;
    Image img, enemy_1, enemy_2, enemy_3, enemy_4, power_up, enemy_bullet, enemy_bullet2;
    Bullet b;
    Image[] explosion1, explosion2;
    Explosion explosion;
    PowerUp p;
    Enemy boss_plane;
    EnemyBullet enemy_bull;

    ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    ArrayList<PowerUp> pow = new ArrayList<PowerUp>();
    static ArrayList<Explosion> explosions = new ArrayList<Explosion>();
    public ListIterator<Explosion> explosionIt = explosions.listIterator();
    ArrayList<EnemyBullet> enemy_bullets = new ArrayList<EnemyBullet>();

    Timeline(Image enemy_1, Image enemy_2, Image enemy_3, Image enemy_4, Image power_up,
            Image enemy_bullet, Image enemy_bullet2, Random gen,
            Image[] explosion1, Image[] explosion2, Wingman wingman) {

        this.enemy_1 = enemy_1;
        this.enemy_2 = enemy_2;
        this.enemy_3 = enemy_3;
        this.enemy_4 = enemy_4;
        this.power_up = power_up;
        this.enemy_bullet = enemy_bullet;
        this.enemy_bullet2 = enemy_bullet2;
        this.gen = gen;
        this.explosion1 = explosion1;
        this.explosion2 = explosion2;
        this.wingman = wingman;
    }

    public void update() {
        frame++;

        for (int j = 0; j < enemy.size(); j++) {
            e1 = enemy.get(j);
            if (e1.getY() > wingman.h) {
                enemy.remove(e1);

            } else if (Collisions.enemyVSplayer(wingman.m, e1, wingman)) {
                enemy.remove(e1);
                HealthBar.healthPoints1--;

            } else if (Collisions.enemyVSplayer(wingman.n, e1, wingman)) {
                enemy.remove(e1);
                HealthBar.healthPoints2--;

            } else if (Collisions.enemyVSplayerBullet(wingman.m.bullets, e1, wingman)) {
                enemy.remove(e1);
                Enemy.scoreP1 += 10;

            } else if (Collisions.enemyVSplayerBullet(wingman.n.bullets2, e1, wingman)) {
                enemy.remove(e1);
                Enemy.scoreP2 += 10;

            }
            e1.update();
        }
        for (int j = 0; j < pow.size(); j++) {
            p = pow.get(j);
            if (p.getY() > wingman.h) {
                pow.remove(p);

            } else if (Collisions.playerVSpowerUp(wingman.m, p, wingman)) {
                if (HealthBar.healthPoints1 < 4){
                    HealthBar.healthPoints1++;
                }else if (HealthBar.healthPoints1 == 4 && HealthBar.lives1 < 2){
                    HealthBar.lives1++;
                    HealthBar.healthPoints1 = 1;
                }
                pow.remove(p);

            } else if (Collisions.playerVSpowerUp(wingman.n, p, wingman)) {
                if (HealthBar.healthPoints2 < 4){
                    HealthBar.healthPoints2++;
                }else if (HealthBar.healthPoints2 == 4 && HealthBar.lives2 < 2){
                    HealthBar.lives2++;
                    HealthBar.healthPoints2 = 1;
                }
                pow.remove(p);
            }
            p.update();
        }
        for (int j = 0; j < enemy_bullets.size(); j++) {
            enemy_bull = enemy_bullets.get(j);
            if (enemy_bull.getY() > wingman.h) {
                enemy_bullets.remove(enemy_bull);

            } else if (Collisions.enemyBulletVSplayer(enemy_bullets, wingman.m, wingman)) {
                enemy_bullets.remove(enemy_bull);
                HealthBar.healthPoints1--;

            } else if (Collisions.enemyBulletVSplayer(enemy_bullets, wingman.n, wingman)) {
                enemy_bullets.remove(enemy_bull);
                HealthBar.healthPoints2--;
            }
            enemy_bull.update();
        }

        if (frame < 500) {
            
            if (frame % 40 == 0) {
                enemy.add(new Enemy(enemy_1, Math.abs(gen.nextInt() % (600 - 30)), -10, 2, gen, explosion1, wingman));
                //enemy.add(new SideEnemy(enemy_4, Math.abs(gen.nextInt() % (600 - 30)), 480, 2, 3, gen, explosion1, wingman));
                //enemy.add(new SideEnemy(enemy_2, 700, Math.abs(gen.nextInt() % (600 - 30)), 2, 1, gen, explosion1, wingman));
                
            
            }
        } else if (frame > 500 && frame < 1000) {
            if (frame % 30 == 0) {
                enemy.add(new Enemy(enemy_1, Math.abs(gen.nextInt() % (600 - 30)), 0, 2, gen, explosion1, wingman));
            }
            if (frame % 20 == 0) {
                enemy_bullets.add(new EnemyBullet(enemy_bullet, e1.x, e1.y, 4, 1, wingman));

            }
                if (frame % 150 == 0) {
                    pow.add(new PowerUp(power_up, Math.abs(gen.nextInt() % (600 - 30)), 0, 1, gen, wingman));
                }
        } else if (frame > 1000 && frame < 1500) {
            if (frame % 40 == 0) {
                enemy.add(new Enemy(enemy_1, Math.abs(gen.nextInt() % (600 - 30)), 0, 2, gen, explosion1, wingman));
                enemy.add(new SideEnemy(enemy_2, 700, Math.abs(gen.nextInt() % (600 - 30)), 2, 1, gen, explosion1, wingman));
            }
            if (frame % 15 == 0) {
                enemy_bullets.add(new EnemyBullet(enemy_bullet, e1.x, e1.y, 4, 2, wingman));

            }
        } else if (frame > 1500 && frame < 2000) {
            if (frame % 40 == 0) {
                enemy.add(new Enemy(enemy_1, Math.abs(gen.nextInt() % (600 - 30)), 0, 2, gen, explosion1, wingman));
                //enemy.add(new SideEnemy(enemy_3, -10, Math.abs(gen.nextInt() % (600 - 30)), 2, 2, gen, explosion1, wingman));

            }
            if (frame % 20 == 0) {
                enemy_bullets.add(new EnemyBullet(enemy_bullet, e1.x, e1.y, 4, 3, wingman));
            }
        } else if (frame > 2000 && frame < 4500) {
            if (frame % 40 == 0) {
                //enemy.add(new Enemy(enemy_1, Math.abs(gen.nextInt() % (600 - 30)), 0, 2, gen, explosion1, wingman));
                //enemy.add(new SideEnemy(enemy_2, 700, Math.abs(gen.nextInt() % (600 - 30)), 2, 1, gen, explosion1, wingman));
                enemy.add(new SideEnemy(enemy_3, -10, Math.abs(gen.nextInt() % (600 - 30)), 2, 2, gen, explosion1, wingman));
                enemy.add(new SideEnemy(enemy_4, Math.abs(gen.nextInt() % (600 - 30)), 480, 2, 3, gen, explosion1, wingman));
                
                if (frame % 200 == 0) {
                    pow.add(new PowerUp(power_up, Math.abs(gen.nextInt() % (600 - 30)), 0, 1, gen, wingman));
                }
            }

        }else if (frame > 5000 && frame < 6000) {
            if (frame % 50 == 0) {
                enemy.add(new Enemy(enemy_1, Math.abs(gen.nextInt() % (600 - 30)), 0, 2, gen, explosion1, wingman));
                enemy.add(new SideEnemy(enemy_2, 700, Math.abs(gen.nextInt() % (600 - 30)), 2, 1, gen, explosion1, wingman));
                enemy.add(new SideEnemy(enemy_3, -10, Math.abs(gen.nextInt() % (600 - 30)), 2, 2, gen, explosion1, wingman));
                enemy.add(new SideEnemy(enemy_4, Math.abs(gen.nextInt() % (600 - 30)), 480, 2, 3, gen, explosion1, wingman));
                 if (frame % 20 == 0) {
                enemy_bullets.add(new EnemyBullet(enemy_bullet, e1.x, e1.y, 4, 3, wingman));
                }   
                if (frame % 200 == 0) {
                    pow.add(new PowerUp(power_up, Math.abs(gen.nextInt() % (600 - 30)), 0, 1, gen, wingman));
                }
            }
        }if (frame == 6200){
            Wingman.gameOver = true;
        }
    
}

    public void draw(Graphics g, ImageObserver obs) {
        g.drawImage(img, x, y, obs);
        for (int i = 0; i < pow.size(); i++) {
            p = pow.get(i);
            p.draw(g, obs);
        }
        
        for (int i = 0; i < enemy.size(); i++) {
            e1 = enemy.get(i);
            e1.draw(g, obs);
        }
        
        for (int i = 0; i < enemy_bullets.size(); i++) {
            enemy_bull = enemy_bullets.get(i);
            enemy_bull.draw(g, obs);
        }
        
        for (int t = 0; t < explosions.size(); t++) {
            explosion = explosions.get(t);
            explosion.draw(g, obs);

            if (explosion.explosionFinished == true) {
                explosions.remove(t);
                //System.out.println("explosion removed from array");
            }
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Time: " + frame/60, 285, 30);
        g.drawString("Player 2 Score: " + Enemy.scoreP1, 400, 20);
        g.drawString("Player 1 Score: " + Enemy.scoreP2, 110, 20);
    }

}
