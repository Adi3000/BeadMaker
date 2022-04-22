package com.adi3000.beadmaker;

import javax.swing.*;
import java.awt.*;

public class ControlPanelSuperPanel extends JPanel {
	
	boolean isVisible = true;
	
	ControlPanelSuperPanel() {
		super();	
	}
	
	public void toggleHide() {
		isVisible = !isVisible;
		if(isVisible) { 
			setPreferredSize(new Dimension(528,1));
		} else {
			setPreferredSize(new Dimension(21, 1));
		}
		this.repaint();
	}
	
	public void paintComponent(Graphics g){  
		super.paintComponent(g);
	}
}
