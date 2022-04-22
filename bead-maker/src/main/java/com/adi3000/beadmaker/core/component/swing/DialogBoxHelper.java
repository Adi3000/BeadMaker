package com.adi3000.beadmaker.core.component.swing;

import com.adi3000.beadmaker.core.logging.ConsoleHelper;

import javax.swing.*;

public class DialogBoxHelper {
	
	ConsoleHelper consoleHelper = new ConsoleHelper();
	
	//---------------------------------------------------------------------------
	// WarningDialog
	//---------------------------------------------------------------------------
	public boolean WarningDialog(String message) {
		consoleHelper.PrintMessage("WarningDialog");

		//JOptionPane.showMessageDialog(frame, warning, windowTitle);
		JOptionPane.showMessageDialog(null, message);

		return true;
	}


	//---------------------------------------------------------------------------
	// YesNoDialog
	//---------------------------------------------------------------------------
	public boolean YesNoDialog(String question, String windowTitle) {
		consoleHelper.PrintMessage("YesNoDialog");

		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, question, windowTitle, dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION) {
			return true;
		}

		return false;
	}
}
