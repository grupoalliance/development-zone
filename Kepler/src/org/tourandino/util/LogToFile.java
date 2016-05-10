package org.tourandino.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 
 * @author romerori
 * @creation Oct 1, 2015
 *
 */
public class LogToFile {
	private final Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	private FileHandler fh = null;
	private Level level;
	private String message;

	public LogToFile(Level level, String message) {
		this.level = level;
		this.message = message;
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd HHmmss");
		try {
			// Make sure the output directory exists.
			File outDir = new File("C:/Logs");
			outDir.mkdirs();
			fh = new FileHandler("C:/Logs/LogFile_"
					+ format.format(Calendar.getInstance().getTime()) + ".log");
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch(IOException e2){
			e2.printStackTrace();
		}
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
	}

	public void doLogging() {
		logger.info("info msg");
		logger.severe("error message");
		logger.fine("fine message"); // won't show because to high level of
										// logging
	}

	public void log() {
		logger.log(level, message);
	}
	
	public void log(Object param1) {
		logger.log(level, message, param1);
	}
	
	public void log(Throwable thrown) {
		logger.log(level, message, thrown);
	}

}
