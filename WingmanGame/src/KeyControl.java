/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Marisa Abril
 */
public class KeyControl extends KeyAdapter {
    Wingman wingman;

    KeyControl(Wingman wingman) {
        this.wingman = wingman;
    }

    public void keyPressed(KeyEvent e) {
       wingman.gameEvents.setValue(e);
    }
    public void keyReleased(KeyEvent e) {
        wingman.gameEvents.setValue(e);
    }
    
}
