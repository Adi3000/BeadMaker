package com.adi3000.beadmaker;

import com.adi3000.beadmaker.core.component.swing.BorderMaker;

import javax.swing.*;

public class PalletteScrollPane extends JScrollPane {
	
	public PalletteScrollPane(PallettePanel pallettePanel) {
		super(pallettePanel);
		this.setBorder(new BorderMaker(BorderMaker.RAISEDBEVEL, 4, 0));
		this.getVerticalScrollBar().setUnitIncrement(16);
	}
}
