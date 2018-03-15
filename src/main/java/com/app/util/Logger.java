/**
 * 
 */
package com.app.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * <h1>Logger</h1>
 * <p>Keeps record of all the activities being processed by the system</p>
 * @author nk17kumar
 */
public class Logger {

	/**
	 * holds the current time-stamp for a log
	 */
	private static String timeStamp;
	
	/**
	 * Buffer linked to the log file
	 */
	private static PrintStream fin;
	
	/**
	 * Constructor
	 */
	public Logger() {
		try {
			fin = new PrintStream(new File("src/main/resources/log.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * enters the log report in the log file
	 * @param str text that is to be added in the file
	 */ 
	public static void writeLog(String str,boolean error) {
		String header = " [PROCESS] ";
		if(error == true) {
			header = " [ERROR]   ";
		}
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(System.currentTimeMillis()));
		fin.println(timeStamp + header + str);
	}
	

}
