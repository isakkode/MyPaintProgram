package com.paintprogram.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.paintprogram.controller.BrushMouse;
import com.paintprogram.controller.GridMouse;
import com.paintprogram.model.Brush;
import com.paintprogram.model.ColorGrid;
import com.paintprogram.model.PaintDetails;

public class PaintPanel extends JPanel implements Runnable {

    private PaintDetails paintD;
    private Thread paintThread;
    private GridMouse gMouse = new GridMouse();
    private BrushMouse bMouse = new BrushMouse();
    private ColorGrid colorGrid;
    private Brush brush;


    public PaintPanel(PaintDetails paintD){
        this.paintD = paintD;
        colorGrid = new ColorGrid(paintD, gMouse);
        brush = new Brush(colorGrid, bMouse);

        this.setPreferredSize(new Dimension(700, 700));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(gMouse);
        this.addMouseMotionListener(bMouse);
        this.addMouseListener(bMouse);
    }

    public void startPaintThread(){
        paintThread = new Thread(this);
        paintThread.start();
    }

    @Override
    public void run(){

        int FPS = 100;
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // Game loop
        while(paintThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1) {
                // 1 Update information like chraracter positions
                update();

                // 2 Draw the screen with updated information
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        paintD.update();
        colorGrid.update();
        brush.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        colorGrid.draw(g2);

        brush.draw(g2);

        g2.dispose();
    }

}
