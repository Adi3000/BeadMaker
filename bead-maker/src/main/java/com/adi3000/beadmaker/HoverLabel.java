package com.adi3000.beadmaker;

import com.adi3000.beadmaker.core.component.swing.BorderMaker;

import javax.swing.*;
import java.awt.*;

public class HoverLabel extends JLabel {
	
	public Color bgColor = new Color(1,1,1);
	
	HoverLabel(String labelName) {
		super(labelName);
		//this.setPreferredSize(new Dimension(80, 30));
		this.setPreferredSize(new Dimension(450, 60));
		this.setMaximumSize(new Dimension(450, 60));
		
		this.setOpaque(true);
		
		//this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setBorder(new BorderMaker(BorderMaker.NONE, 20, 0));
		
		/*
		int outerMarginSize_Top, 
		int outerMarginSize_Left, 
		int outerMarginSize_Bottom, 
		int outerMarginSize_Right,
		int innerMarginSize
		*/
	}
	
	
	public void paintComponent(Graphics g){  
        super.paintComponent(g);
        //ConsoleHelper.PrintMessage("REDRAWING HOVER LABEL%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        this.setBackground(bgColor);
    }
}
