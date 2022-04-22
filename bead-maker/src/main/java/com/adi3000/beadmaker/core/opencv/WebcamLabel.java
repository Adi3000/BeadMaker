package com.adi3000.beadmaker.core.opencv;

import com.adi3000.beadmaker.core.imaging.Graphics2DMaker;
import processing.core.PVector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WebcamLabel extends JLabel {
	
	private boolean showContour = true;
	private boolean foundContour = false;
	
	private ArrayList<PVector> points = new ArrayList<PVector>();
	
	private int webcamDisplayWidth;
	private int webcamDisplayHeight;
	private int webcamXScaler;
	private int webcamYScaler;
	
	public WebcamLabel(
		int myWebcamDisplayWidth,
		int myWebcamDisplayHeight,
		int myWebcamXScaler,
		int myWebcamYScaler,
		boolean myShowContour
	) {
		super();
		this.webcamDisplayWidth = myWebcamDisplayWidth;
		this.webcamDisplayHeight = myWebcamDisplayHeight;
		this.webcamXScaler = myWebcamXScaler;
		this.webcamYScaler = myWebcamYScaler;
		this.showContour = myShowContour;
	}
	
	public WebcamLabel(
		int myWebcamDisplayWidth,
		int myWebcamDisplayHeight,
		int myWebcamXScaler,
		int myWebcamYScaler
	) {
		super();
		this.webcamDisplayWidth = myWebcamDisplayWidth;
		this.webcamDisplayHeight = myWebcamDisplayHeight;
		this.webcamXScaler = myWebcamXScaler;
		this.webcamYScaler = myWebcamYScaler;
	}
	
	
	public void setPoints(ArrayList<PVector> myPoints) {
		this.points = myPoints;
	}
	
	public void showContour(boolean b) {
		this.showContour = b;
	}
	
	public void foundContour(boolean b) {
		this.foundContour = b;
	}
	
	public void paintComponent(Graphics g) {  
		
		super.paintComponent(g);
		
		if(showContour) {	
		
			Graphics2D g2d = Graphics2DMaker.getGraphics2D(g);
		
			g2d.setStroke(new BasicStroke(4f));	
			
			Polygon polygon = new Polygon();
			
			//if (!legoRecognizer.opencv.contours.isEmpty()) {
			if (!points.isEmpty()) {
				
				//for (PVector pVector : legoRecognizer.opencv.contour.getPoints()) {
				for (PVector pVector : points) {
					polygon.addPoint((int)pVector.x * webcamXScaler, (int)pVector.y * webcamYScaler + ((getHeight() - webcamDisplayHeight) / 2));
				}
			}
			
			if(foundContour) {			
				g2d.setColor(Color.GREEN);
			} else {
				g2d.setColor(Color.RED);
			}
			
			g2d.drawPolygon(polygon);
		}
	}
}
