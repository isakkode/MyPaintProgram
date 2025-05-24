package com.paintprogram.model;

import com.paintprogram.view.PaintFrame;

import java.awt.*;

public class PaintDetails {

    PaintFrame frame;
    private int screenWidth;
    private int screenHeight;

    public PaintDetails(PaintFrame frame){
        this.frame = frame;
        this.screenWidth = frame.getFrame().getWidth();
        this.screenHeight = frame.getFrame().getHeight();
    }


    public void update(){
        this.screenWidth = frame.getFrame().getWidth();
        this.screenHeight = frame.getFrame().getHeight();

        int i = 0;
        if(i<20){
            i++;
        }
        else{
            System.out.println(getWidth());
            i=0;
        }
    }

    public int getWidth(){
        return screenWidth;
    }

    public int getHeight(){
        return screenHeight;
    }
}
