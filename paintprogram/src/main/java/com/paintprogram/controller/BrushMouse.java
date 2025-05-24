package com.paintprogram.controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrushMouse extends MouseAdapter {

    private boolean dragging = false;
    private Point pressedPoint = null;

    @Override
    public void mousePressed(MouseEvent e){
        dragging = true;
        pressedPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e){
        dragging = false;
        pressedPoint = null;
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if(dragging){
            pressedPoint = e.getPoint();
        }
    }

    public Point getPressedPoint(){
        return pressedPoint;
    }

    public boolean isDragging(){
        return dragging;
    }
}
