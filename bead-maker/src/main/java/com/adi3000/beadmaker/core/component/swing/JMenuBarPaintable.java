package com.adi3000.beadmaker.core.component.swing;

import javax.swing.*;
import java.awt.*;

public class JMenuBarPaintable extends JMenuBar {
    
	//https://stackoverflow.com/questions/15648030/change-background-and-text-color-of-jmenubar-and-jmenu-objects-inside-it
	
	Color bgColor=Color.WHITE;

    public void setColor(Color color) {
        bgColor=color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }
}
