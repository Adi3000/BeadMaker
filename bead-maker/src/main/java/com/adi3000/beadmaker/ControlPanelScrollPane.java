package com.adi3000.beadmaker;

import com.adi3000.beadmaker.core.component.swing.BorderMaker;

import javax.swing.*;

public class ControlPanelScrollPane extends JScrollPane {

	public ControlPanelScrollPane(ControlPanel controlPanel) {
		super(controlPanel);
		this.setBorder(new BorderMaker(BorderMaker.RAISEDBEVEL, 4, 8));
		this.getVerticalScrollBar().setUnitIncrement(16);
	}
}
