package com.adi3000.beadmaker.core.helper;

import com.adi3000.beadmaker.core.component.jfx.SynchronousJFXFileChooser;
import com.adi3000.beadmaker.core.logging.ConsoleHelper;

import java.io.*;

public class FileHelper {
	
	public ConsoleHelper consoleHelper;
	public boolean useAppData;
	public String appDataFolderName;
	
	
	public FileHelper(boolean myUseAppData, String myAppDataFolderName) {
		consoleHelper = new ConsoleHelper();
		this.useAppData = myUseAppData;
		this.appDataFolderName = myAppDataFolderName;
	}
	
	
	//---------------------------------------------------------------------------
	// getExtension
	//---------------------------------------------------------------------------
	public String getExtension(String s) {
		consoleHelper.PrintMessage("getExtension");
		String separator = System.getProperty("file.separator");
		String filename;

		// Remove the path upto the filename.
		int lastSeparatorIndex = s.lastIndexOf(separator);
		if (lastSeparatorIndex == -1) {
			filename = s;
		} else {
			filename = s.substring(lastSeparatorIndex + 1);
		}

		// Remove the extension.
		int extensionIndex = filename.lastIndexOf(".");
		if (extensionIndex == -1) {
			return "";
		}

		return filename.substring(extensionIndex + 1);
	}
	
	
	//---------------------------------------------------------------------------
	// GetFileFromAbsoluteOrRelativeFilePath
	//---------------------------------------------------------------------------
	// the idea here is an absolute path will contain a colon, and a relative path
	// will not.
	public File GetFileFromAbsoluteOrRelativeFilePath(String filePath, boolean useAppData, String appDataFolderName) {
		
		File file;
		
		if (filePath.contains(":")) {
		    System.out.println("1");
			file = new File(filePath);
		} else {
			if (useAppData) {
			    System.out.println("2 - " + System.getProperty("beadmaker.dir") + File.separator + appDataFolderName );
			    System.out.println("filePath - " + filePath);
				file = new File(filePath);
			} else {
			    System.out.println("3");
				file = new File(System.getProperty("user.dir"), filePath);
			}
		}
		System.out.println("file exists - " + file.exists());
		return file;
	}
	
	
	//---------------------------------------------------------------------------
	// GetFilenameFromFileChooser
	//---------------------------------------------------------------------------
	public String GetFilenameFromFileChooser(String[] fileExtensions, String fileDecription) {
		return GetFilenameFromFileChooser(fileExtensions, fileDecription, "");
	}
		
		
	//---------------------------------------------------------------------------
	// GetFilenameFromFileChooser
	//---------------------------------------------------------------------------
	public String GetFilenameFromFileChooser(String[] fileExtensions, String fileDescription, String startingDirectory) {
		consoleHelper.PrintMessage("GetFilenameFromFileChooser");

		File myDir = new File(startingDirectory);
		
		File selectedFile;
	    
	    SynchronousJFXFileChooser chooser = new SynchronousJFXFileChooser (
	    	myDir,
	    	fileDescription,
	    	fileExtensions	    	
	    );
	    selectedFile = chooser.showOpenDialog();	            
	    
	    if (selectedFile != null) {
	    	consoleHelper.PrintMessage("You chose to open this file: " + selectedFile.toString());
	    	return selectedFile.toString();
	    }
	    
	    return null;
	}	
		
		
	//---------------------------------------------------------------------------
	// GetFileNameFromFilePath
	//---------------------------------------------------------------------------
	synchronized public String GetFileNameFromFilePath(String filePath) {
		consoleHelper.PrintMessage("GetFileNameFromFilePath");
		
		File file = new File(filePath);
		return file.getName();
	}
	
	//---------------------------------------------------------------------------
	// GetPathFromFilePath //still needs to be tested
	//---------------------------------------------------------------------------
	synchronized public String GetPathFromFilePath(String filePath) {
		consoleHelper.PrintMessage("GetPathFromFilePath");	
		
		return filePath.substring(0, filePath.lastIndexOf(File.separator));
	}
	
	
	//---------------------------------------------------------------------------
	// remove file extension
	//---------------------------------------------------------------------------
	synchronized public String removeExtension(String filename) {
		consoleHelper.PrintMessage("removeExtension");

		int extensionIndex = filename.lastIndexOf(".");
		if (extensionIndex == -1) {
			return filename;
		}

		return filename.substring(0, extensionIndex);
	}
	
	
	//---------------------------------------------------------------------------
	// CopyFileUsingStream
	//from https://www.journaldev.com/861/java-copy-file
	//---------------------------------------------------------------------------
	public static void CopyFileUsingStream(File sourceFile, File destinationFile) throws IOException {
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
	    try {
	        inputStream = new FileInputStream(sourceFile);
	        outputStream = new FileOutputStream(destinationFile);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = inputStream.read(buffer)) > 0) {
	            outputStream.write(buffer, 0, length);
	        }
	    } finally {
	        inputStream.close();
	        if (outputStream != null) {
	        	outputStream.close();
	        }
	    }
	}
	
	public static void DeleteAllFilesInDirectory(String dir) {
		File dirFile = new File(dir);
		for (File file: dirFile.listFiles()) {
		    if (!file.isDirectory()) { 
		        file.delete();
		    }
		}
	}
}
