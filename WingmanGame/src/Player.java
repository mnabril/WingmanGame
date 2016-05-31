/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Marisa Abril
 */
public abstract class Player extends GameObject {
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Bullet> bullets2 = new ArrayList<Bullet>();
    
    
    public Player(Image img, int x, int y, int speed) {
        super(img, x, y, speed);
       
    }
    
}
