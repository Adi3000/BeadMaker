package com.adi3000.beadmaker.core.webcam;

import com.adi3000.beadmaker.core.logging.ConsoleHelper;
import com.adi3000.beadmaker.core.logging.ExceptionLogger;
import com.github.sarxos.webcam.Webcam;

import java.awt.*;
import java.util.List;

public class WebcamHelper {
	
	public ConsoleHelper consoleHelper = new ConsoleHelper();
	
	public Webcam getWebcam(String webcamName, int webcamWidth, int webcamHeight, ExceptionLogger exceptionLogger) {
		
		Webcam webcam = null;
		
		List<Webcam> webcams = Webcam.getWebcams();
		for (Webcam w : webcams) {
			consoleHelper.PrintMessage("webcam name = " + w.getName());
			if (w.getName().contains(webcamName)) {
				webcam = w;
			}
		}
		
		if (webcam == null) {
			exceptionLogger.logMessage("No webcams found with the name \"" + webcamName + "\"");
			System.exit(0);
		}
		
		webcam.setCustomViewSizes(new Dimension(webcamWidth, webcamHeight));
		webcam.setViewSize(webcam.getCustomViewSizes()[0]);
		
		consoleHelper.PrintMessage("Webcam resolutions: ");
		for (Dimension d : webcam.getViewSizes()) {
			consoleHelper.PrintMessage(d.toString());
		}
		
		return webcam;
	}
}
