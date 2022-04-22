package com.adi3000.beadmaker;

import com.adi3000.beadmaker.core.component.swing.BorderMaker;

import javax.swing.*;
import java.awt.*;

public class ControlPanelSubPanel extends JPanel {
	
	Color bgColor;
	static final int defaultBoxLayoutMode = BoxLayout.X_AXIS;

	ControlPanelSubPanel(Color myBGColor, int boxLayoutMode, boolean createBorder) {
		super();
		init(myBGColor, boxLayoutMode, createBorder);
	}
	
	ControlPanelSubPanel(Color myBGColor) {
		this(myBGColor, defaultBoxLayoutMode, true);
	}
	
	ControlPanelSubPanel(Color myBGColor, boolean createBorder) {
		this(myBGColor, defaultBoxLayoutMode, createBorder);
	}
	
	ControlPanelSubPanel(Color myBGColor, int boxLayoutMode) {
		this(myBGColor, boxLayoutMode, true);
	}
	
	public void init(Color myBGColor, int boxLayoutMode, boolean createBorder) {
		this.bgColor = myBGColor;
		this.setLayout(new BoxLayout(this, boxLayoutMode));
		if(createBorder) {
			this.setBorder(new BorderMaker(BorderMaker.RAISEDBEVEL, 0, 4));
		}
		this.setAlignmentY(Component.TOP_ALIGNMENT);
	}
	
	public void paintComponent(Graphics g){  
        super.paintComponent(g);
        this.setBackground(bgColor);
    }
}
