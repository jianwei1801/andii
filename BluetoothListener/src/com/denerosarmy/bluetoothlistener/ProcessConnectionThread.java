package com.denerosarmy.bluetoothlistener;

import java.io.InputStream;

import javax.microedition.io.StreamConnection;
import java.utils.ArrayList; 
public class ProcessConnectionThread implements Runnable{

	private StreamConnection mConnection;
	
	// Constant that indicate command from devices
	private static final int EXIT_CMD = -1;
	private static final int KEY_RIGHT = 1;
	private static final int KEY_LEFT = 2;
	
	public ProcessConnectionThread(StreamConnection connection) {
		mConnection = connection;
	}
	@Override
	public void run() {
		try {
			// prepare to receive data
			InputStream inputStream = mConnection.openInputStream();
			System.out.println("waiting for input");
			String array = "";
			while (true) {
				int command = inputStream.read();
				if (command != 59) {  	
					String array += (char) command;
				}
				else { 
					System.out.println(array);
					array = "";
				}
        if (command == EXIT_CMD) {	
					System.out.println("finish process");
					break;
				}
				processCommand(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Process the command from client
	 * @param command the command code
	 */
	private void processCommand(int command) {
		try {
			System.out.println(command);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
