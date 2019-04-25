package com.assignment.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.assignment.setup.Setup;

public class Prop {

	private static Logger log = Logger.getLogger(Prop.class.getName());

	/**
	 * This method will load properties file of given path.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static Properties loadPropertiesFile(String filePath) throws IOException {
		FileInputStream fis;
		Properties property = null;
		try {
			fis = new FileInputStream(filePath);
			property = new Properties();
			property.load(fis);
			log.info("Loaded " + filePath + " file");
		} catch (FileNotFoundException e) {
			log.info("Failed to load " + filePath + " file");
		} catch (IOException e) {
			log.info("Faied to open " + filePath + " file");
		}
		return property;
	}

	public static String getConfigValue(String key) throws IOException {
		String value = Setup.config.getProperty(key);
		return value;
	}

	public static String getTestData(String key) {
		String value = Setup.testData.getProperty(key);
		return value;
	}

	private static void appendTestData(String key, String value) throws IOException {
		if (Prop.getTestData(key) == null) {
			try {
				FileWriter fileWritter = new FileWriter(Setup.testDataPropertiesFilePath, true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.newLine();
				bufferWritter.append(key + "=" + value);
				bufferWritter.close();
				log.info("Write " + Setup.testDataPropertiesFilePath + " file");
			} catch (FileNotFoundException e) {
				log.info("Failed to open " + Setup.testDataPropertiesFilePath + " file");
			} catch (IOException e) {
				log.info("Faied to write " + Setup.testDataPropertiesFilePath + " file");
			}
		} else {
			log.info("Key aready exist");
			// Properties testData =
			// Prop.loadPropertiesFile(Setup.testDataPropertiesFilePath);
			// testData.replace(key, value);
			// Writer writer = new FileWriter(Setup.testDataPropertiesFilePath);
			// testData.store(writer, "updated");
		}
	}

}
