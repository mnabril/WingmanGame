package Wingman;
/**
 *
 * @author Marisa Abril
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;
import java.util.Observable;

public class SideEnemy extends Enemy {

    int type;

    SideEnemy(Image img, int x, int y, int speed, int type, Random gen, Image [] explosion, Wingman wingman) {

        super(img, x, y, speed, gen, explosion,wingman);

        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gen = gen;
        this.type = type;
        this.wingman = wingman;

        width = img.getWidth(null);
        height = img.getHeight(null);
    }
    public void update() {

        if (type == 1) {
            x -= speed;
        } else if (type == 2) {
            x += speed;
        } else if (type == 3) {
            y -= speed;
        }
    }
    public void update(Observable o, Object obj){
        
    }
    public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
        
        
    }
    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

}
