package com.adi3000.beadmaker.core.helper;

import com.adi3000.beadmaker.core.logging.ConsoleHelper;
import com.adi3000.beadmaker.core.logging.ExceptionLogger;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontHelper {
	
	public ConsoleHelper consoleHelper;
	public boolean useAppData;
	public String appDataFolderName;
	
	
	public FontHelper(boolean myUseAppData, String myAppDataFolderName) {
		this.consoleHelper = new ConsoleHelper();
		this.useAppData = myUseAppData;
		this.appDataFolderName = myAppDataFolderName;
	}
	
	
	public Font loadFont(String fontFileName, int fontSize, ExceptionLogger exceptionLogger, boolean useAppData, String appDataFolderName) {	
	
		//initialize the font to a default
		Font font = new Font("", Font.PLAIN, fontSize);
		
		//Attempt to load the custom font
		try {
		    //create the font to use. Specify the size!
			if (useAppData) {
				consoleHelper.PrintMessage("Attempting to load font file: " + System.getenv("APPDATA") + File.separator + appDataFolderName + File.separator + "fonts" + File.separator + fontFileName);
				font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getenv("APPDATA") + File.separator + appDataFolderName + File.separator + "fonts" + File.separator + fontFileName)).deriveFont((float)fontSize);
			} else {
				consoleHelper.PrintMessage("Attempting to load font file: " + System.getProperty("user.dir") + File.separator + "fonts" + File.separator + fontFileName);
				font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + File.separator + "fonts" + File.separator + fontFileName)).deriveFont((float)fontSize);
			}
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(font);
		} 
		catch(IOException e) {
			exceptionLogger.logStackTrace(e);
		}
		catch(FontFormatException e) {
			exceptionLogger.logStackTrace(e);
		}
		
		return font;
	}
}
