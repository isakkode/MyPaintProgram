package com.paintprogram.view;

import javax.swing.JFrame;
import com.paintprogram.model.*;

public class PaintFrame{

    private JFrame jframe;


    public PaintFrame() {


        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setTitle("MPP: My Personal Paint");


        PaintDetails paintD = new PaintDetails(this);
        PaintPanel paintPanel = new PaintPanel(paintD);
        jframe.add(paintPanel);

        jframe.pack();

        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        paintPanel.startPaintThread();

    }


    public JFrame getFrame(){
        return jframe;
    }



}
