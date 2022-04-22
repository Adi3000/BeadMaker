package com.adi3000.beadmaker.helpers;

import processing.data.XML;

import java.io.File;

public class XMLWorker extends com.adi3000.beadmaker.core.helper.XmlHelper {

	public XML[] configXML = new XML[1];
	public XML[] projectXML = new XML[1];

	String configFilePath;


	//------------------------------------------------------------
	//CONSTRUCTOR
	//------------------------------------------------------------
	public XMLWorker(boolean useAppData, String appDataFolderName) {
		super(useAppData, appDataFolderName);
		configFilePath = System.getProperty("beadmaker.dir") + File.separator + appDataFolderName + File.separator + "config" + File.separator + "_default_config.xml";
		configXML = GetXMLFromFile(configFilePath);
		projectXML = GetXMLFromFile(GetAbsoluteFilePathStringFromXml("defaultProjectFilePath", configXML, useAppData, appDataFolderName));
	}
}
	