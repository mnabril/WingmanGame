/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wingman;

import java.util.ArrayList;

/**
 *
 * @author Marisa Abril
 */
public class Collisions {

    
    Collisions() {

    }

    public static boolean enemyVSplayer(MyPlane m, Enemy e1, Wingman wingman) {

        if (m.collision(e1.x, e1.y, e1.width, e1.height)) {
            Timeline.explosions.add(new Explosion(e1.x, e1.y, wingman.explosion1, wingman));
            wingman.exp_1.play();
            return true;
        }
        return false;
    }

    public static boolean enemyVSplayerBullet(ArrayList<Bullet> bullets, Enemy e1, Wingman wingman) {
            for (int k = 0; k < bullets.size(); k++) {
                Bullet bull = bullets.get(k);
                if (bull.collision(e1.x, e1.y, e1.width, e1.height)) {
                    Timeline.explosions.add(new Explosion(e1.x, e1.y, wingman.explosion1, wingman));
                    wingman.exp_1.play();
                    bullets.remove(bull);
                    return true;
                }
            }
            return false;
    }
    public static boolean enemyBulletVSplayer(ArrayList<EnemyBullet> enemy_bullets, MyPlane m, Wingman wingman) {
        for (int k = 0; k < enemy_bullets.size(); k++) {
            EnemyBullet bull = enemy_bullets.get(k);
            if (bull.collision(m.x, m.y, m.width, m.height)) {
                wingman.exp_1.play();
                enemy_bullets.remove(bull);
                return true;
            }
        }
        return false;
    }
    public static boolean playerVSpowerUp(MyPlane m, PowerUp p, Wingman wingman) {

        if (m.collision(p.x, p.y, p.width, p.height)) {
            return true;
        }
        return false;
    }
}
