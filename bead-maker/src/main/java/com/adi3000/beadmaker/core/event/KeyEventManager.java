package com.adi3000.beadmaker.core.event;

import com.adi3000.beadmaker.core.logging.ConsoleHelper;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyEventManager {
	
	public ConsoleHelper consoleHelper = new ConsoleHelper();
	
	//default constructor
	public KeyEventManager() {
		init();
	}
	
	public void KeyCodeAction(int keyCode) {
		consoleHelper.PrintMessage(keyCode);
	}
	
	private void init() {

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	
	        @Override
	        public boolean dispatchKeyEvent(KeyEvent ke) {
	            switch (ke.getID()) {
	                case KeyEvent.KEY_PRESSED:
	                	KeyCodeAction(ke.getKeyCode());
	                    break;
	            }
	
	            return false;
	    	}
		});
	}
}
