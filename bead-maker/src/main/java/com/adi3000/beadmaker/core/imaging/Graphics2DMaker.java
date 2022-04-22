package com.adi3000.beadmaker.core.imaging;

import java.awt.*;

public class Graphics2DMaker {
	public static Graphics2D getGraphics2D(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );
		
		return g2d;
		
	}
}
