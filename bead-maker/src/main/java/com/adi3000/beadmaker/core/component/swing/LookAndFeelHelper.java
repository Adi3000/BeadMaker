package com.adi3000.beadmaker.core.component.swing;

import com.adi3000.beadmaker.core.logging.ConsoleHelper;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelHelper {
	
	public ConsoleHelper consoleHelper = new ConsoleHelper();
	
	public void setLookAndFeel(String lookAndFeelName) {
	
		listAllLookAndFeels();
		
		try {
	        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    consoleHelper.PrintMessage(info.getName());
			}
			
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				consoleHelper.PrintMessage(info.getName());
				if (lookAndFeelName.equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
	    } 
		catch (ClassNotFoundException ex) {}
		catch (InstantiationException ex) {}
		catch (IllegalAccessException ex) {}
		catch (UnsupportedLookAndFeelException ex) {}
	}
	
	
	public void listAllLookAndFeels() {		
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    consoleHelper.PrintMessage(info.getName());
		}
	}
}
