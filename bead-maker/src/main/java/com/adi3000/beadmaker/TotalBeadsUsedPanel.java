package com.adi3000.beadmaker;

import javax.swing.*;
import java.awt.*;

public class TotalBeadsUsedPanel extends JPanel {
	
	TotalBeadsUsedPanel(String label) {
		super();
		init(label);
	}

	public void init(String label) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		setOpaque(false);
		setPreferredSize(new Dimension(100, 60));
		setMaximumSize(new Dimension(360, 60));
		//this.setBorder(new BorderMaker(BorderMaker.NONE, 16, 1));
	}
}
