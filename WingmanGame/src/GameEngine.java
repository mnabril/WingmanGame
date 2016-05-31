/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author Noelani Abril
 */
public abstract class GameEngine extends JApplet implements Runnable {
    static boolean gameOver;
    
    public static void main(String[] argv) {
        final Wingman demo = new Wingman();
        demo.init();
        JFrame f = new JFrame("Wingman Game");
        f.addWindowListener(new WindowAdapter() {
        });
        f.getContentPane().add("Center", demo);
        f.pack();
        f.setSize(new Dimension(640, 480));
        f.setVisible(true);
        f.setResizable(false);
        demo.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    protected Thread thread;
    protected BufferedImage bimg;
    Graphics2D g2;
    int speed = 1;
    Random generator = new Random(1234567);
    int w = 640;
    int h = 480; // fixed size window game
    GameEvents gameEvents;
    Sound background_music;

    public void init() {
        setBackground(Color.white);
        try {
            this.setFocusable(true);
        } catch (Exception e) {
            System.out.print("No resources are found");
        }
    }

    public void drawBackGroundWithTileImage() {
        
    }

    public void drawDemo(int w, int h, Graphics2D g2) {
        
        
    }

    public void paint(Graphics g) {
        if (bimg == null) {
            Dimension windowSize = getSize();
            bimg = (BufferedImage) createImage(windowSize.width, windowSize.height);
            g2 = bimg.createGraphics();
        }
        drawDemo(w, h, g2);
        g.drawImage(bimg, 0, 0, this);
    }

    public void start() {
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
            try {
                thread.sleep(15);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
}
