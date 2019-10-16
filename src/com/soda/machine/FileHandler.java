/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soda.machine;

import java.io.*;
import java.util.Date;
/**
 *
 * @author Prashanth
 */
public class FileHandler implements DataHandler {
	public boolean write(String productsFW, String totalFW, String inputFW) {
		try {
			PrintWriter outputFile = new PrintWriter(new FileWriter("VendingMachineData.txt", true));
			outputFile.println("------------------------------\r\nTime & Date of Purchase: " + new Date()
					+ ":\r\nProduct(s): " + productsFW + "\r\nTotal to be inserted: " + totalFW + "\r\nAmount Input: "
					+ inputFW + "\r\n--------------------------\r\n");
			outputFile.close();
		} catch (IOException ioe) {
			System.out.println("File VendingMachineData.txt not found");
			return false;
		}
		return true; // inserted OK
	}

	public void displayUsers(PrintStream outS) {
 try {
 BufferedReader inFile =
 new BufferedReader(new FileReader("VendingMachineData.txt"));
 String line;
 while ((line = inFile.readLine()) != null)
 outS.println(line);
 inFile.close();
 }
 catch (IOException ioe) {
 System.out.println(ioe);
 }
 }
}
