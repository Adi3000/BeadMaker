package com.adi3000.beadmaker;

import com.adi3000.beadmaker.core.component.swing.BorderMaker;

import javax.swing.*;
import java.awt.*;

public class ControlPanelComboPanel extends JPanel {
	
	Color bgColor;
	int defaultBoxLayoutMode = BoxLayout.Y_AXIS;

	ControlPanelComboPanel(Color myBGColor, boolean createBorder) {
		this.bgColor = myBGColor;
		this.setLayout(new BoxLayout(this, defaultBoxLayoutMode));
		if(createBorder) {
			this.setBorder(new BorderMaker(BorderMaker.RAISEDBEVEL, 0, 4));
		}
		//this.setAlignmentY(Component.TOP_ALIGNMENT);
	}
	
	public void paintComponent(Graphics g){  
        super.paintComponent(g);
        this.setBackground(bgColor);
    }
}