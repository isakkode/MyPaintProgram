package com.paintprogram.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

public class GridMouse implements MouseListener{

    private Point clickedPoint = new Point(0, 0);
    private Point pressedPoint = new Point(0, 0);

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!e.getPoint().equals(new Point(0, 0))){
            clickedPoint = e.getPoint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!e.getPoint().equals(new Point(0, 0))){
            pressedPoint = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressedPoint = new Point(0, 0);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Point getClickedPoint(){
        return this.clickedPoint;
    }

    public Point getPressedPoint(){
        return this.pressedPoint;
    }

    public void setClickedPoint(Point p){
        clickedPoint = p;
    }

    public void setPressedPoint(Point p){
        pressedPoint = p;
    }

}
