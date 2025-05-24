package com.paintprogram.model;

import com.paintprogram.controller.BrushMouse;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class Brush {

    ColorGrid colorGrid;
    BrushMouse mouse;
    HashMap<Color, ArrayList<Rectangle>> paintedAreas;

    int strokeSize = 5;

    public Brush(ColorGrid colorGrid, BrushMouse mouse){
        this.colorGrid = colorGrid;
        this.mouse = mouse;
        paintedAreas = new HashMap<>();

        initializePaintAreas();
    }

    private void initializePaintAreas(){
        for(Color color: colorGrid.getColors()){
            paintedAreas.put(color, new ArrayList<>());
        }
    }

    public void update(){
        boolean pass = false;

        // Checks if the pressed point is in one of the colors
        try{
            boolean noneContain = colorGrid.getRectangles().stream().
                noneMatch(r -> r.contains(mouse.getPressedPoint()));

            if(noneContain){
                pass = true;
            }

        } catch(NullPointerException e){}

        // Adds pressedPoint to paintedAreas
        if(mouse.isDragging() && pass){
            Point p = mouse.getPressedPoint();
            paintedAreas.get(colorGrid.getCurrentColor()).add(new Rectangle(p.x, p.y, strokeSize, strokeSize));
        }

        pass = false;
    }

    public void draw(Graphics2D g2) {
        paintedAreas.forEach((k, v) -> {
            for (Rectangle rec : v) {
                g2.setColor(k);
                g2.fill(rec);
            }
        });
    }

}
