package com.adi3000.beadmaker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WindowController extends JFrame {

	public InterObjectCommunicator oComm;
	
	private boolean useAppData;
	private String appDataFolderName;
		
	public WindowController (
		String frameTitle,
		InterObjectCommunicator myOComm,
		boolean myUseAppData,
		String myAppDataFolderName
	) {
		
		super(frameTitle);
		
		this.useAppData = myUseAppData;
		this.appDataFolderName = myAppDataFolderName;
		
		oComm = myOComm;
		//this.setPreferredSize (new Dimension(900, 600));
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1600, 1000));
		//this.setState(Frame.NORMAL);
		//this.setVisible(true);
		try {
		    this.setIconImage(ImageIO.read(new File(System.getProperty("beadmaker.dir") + File.separator + appDataFolderName + File.separator + "icon" + File.separator + "BeadMakerIcon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.pack();
		
		KeyboardListener kl = new KeyboardListener(oComm);
	}
	
	
	//---------------------------------------------------------------------------
	// add
	//---------------------------------------------------------------------------
	public void add(JLabel jLabel, String borderLayout) {
		this.getContentPane().add(jLabel, borderLayout);
	}
	
	
	//---------------------------------------------------------------------------
	// SetCursorState
	//---------------------------------------------------------------------------
	void SetCursorState(int myCursorMode) {
		this.setCursor(Cursor.getPredefinedCursor(myCursorMode));
	}
	
	
	//-------------------------------------------------------
	//SetFrameTitle
	//-------------------------------------------------------
	public void SetFrameTitle(String frameTitle) {
		this.setTitle(frameTitle);
	}
}
