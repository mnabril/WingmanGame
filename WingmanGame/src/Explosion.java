/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Marisa Abril
 */
public class Explosion{
    
    int i, x, y;
    Image [] explosion1;
    int frameNum = 0;
    Wingman wingman;
    ImageObserver obs;
    Graphics g;
    
    static boolean explosionFinished = false;
    Explosion(int x, int y, Image [] explosion1, Wingman wingman){
        
        this.x = x;
        this.y = y;
        this.explosion1 = explosion1;
        this.wingman = wingman;
  
    }
    public void draw(Graphics g, ImageObserver obs) {
            for (i =0; i< 6;i++){
                g.drawImage(explosion1[i],this.x, this.y, obs);
        }
            explosionFinished = true;
    }
    
    
    
}
