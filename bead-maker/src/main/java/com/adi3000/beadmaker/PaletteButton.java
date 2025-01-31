package com.adi3000.beadmaker;

import com.adi3000.beadmaker.core.helper.ColorHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaletteButton extends JButton {

	Color bgColor = new Color(204,204,204);
	int colorIndex;
	Palette pallette;
	

	public PaletteButton(
			String label,
			Color myBGColor,
			int myColorIndex,
			Palette myPallette
		) {
		super(label);
		this.colorIndex = myColorIndex;
		this.bgColor = myBGColor;
		this.pallette = myPallette;
		init();
	}
	
	
	public void init() {
		
		this.setBorderPainted( false );
		this.setHorizontalAlignment(SwingConstants.LEFT);
		setPreferredSize(new Dimension(230, 20));
		setMaximumSize(new Dimension(230, 20));
		
		this.setForeground(ColorHelper.GetTextColorForBGColor(bgColor));
				
		ActionListener palletteColorClickActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				PaletteButton myPalletteButton = (PaletteButton)actionEvent.getSource();
				pallette.setSelectedColor(myPalletteButton.colorIndex);
				
				Font labelFont = myPalletteButton.getFont();
				
				myPalletteButton.setText("" + myPalletteButton.getText() + "");
								
				for(int i = 0; i < pallette.palletteSubPanels.size(); i++) {
					pallette.palletteSubPanels.get(i).paletteButton.setFont(new Font(labelFont.getName(), Font.PLAIN, labelFont.getSize()));
					pallette.palletteSubPanels.get(i).paletteButton.setForeground(ColorHelper.GetTextColorForBGColor(pallette.palletteSubPanels.get(i).paletteButton.bgColor, true));
				}
				
				myPalletteButton.setFont(new Font(labelFont.getName(), Font.BOLD, labelFont.getSize()));
				myPalletteButton.setForeground(ColorHelper.GetTextColorForBGColor(bgColor));
				
			}
		};
		
		this.addActionListener(palletteColorClickActionListener);
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(bgColor);
	}

}
