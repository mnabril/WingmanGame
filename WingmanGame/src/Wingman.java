package Wingman;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Font;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Marisa Abril
 */
public class Wingman extends GameEngine {

    Image sea;
    Image myPlane, gameOverPic;
    Image myBullet, myBullet_left, myBullet_right, enemy_1, enemy_2, enemy_3, enemy_4, boss;
    Image power_up, health, health1, health2, health3;
    Image small_explosion, small_explosion1, small_explosion2, small_explosion3,
            small_explosion4, small_explosion5, big_explosion, big_explosion1, big_explosion2, big_explosion3,
            big_explosion4, big_explosion5, enemy_bullet, enemy_bullet2;
    static Image life;
    int speed = 1, move = 0;
    Island I1;
    Island I2, I3;
    MyPlane m, n;
    Enemy e1;
    Sound exp_1, exp_2;
   
    Bullet b, b2;
   
    Timeline t;
    Explosion exp_small, exp_large, exp;
    HealthBar hBar;
//    static boolean powerPickedUp1 = false;
//    static boolean powerPickedUp2 = false;

    Image[] explosion1 = new Image[6];
    Image[] explosion2 = new Image[6];
    //ArrayList<Explosion> explosions = new ArrayList<Explosion>();
    //public ListIterator<Explosion> explosionIt = explosions.listIterator();
    
public void init() {
        setBackground(Color.white);
        Image island1;
        Image island2;
        Image island3;
        try {
            sea = ImageIO.read(new File("Resources/water.png"));
            island1 = ImageIO.read(new File("Resources/island1.png"));
            island2 = ImageIO.read(new File("Resources/island2.png"));
            island3 = ImageIO.read(new File("Resources/island3.png"));
            myPlane = ImageIO.read(new File("Resources/myplane_1.png"));
            myBullet = ImageIO.read(new File("Resources/bullet.png"));
            myBullet_left = ImageIO.read(new File("Resources/bulletLeft.png"));
            myBullet_right = ImageIO.read(new File("Resources/bulletRight.png"));
            enemy_1 = ImageIO.read(new File("Resources/enemy1_1.png"));
            enemy_2 = ImageIO.read(new File("Resources/enemy2_3.png"));
            enemy_3 = ImageIO.read(new File("Resources/enemy3_3.png"));
            enemy_4 = ImageIO.read(new File("Resources/enemy4_3.png"));
            health = ImageIO.read(new File("Resources/health.png"));
            health1 = ImageIO.read(new File("Resources/health1.png"));
            health2 = ImageIO.read(new File("Resources/health2.png"));
            health3 = ImageIO.read(new File("Resources/health3.png"));
            life = ImageIO.read(new File("Resources/life.png"));
            small_explosion = ImageIO.read(new File("Resources/explosion1_1.png"));
            small_explosion1 = ImageIO.read(new File("Resources/explosion1_2.png"));
            small_explosion2 = ImageIO.read(new File("Resources/explosion1_3.png"));
            small_explosion3 = ImageIO.read(new File("Resources/explosion1_4.png"));
            small_explosion4 = ImageIO.read(new File("Resources/explosion1_5.png"));
            small_explosion5 = ImageIO.read(new File("Resources/explosion1_6.png"));
            big_explosion = ImageIO.read(new File("Resources/explosion2_1.png"));
            big_explosion1 = ImageIO.read(new File("Resources/explosion2_2.png"));
            big_explosion2 = ImageIO.read(new File("Resources/explosion2_3.png"));
            big_explosion3 = ImageIO.read(new File("Resources/explosion2_4.png"));
            big_explosion4 = ImageIO.read(new File("Resources/explosion2_5.png"));
            big_explosion5 = ImageIO.read(new File("Resources/explosion2_6.png"));
            gameOverPic = ImageIO.read(new File("Resources/gameOver.png"));
            power_up = ImageIO.read(new File("Resources/powerup_health.png"));
            enemy_bullet = ImageIO.read(new File("Resources/enemybullet1.png"));
            enemy_bullet2 = ImageIO.read(new File("Resources/enemybullet2.png"));
            background_music = new Sound("Resources/background_music.wav");
            exp_1 = new Sound("Resources/snd_explosion1.wav");
            exp_2 = new Sound("Resources/snd_explosion2.wav");
            
//            background_music.play();
//            background_music.loop();
             
            explosion1[0] = small_explosion;
            explosion1[1] = small_explosion1;
            explosion1[2] = small_explosion2;
            explosion1[3] = small_explosion3;
            explosion1[4] = small_explosion4;
            explosion1[5] = small_explosion5;
            explosion2[0] = big_explosion;
            explosion2[1] = big_explosion1;
            explosion2[2] = big_explosion2;
            explosion2[3] = big_explosion3;
            explosion2[4] = big_explosion4;
            explosion2[5] = big_explosion5;
            
            I1 = new Island(island1, 100, 100, speed, generator, this);
            I2 = new Island(island2, 200, 400, speed, generator, this);
            I3 = new Island(island3, 300, 200, speed, generator, this);
            e1 = new Enemy(enemy_1, 100, -10, 2, generator, explosion1, this);
            
            gameOver = false;
            
            m = new MyPlane(myPlane, 450, 300, 5, this);
            n = new MyPlane(myPlane, 100, 300, 5, this);
            t = new Timeline(enemy_1, enemy_2, enemy_3, enemy_4, power_up, enemy_bullet, 
                    enemy_bullet2, generator, explosion1, explosion2, this);
            exp_small = new Explosion(e1.x, e1.y, explosion1, this);
            exp_large = new Explosion(m.getX(), m.getY(), explosion2, this);
            hBar = new HealthBar(health, health1, health2, health3, life, explosion2, 0, 0, this);
            
            KeyControl key = new KeyControl(this);
            addKeyListener(key);
            gameEvents = new GameEvents(this);
            gameEvents.addObserver(m);
            gameEvents.addObserver(n);
            gameEvents.addObserver(e1);
            this.setFocusable(true);
        } catch (Exception e) {
            System.out.print("No resources are found");
        }
    }

    public void drawBackGroundWithTileImage() {
        int TileWidth = sea.getWidth(this);
        int TileHeight = sea.getHeight(this);
        int NumberX = (int) (w / TileWidth);
        int NumberY = (int) (h / TileHeight);
        for (int i = -1; i <= NumberY; i++) {
            for (int j = 0; j <= NumberX; j++) {
                g2.drawImage(sea, j * TileWidth, i * TileHeight + (move % TileHeight), TileWidth, TileHeight, this);
            }
        }
        move += speed;
    }

    public void drawDemo(int w, int h, Graphics2D g2) {
        if (!gameOver) {
            drawBackGroundWithTileImage();
            I1.update();
            I2.update();
            I3.update();
            
            I1.draw(this);
            I2.draw(this);
            I3.draw(this);
            t.update();
            t.draw(g2, this);
            m.draw(g2, this);
            n.draw(g2, this);
            hBar.draw(g2, this);
            for (int i = 0; i < m.bullets.size(); i++) {
                b = m.bullets.get(i);
                if (b.getY() < 0) {
                    m.bullets.remove(i);
                } else {
                    b.update();
                    b.draw(g2);
                }
            }
            for (int i = 0; i < n.bullets2.size(); i++) {
                b2 = n.bullets2.get(i);
                if (b2.getY() < 0) {
                    n.bullets2.remove(i);
                } else {
                    b2.update();
                    b2.draw(g2);
                }
            }
        } else {
            background_music.stop();
            drawBackGroundWithTileImage();
            I1.update();
            I2.update();
            I3.update();
            I1.draw(this);
            I2.draw(this);
            I3.draw(this);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            g2.drawString("GAME OVER!", 220, 150);
            g2.setColor(Color.red);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Player 2 Score: " + Enemy.scoreP1, 400, 250);
            g2.setColor(Color.green);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Player 1 Score: " + Enemy.scoreP2, 60, 250);
        }
    }
}
