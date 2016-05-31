/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Image;

/**
 *
 * @author Marisa Abril
 */
public class EnemyBullet extends Bullet{
    Wingman wingman;
    int type;
    public EnemyBullet(Image img, int x, int y, int speed, int type, Wingman wingman) {
        super(img, x, y, speed, wingman);
        this.type = type;
        this.wingman = wingman;
        
    }
    
    public void update(){
        if (type == 1){
            y+=speed;
        }if (type== 2){
            y+=speed;
            x+=speed;
        }
        if (type== 3){
            y+=speed;
            x-=speed;
        }
        
    }
    
    
    
}
