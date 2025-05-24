package com.paintprogram.model;

import com.paintprogram.controller.GridMouse;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ColorGrid {

    final private ArrayList<Color> colors = new ArrayList<Color>();
    private Color currentColor;
    private PaintDetails paintD;
    private GridMouse mouse;

    final private ArrayList<Rectangle> recs = new ArrayList<>();

    public ColorGrid(PaintDetails paintD, GridMouse mouse){
        initializeColors();

        this.paintD = paintD;
        this.mouse = mouse;

        updateRectangles();
    }

    public void initializeColors(){
        colors.add(Color.BLACK);
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);

        currentColor = Color.BLACK;
    }

    public void updateRectangles(){

        int x = 10;
        int y = 10;
        int colorSize = paintD.getHeight()/20;
        int distance = colorSize/3;

        int currentX = x;

        for(Color color:colors){
            recs.add(new Rectangle(currentX, y, colorSize, colorSize));
            currentX += (colorSize + distance);
        }

    }

    public Color[] getColors(){
        Color[] colorsArray = new Color[colors.size()];
        return colors.toArray(colorsArray);
    }

    public Color getCurrentColor(){
        return currentColor;
    }

    public ArrayList<Rectangle> getRectangles(){
        return recs;
    }

    public void update(){

        // Update the Rectangle ArrayList with the frame size
        int x = 10;
        int y = 10;
        int colorSize = paintD.getHeight()/20;
        int distance = colorSize/3;

        int currentX = x;

        for(Color color:colors){
            recs.set(colors.indexOf(color), new Rectangle(currentX, y, colorSize, colorSize));
            currentX += (colorSize + distance);
        }

        //Update currentColor by mouseclicks
        try {
            for (Rectangle rec : recs) {
                if (rec.contains(mouse.getClickedPoint())) {
                    currentColor = colors.get(recs.indexOf(rec));
                    System.out.println(currentColor);
                    mouse.setClickedPoint(new Point(0, 0));
                }
            }
        } catch(Exception e){}
    }

    public void draw(Graphics2D g2){

        int i = 0;

        for(Color color:colors){
            g2.setColor(Color.BLACK);
            g2.draw(recs.get(i));
            g2.setColor(color);
            g2.fill(recs.get(i));
            i++;
        }
    }
}
