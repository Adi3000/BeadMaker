package com.adi3000.beadmaker;

import javax.swing.*;
import java.awt.*;

public class ControlLabel extends JLabel {
	ControlLabel(String labelName) {
		super(labelName);
		//this.setPreferredSize(new Dimension(80, 30));
		this.setPreferredSize(new Dimension(68, 2));
		
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		//this.setBorder(new BorderMaker(BorderMaker.NONE, 8, 0));
	}
}
