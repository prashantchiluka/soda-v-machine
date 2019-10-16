/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soda.machine;

/**
 *
 * @author Prashanth
 */

public interface DataHandler {
	 public boolean write(String productsFW, String totalFW, String inputFW);
	 public void displayUsers(java.io.PrintStream out);
	}