/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.event.KeyEvent;
import java.util.Observable;

/**
 *
 * @author Marisa Abril
 */
public class GameEvents extends Observable {
    int type;
    Object event;
    Wingman wingman;

    public GameEvents(Wingman wingman) {
        this.wingman = wingman;
    }

    public void setValue(KeyEvent e) {
        type = 1; // let's assume this means key input.
        //Should use CONSTANT value for this when you program
        event = e;
        setChanged();
        // trigger notification
        notifyObservers(this);
    }

    public void setValue(String msg) {
        type = 2;
        event = msg;
        setChanged();
        // trigger notification
        notifyObservers(this);
    }
    
}
