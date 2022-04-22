package com.adi3000.beadmaker;

import javax.swing.*;
import java.awt.*;

public class PaletteSubPanel extends JPanel {
	
	Color bgColor = new Color(204,204,204);
	PaletteCheckBox paletteCheckBox;
	PaletteButton paletteButton;
	
	public InterObjectCommunicator oComm;
	
	public PaletteSubPanel (String label, Color color, Palette pallette, int colorIndex, boolean isChecked, InterObjectCommunicator myOComm) {
		super();
		oComm = myOComm;
		this.bgColor = color;
		this.paletteCheckBox = new PaletteCheckBox("", isChecked, pallette, colorIndex, oComm);
		this.paletteButton = new PaletteButton(label, color, colorIndex, pallette);
		
		setPreferredSize(new Dimension(270, 30));
		setMaximumSize(new Dimension(270, 30));
		
		add(paletteCheckBox);
		add(paletteButton);
	}
	
	public void paintComponent(Graphics g){  
		super.paintComponent(g);
		this.setBackground(bgColor);
	}
	

}
