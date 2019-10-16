/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soda.machine;

import java.text.DecimalFormat;
import java.util.Date;

import static javax.swing.JOptionPane.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Prashanth
 */
public class SodaVendingMachine extends JFrame implements ActionListener {
//Here I will declare all my objects to be used, with their properties too.
//datahandler
	static DataHandler dh;
//date and time
	Date now = new Date();
//date:
	int year = now.getYear() + 1900;
	int month = now.getMonth() + 1;
	int day = now.getDate();
//time:
	int hours = now.getHours();
	int minutes = now.getMinutes();
	int seconds = now.getSeconds();
//changeFrame
	JFrame changeFrame = new JFrame("Please Take Your Change");
//Banner Image and button:
	ImageIcon bannerImage = new ImageIcon("images/bannerIcon.png");
	JButton bannerButton = new JButton("", bannerImage);
	JLabel selectLabel = new JLabel("Please select your items:");
//All objects for Product 1:
	ImageIcon productImage1 = new ImageIcon("images/limesoda.png");
	JButton product1 = new JButton("", productImage1);
	JLabel product1des = new JLabel("Lime Soda", JLabel.CENTER);
	JLabel product1price = new JLabel("£0.50", JLabel.CENTER);
//All objects for Product 2:
	ImageIcon productImage2 = new ImageIcon("images/sprite.png");
	JButton product2 = new JButton("", productImage2);
	JLabel product2des = new JLabel("Sprite", JLabel.CENTER);
	JLabel product2price = new JLabel("£0.50", JLabel.CENTER);
//All objects for Product 3:
	ImageIcon productImage3 = new ImageIcon("images/7up.png");
	JButton product3 = new JButton("", productImage3);
	JLabel product3des = new JLabel("7 up", JLabel.CENTER);
	JLabel product3price = new JLabel("£0.65", JLabel.CENTER);
//All objects for Product 4:
	ImageIcon productImage4 = new ImageIcon("images/Mirinda.png");
	JButton product4 = new JButton("", productImage4);
	JLabel product4des = new JLabel("Mirinda", JLabel.CENTER);
	JLabel product4des2 = new JLabel("Crisps", JLabel.CENTER);
	JLabel product4price = new JLabel("£0.55", JLabel.CENTER);
//All objects for product 5:
	ImageIcon productImage5 = new ImageIcon("images/Montain.png");
	JButton product5 = new JButton("", productImage5);
	JLabel product5des = new JLabel("Montain Dew -", JLabel.CENTER);
	JLabel product5des2 = new JLabel("Pickled Onion", JLabel.CENTER);
	JLabel product5price = new JLabel("£0.70", JLabel.CENTER);
//All objects for product 6:
	ImageIcon productImage6 = new ImageIcon("images/Fanta.png");
	JButton product6 = new JButton("", productImage6);
	JLabel product6des = new JLabel("Fanta -", JLabel.CENTER);
	JLabel product6des2 = new JLabel("Sweet", JLabel.CENTER);
	JLabel product6price = new JLabel("£1.10", JLabel.CENTER);
//All objects for product 7:
	ImageIcon productImage7 = new ImageIcon("images/Coca-Cola.png");
	JButton product7 = new JButton("", productImage7);
	JLabel product7des = new JLabel("Coca-Cola (330ml)", JLabel.CENTER);
	JLabel product7price = new JLabel("£0.75", JLabel.CENTER);
//All objects for product 8:
	ImageIcon productImage8 = new ImageIcon("images/pepper.png");
	JButton product8 = new JButton("", productImage8);
	JLabel product8des = new JLabel("Dr Pepper (330ml)", JLabel.CENTER);
	JLabel product8price = new JLabel("£0.75", JLabel.CENTER);
//All objects for product 9:
	ImageIcon productImage9 = new ImageIcon("images/Fruit.png");
	JButton product9 = new JButton("", productImage9);
	JLabel product9des = new JLabel("Fruit", JLabel.CENTER);
	JLabel product9price = new JLabel("£0.60", JLabel.CENTER);
//All objects for product 10:
	ImageIcon productImage10 = new ImageIcon("images/Wine.png");
	JButton product10 = new JButton("", productImage10);
	JLabel product10des = new JLabel("Wine", JLabel.CENTER);
	JLabel product10price = new JLabel("£0.65", JLabel.CENTER);
//Horizontal/Vertical Rules as buttons for simplicity and layout
	JButton ruleH = new JButton("");
	JButton ruleV = new JButton("");
	JButton ruleV2 = new JButton("");
//selected items section
	JLabel selectedLabel = new JLabel("You have selected the following items:");
	JTextArea selectedItems = new JTextArea(8, 250);
//Total price:
	JLabel selectedItemTotalLabel = new JLabel("Total - Please insert:");
	JTextField selectedItemTotal = new JTextField("£0.00", 30);
//Money section:
//Label:
	JLabel moneyInputLabel = new JLabel("Please input your money:");
//Money buttons with imageIcons:
//5 pence
	ImageIcon fivePenceImage = new ImageIcon("images/fivePenceImage.png");
	JButton fivePenceButton = new JButton("", fivePenceImage);
//10 pence
	ImageIcon tenPenceImage = new ImageIcon("images/tenPenceImage.png");
	JButton tenPenceButton = new JButton("", tenPenceImage);
//20 pence
	ImageIcon twentyPenceImage = new ImageIcon("images/twentyPenceImage.png");
	JButton twentyPenceButton = new JButton("", twentyPenceImage);
//50 pence
	ImageIcon fiftyPenceImage = new ImageIcon("images/fiftyPenceImage.png");
	JButton fiftyPenceButton = new JButton("", fiftyPenceImage);
//1 pound
	ImageIcon onePoundImage = new ImageIcon("images/onePoundImage.png");
	JButton onePoundButton = new JButton("", onePoundImage);
//2 pound
	ImageIcon twoPoundImage = new ImageIcon("images/twoPoundImage.png");
	JButton twoPoundButton = new JButton("", twoPoundImage);
//You have input:
	JLabel moneyInputLabel2 = new JLabel("You have input:");
	JTextField moneyInput = new JTextField("£0.00", 30);
//Enter / return coins
	ImageIcon enterCoinsImage = new ImageIcon("images/entercoins.jpg");
	JButton enterCoins = new JButton("Enter Coins", enterCoinsImage);
	ImageIcon returnCoinsImage = new ImageIcon("images/returncoins.jpg");
	JButton returnCoins = new JButton("Return Coins", returnCoinsImage);
//Output message window (Thenk you for purchase / £2.10 Returned / etc)
	JTextArea outputMessage = new JTextArea(2, 30);
//cancel order objects
	JLabel cancelOrderLabel = new JLabel("Cancel / Clear Order:");
	ImageIcon cancelOrderImage = new ImageIcon("images/cancelOrderImage.png");
	JButton cancelOrder = new JButton("", cancelOrderImage);
//product stock levels all set at 10 stock per item
	JTextField product1stock = new JTextField("10", 2);
	JTextField product2stock = new JTextField("10", 2);
	JTextField product3stock = new JTextField("10", 2);
	JTextField product4stock = new JTextField("10", 2);
	JTextField product5stock = new JTextField("10", 2);
	JTextField product6stock = new JTextField("10", 2);
	JTextField product7stock = new JTextField("10", 2);
	JTextField product8stock = new JTextField("10", 2);
	JTextField product9stock = new JTextField("10", 2);
	JTextField product10stock = new JTextField("10", 2);
//coin stock
	JTextField fivepStock = new JTextField("20", 2);
	JTextField tenpStock = new JTextField("20", 2);
	JTextField twentypStock = new JTextField("20", 2);
	JTextField fiftypStock = new JTextField("20", 2);
	JTextField onepStock = new JTextField("20", 2);
	JTextField twopStock = new JTextField("20", 2);
//take change button
	JButton takeChange = new JButton("Take Change");
//date and time textfields & labels and calls
	JLabel dateLabel = new JLabel("Date:");
	JLabel timeLabel = new JLabel("Time:");
	JTextField currentDate = new JTextField("", 10);
	JTextField currentTime = new JTextField("", 10);
//declarations for changeFrame:
	ImageIcon cfLabelicon = new ImageIcon("images/CFLabel1icon.jpg");
	JLabel cfLabelTakeChange = new JLabel("", cfLabelicon, JLabel.CENTER);
//Money buttons with imageIcons for changeFrame (imageicons used same as previous)
//5 pence
	JButton CFfivePenceButton = new JButton("", fivePenceImage);
//10 pence
	JButton CFtenPenceButton = new JButton("", tenPenceImage);
//20 pence
	JButton CFtwentyPenceButton = new JButton("", twentyPenceImage);
//50 pence
	JButton CFfiftyPenceButton = new JButton("", fiftyPenceImage);
//1 pound
	JButton CFonePoundButton = new JButton("", onePoundImage);
//2 pound
	JButton CFtwoPoundButton = new JButton("", twoPoundImage);
//coin stock CF
	JTextField CFfivepStock = new JTextField("20", 2);
	JTextField CFtenpStock = new JTextField("20", 2);
	JTextField CFtwentypStock = new JTextField("20", 2);
	JTextField CFfiftypStock = new JTextField("20", 2);
	JTextField CFonepStock = new JTextField("20", 2);
	JTextField CFtwopStock = new JTextField("20", 2);
	JLabel CFpleaseTakeChange = new JLabel("Please select how you would like your change:");
	JLabel CFchangeRemainingLabel = new JLabel("Change Remaining: £");
	JTextField CFchangeRemaining = new JTextField("", 10);
	JButton CFruleH1 = new JButton("");
	JTextArea CFoutputMessage = new JTextArea("", 2, 30);
	JButton CFfinished = new JButton("Finished");
//close button
	JButton CFclose = new JButton("Close This Window");// will be enabled once correct change has been taken


//End declarations of objects
//calculation stuff:
	double productTotal = 0;// holds value for total to be inserted (total price of all selected items)
	double totalInserted = 0;// holds value for total money put in
//stock number values which are deducted in value as each product is selected:
	double product1stockNum = 10;
	double product2stockNum = 10;
	double product3stockNum = 10;
	double product4stockNum = 10;
	double product5stockNum = 10;
	double product6stockNum = 10;
	double product7stockNum = 10;
	double product8stockNum = 10;
	double product9stockNum = 10;
	double product10stockNum = 10;
//stock number values held for money, 20 of each coin *Note: I tried to name it as "5pStock, 10pStock

//this threw back alot of errors, so you cannot name things in java starting with an integer it doesnt

	double fivepStockNum = 20;
	double tenpStockNum = 20;
	double twentypStockNum = 20;
	double fiftypStockNum = 20;
	double onepStockNum = 20;
	double twopStockNum = 20;

//end calculation stuff.
	public static void main(String[] args) {
		SodaVendingMachine jf = new SodaVendingMachine();
		dh = new FileHandler();// data handler for file writer
	}

	public SodaVendingMachine()

	{
		setLayout(null);// Null layout for absolute positioning
		setSize(830, 705);// Dimensions 830x705
		setTitle("Super Awesome Vending Machine");// Title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//banner and initial label
		bannerButton.setBounds(210, 10, 400, 30);
		add(bannerButton);
		selectLabel.setBounds(10, 50, 200, 15);
		add(selectLabel);
//date and time objects (labels and textfields)
		currentDate.setBounds(740, 5, 80, 20);
		currentDate.setEditable(false);
		add(currentDate);
		dateLabel.setBounds(705, 7, 30, 15);
		add(dateLabel);
		currentTime.setBounds(740, 28, 80, 20);
		currentTime.setEditable(false);
		add(currentTime);
		timeLabel.setBounds(702, 30, 33, 15);
		add(timeLabel);
//row 1 of product image buttons
		product1.setBounds(20, 75, 140, 150);
		product1.addActionListener(this);
		add(product1);
		product2.setBounds(180, 75, 140, 150);
		product2.addActionListener(this);
		add(product2);
		product3.setBounds(340, 75, 140, 150);
		product3.addActionListener(this);
		add(product3);
		product4.setBounds(500, 75, 140, 150);
		product4.addActionListener(this);
		add(product4);
		product5.setBounds(660, 75, 140, 150);
		product5.addActionListener(this);
		add(product5);
//row 2 = row 1 product descriptions and prices
		product1des.setBounds(20, 225, 140, 15);
		add(product1des);
		product1price.setBounds(20, 250, 140, 15);
		product1price.setForeground(Color.red);
		add(product1price);
		product2des.setBounds(180, 225, 140, 15);
		add(product2des);
		product2price.setBounds(180, 250, 140, 15);
		product2price.setForeground(Color.red);
		add(product2price);

		product3des.setBounds(340, 225, 140, 15);
		add(product3des);
		product3price.setBounds(340, 250, 140, 15);
		product3price.setForeground(Color.red);
		add(product3price);
		product4des.setBounds(500, 225, 140, 15);
		add(product4des);
		product4des2.setBounds(500, 237, 140, 15);
		add(product4des2);
		product4price.setBounds(500, 250, 140, 15);
		product4price.setForeground(Color.red);
		add(product4price);
		product5des.setBounds(660, 225, 140, 15);
		add(product5des);
		product5des2.setBounds(660, 237, 140, 15);
		add(product5des2);
		product5price.setBounds(660, 250, 140, 15);
		product5price.setForeground(Color.red);
		add(product5price);
//row 3 = 2nd row of product image buttons (products 6

		product6.setBounds(20, 270, 140, 150);
		product6.addActionListener(this);
		add(product6);
		product7.setBounds(180, 270, 140, 150);
		product7.addActionListener(this);
		add(product7);
		product8.setBounds(340, 270, 140, 150);
		product8.addActionListener(this);
		add(product8);
		product9.setBounds(500, 270, 140, 150);
		product9.addActionListener(this);
		add(product9);
		product10.setBounds(660, 270, 140, 150);
		product10.addActionListener(this);
		add(product10);
//row 4 = row 3 product descriptions and prices
		product6des.setBounds(20, 420, 140, 15);
		add(product6des);
		product6des2.setBounds(20, 432, 140, 15);
		add(product6des2);
		product6price.setBounds(20, 445, 140, 15);
		product6price.setForeground(Color.red);
		add(product6price);
		product7des.setBounds(180, 420, 140, 15);
		add(product7des);
		product7price.setBounds(180, 445, 140, 15);
		product7price.setForeground(Color.red);
		add(product7price);
		product8des.setBounds(340, 420, 140, 15);
		add(product8des);
		product8price.setBounds(340, 445, 140, 15);
		product8price.setForeground(Color.red);
		add(product8price);
		product9des.setBounds(500, 420, 150, 15);

		add(product9des);
		product9price.setBounds(500, 445, 150, 15);
		product9price.setForeground(Color.red);
		add(product9price);
		product10des.setBounds(660, 420, 150, 15);
		add(product10des);
		product10price.setBounds(660, 445, 150, 15);
		product10price.setForeground(Color.red);
		add(product10price);
//product stock fields
		product1stock.setBounds(161, 75, 17, 20);
		product1stock.setEditable(false);
		add(product1stock);
		product2stock.setBounds(321, 75, 17, 20);
		product2stock.setEditable(false);
		add(product2stock);
		product3stock.setBounds(481, 75, 17, 20);
		product3stock.setEditable(false);
		add(product3stock);
		product4stock.setBounds(641, 75, 17, 20);
		product4stock.setEditable(false);
		add(product4stock);
		product5stock.setBounds(801, 75, 17, 20);
		product5stock.setEditable(false);
		add(product5stock);
		product6stock.setBounds(161, 270, 17, 20);
		product6stock.setEditable(false);
		add(product6stock);
		product7stock.setBounds(321, 270, 17, 20);
		product7stock.setEditable(false);
		add(product7stock);
		product8stock.setBounds(481, 270, 17, 20);
		product8stock.setEditable(false);
		add(product8stock);
		product9stock.setBounds(641, 270, 17, 20);
		product9stock.setEditable(false);
		add(product9stock);
		product10stock.setBounds(801, 270, 17, 20);
		product10stock.setEditable(false);
		add(product10stock);
//horizontal rule to seperate products from the lower section
		ruleH.setBounds(15, 465, 800, 2);
		add(ruleH);
//Selected products section

		selectedLabel.setBounds(15, 475, 220, 15);
		add(selectedLabel);
		selectedItems.setBounds(15, 495, 265, 140);
		selectedItems.setEditable(false);
		add(selectedItems);
//total price
		selectedItemTotalLabel.setBounds(15, 645, 120, 20);
		add(selectedItemTotalLabel);
		selectedItemTotal.setBounds(140, 645, 125, 20);
		selectedItemTotal.setEditable(false);
		add(selectedItemTotal);
//vert rule seperating the selected items from the money section
		ruleV.setBounds(283, 475, 2, 185);
		add(ruleV);
//money input section:
//money label:
		moneyInputLabel.setBounds(290, 470, 150, 20);
		add(moneyInputLabel);
//5p
		fivePenceButton.setBounds(290, 495, 68, 68);
		fivePenceButton.addActionListener(this);
		add(fivePenceButton);
//10p
		tenPenceButton.setBounds(379, 495, 68, 68);
		tenPenceButton.addActionListener(this);
		add(tenPenceButton);
//20p
		twentyPenceButton.setBounds(471, 495, 68, 68);
		twentyPenceButton.addActionListener(this);
		add(twentyPenceButton);
//50p
		fiftyPenceButton.setBounds(290, 565, 68, 68);
		fiftyPenceButton.addActionListener(this);
		add(fiftyPenceButton);
//£1
		onePoundButton.setBounds(379, 565, 68, 68);
		onePoundButton.addActionListener(this);
		add(onePoundButton);
//£2
		twoPoundButton.setBounds(471, 565, 68, 68);
		twoPoundButton.addActionListener(this);
		add(twoPoundButton);
//money stock values

		fivepStock.setBounds(358, 495, 18, 20);
		fivepStock.setEditable(false);
		add(fivepStock);
		tenpStock.setBounds(447, 495, 18, 20);
		tenpStock.setEditable(false);
		add(tenpStock);
		twentypStock.setBounds(539, 495, 18, 20);
		twentypStock.setEditable(false);
		add(twentypStock);
		fiftypStock.setBounds(358, 565, 18, 20);
		fiftypStock.setEditable(false);
		add(fiftypStock);
		onepStock.setBounds(447, 565, 18, 20);
		onepStock.setEditable(false);
		add(onepStock);
		twopStock.setBounds(539, 565, 18, 20);
		twopStock.setEditable(false);
		add(twopStock);
//money input section:
		moneyInputLabel2.setBounds(290, 638, 100, 20);
		add(moneyInputLabel2);
		moneyInput.setBounds(380, 638, 127, 20);
		moneyInput.setEditable(false);
		add(moneyInput);
//vert rule seperating money section from right side section
		ruleV2.setBounds(560, 475, 2, 185);
		add(ruleV2);
//enter / return coins / output area
		enterCoins.setBounds(568, 475, 250, 40);
		enterCoins.addActionListener(this);
		add(enterCoins);
		returnCoins.setBounds(568, 525, 250, 40);
		returnCoins.addActionListener(this);
		add(returnCoins);
		outputMessage.setBounds(568, 575, 250, 50);
		outputMessage.setEditable(false);
		add(outputMessage);
//cancel order
		cancelOrderLabel.setBounds(676, 635, 122, 25);
		add(cancelOrderLabel);
		cancelOrder.setBounds(794, 635, 25, 25);
		cancelOrder.addActionListener(this);
		add(cancelOrder);
//take change
		takeChange.setBounds(565, 635, 109, 25);
		takeChange.setForeground(Color.red);

		takeChange.setVisible(false);
		takeChange.addActionListener(this);
		add(takeChange);
//end pixel defination placing

		setVisible(true);// Window is visible
		setResizable(false);// Doesn't let users resize the window
	}

//new class for the frame
	public void changeFrameInit() {
//JFrame changeFrame = new JFrame("Please Take Your Change");
		changeFrame.setSize(504, 390);// size of frame
		changeFrame.setLayout(null);// Null layout for absolute positioning
		changeFrame.setVisible(false);
		changeFrame.setResizable(false);
		changeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// disables the
//"X" button, so users dont close the window before inserting change
//header label with imageicon
		cfLabelTakeChange.setBounds(22, 2, 450, 40);
		changeFrame.add(cfLabelTakeChange);
		CFpleaseTakeChange.setBounds(6, 50, 300, 20);
		changeFrame.add(CFpleaseTakeChange);
//money
//5p
		CFfivePenceButton.setBounds(10, 80, 68, 68);
		CFfivePenceButton.addActionListener(this);
		changeFrame.add(CFfivePenceButton);
//10p
		CFtenPenceButton.setBounds(92, 80, 68, 68);
		CFtenPenceButton.addActionListener(this);
		changeFrame.add(CFtenPenceButton);
//20p

		CFtwentyPenceButton.setBounds(174, 80, 68, 68);
		CFtwentyPenceButton.addActionListener(this);
		changeFrame.add(CFtwentyPenceButton);
//50p
		CFfiftyPenceButton.setBounds(256, 80, 68, 68);
		CFfiftyPenceButton.addActionListener(this);
		changeFrame.add(CFfiftyPenceButton);
//£1
		CFonePoundButton.setBounds(338, 80, 68, 68);
		CFonePoundButton.addActionListener(this);
		changeFrame.add(CFonePoundButton);
//£2
		CFtwoPoundButton.setBounds(420, 80, 68, 68);
		CFtwoPoundButton.addActionListener(this);
		changeFrame.add(CFtwoPoundButton);
//coin stock CF
		CFfivepStock.setBounds(35, 150, 18, 20);
		CFfivepStock.setEditable(false);
		changeFrame.add(CFfivepStock);
		CFtenpStock.setBounds(117, 150, 18, 20);
		CFtenpStock.setEditable(false);
		changeFrame.add(CFtenpStock);
		CFtwentypStock.setBounds(199, 150, 18, 20);
		CFtwentypStock.setEditable(false);
		changeFrame.add(CFtwentypStock);
		CFfiftypStock.setBounds(281, 150, 18, 20);
		CFfiftypStock.setEditable(false);
		changeFrame.add(CFfiftypStock);
		CFonepStock.setBounds(364, 150, 18, 20);
		CFonepStock.setEditable(false);
		changeFrame.add(CFonepStock);
		CFtwopStock.setBounds(445, 150, 18, 20);
		CFtwopStock.setEditable(false);
		changeFrame.add(CFtwopStock);
//horizontal rule
		CFruleH1.setBounds(4, 180, 490, 2);
		changeFrame.add(CFruleH1);
//changeremaining
		CFchangeRemainingLabel.setBounds(6, 190, 120, 20);
		changeFrame.add(CFchangeRemainingLabel);
		CFchangeRemaining.setBounds(125, 190, 60, 20);
		CFchangeRemaining.setEditable(false);
		changeFrame.add(CFchangeRemaining);

//output
		CFoutputMessage.setBounds(120, 220, 250, 60);
		CFoutputMessage.setEditable(false);
		changeFrame.add(CFoutputMessage);
//finished btn
		CFfinished.setBounds(192, 290, 100, 20);
		CFfinished.addActionListener(this);
		changeFrame.add(CFfinished);
//close btn
		CFclose.setBounds(145, 320, 200, 25);
		CFclose.addActionListener(this);
		CFclose.setVisible(false);
		changeFrame.add(CFclose);
	}

	private void closeChangeFrame() {
		changeFrame.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
//event handling code here
//VendingMachine.refresh(timer);
//showInputDialog(null, "Please select which type of file writer you want.\nType 'DB' for
//Database writer\n OR\nType 'FILE' for a Text File writer.\n");
//formatting for prices
		DecimalFormat poundsFormat = new DecimalFormat("£0.00");
//format for numbers (used for stock levels)
		DecimalFormat numFormat = new DecimalFormat("0");
//format for date & time
		DecimalFormat twoFormat = new DecimalFormat("00");
		DecimalFormat decFormat = new DecimalFormat("0.00");
		String addToSelection;// adds the selected product to the output section
//date:
		currentDate.setText(twoFormat.format(day) + "/" + twoFormat.format(month) + "/" + year);
//time:
		currentTime
				.setText(twoFormat.format(hours) + ":" + twoFormat.format(minutes) + ":" + twoFormat.format(seconds));
		double errorGiveChange = totalInserted - productTotal;
//change Frame actions:
//product1
		if (e.getSource() == product1) {

//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Lime Soda - £0.50";
			selectedItems.setText(addToSelection);
//adds 50p to the product total selected area
			productTotal += 0.5;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product1stockNum -= 1;
			product1stock.setText(numFormat.format(product1stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product1stockNum == 0) {
				product1.setEnabled(false);
				showMessageDialog(null, "Sorry, Lime Soda's are currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product2
		if (e.getSource() == product2) {

//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Sprite - £0.50";
			selectedItems.setText(addToSelection);
//adds 50p to the product total selected area
			productTotal += 0.5;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product2stockNum -= 1;
			product2stock.setText(numFormat.format(product2stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product2stockNum == 0) {
				product2.setEnabled(false);
				showMessageDialog(null, "Sorry, Sprite's are currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product3
		if (e.getSource() == product3) {

//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n 7up - £0.65";
			selectedItems.setText(addToSelection);
//adds 65p to the product total selected area
			productTotal += 0.65;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product3stockNum -= 1;
			product3stock.setText(numFormat.format(product3stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product3stockNum == 0) {
				product3.setEnabled(false);
				showMessageDialog(null, "Sorry, 7up's are currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product4
		if (e.getSource() == product4) {

//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Mirinda -£0.55";
			selectedItems.setText(addToSelection);
//adds 55p to the product total selected area
			productTotal += 0.55;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product4stockNum -= 1;
			product4stock.setText(numFormat.format(product4stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product4stockNum == 0) {
				product4.setEnabled(false);
				showMessageDialog(null, "Sorry, Mirinda 's arecurrently out of stock",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}

//product5
		if (e.getSource() == product5) {

//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Montain Dew - Pickled Onion -£0.70";
			selectedItems.setText(addToSelection);
//adds 70p to the product total selected area
			productTotal += 0.7;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product5stockNum -= 1;
			product5stock.setText(numFormat.format(product5stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product5stockNum == 0) {
				product5.setEnabled(false);
				showMessageDialog(null, "Sorry, Montain Dew 's are currently outof stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product6
		if (e.getSource() == product6) {
//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Fanta - Sweet - £1.10";
			selectedItems.setText(addToSelection);
//adds 1.10 to the product total selected area
			productTotal += 1.1;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product6stockNum -= 1;
			product6stock.setText(numFormat.format(product6stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product6stockNum == 0)

			{
				product6.setEnabled(false);
				showMessageDialog(null, "Sorry, Fanta's are currently out ofstock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product7
		if (e.getSource() == product7) {
			showMessageDialog(null, "Please exercise caution when opening this drink.\n\nIt may be shaken.", "Caution!",
					JOptionPane.WARNING_MESSAGE);
//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Coca-Cola (330ml) - £0.75";
			selectedItems.setText(addToSelection);
//adds 75p to the product total selected area
			productTotal += 0.75;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product7stockNum -= 1;
			product7stock.setText(numFormat.format(product7stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product7stockNum == 0) {
				product7.setEnabled(false);
				showMessageDialog(null, "Sorry, Coca-Cola is currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product8
		if (e.getSource() == product8) {
			showMessageDialog(null, "Please exercise caution when opening this drink.\n\nIt may be shaken.", "Caution!",
					JOptionPane.WARNING_MESSAGE);
//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Dr Pepper (330ml) - £0.75";
			selectedItems.setText(addToSelection);
//adds 75p to the product total selected area
			productTotal += 0.75;

			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product8stockNum -= 1;
			product8stock.setText(numFormat.format(product8stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product8stockNum == 0) {
				product8.setEnabled(false);
				showMessageDialog(null, "Sorry, Dr Pepper is currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product9
		if (e.getSource() == product9) {
//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Fruit - £0.60";
			selectedItems.setText(addToSelection);
//adds 60p to the product total selected area
			productTotal += 0.6;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product9stockNum -= 1;
			product9stock.setText(numFormat.format(product9stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product9stockNum == 0) {
				product9.setEnabled(false);
				showMessageDialog(null, "Sorry, Fruit are currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//product10
		if (e.getSource() == product10) {
//adds the text string the the selected items text field
			addToSelection = selectedItems.getText() + "\n Wine - £0.65";
			selectedItems.setText(addToSelection);

//adds 65p to the product total selected area
			productTotal += 0.65;
			selectedItemTotal.setText(poundsFormat.format(productTotal));
//updates the stock count by deducting 1
			product10stockNum -= 1;
			product10stock.setText(numFormat.format(product10stockNum));
//if the product stock is 0, disabled the product and brings up an error message
			if (product10stockNum == 0) {
				product10.setEnabled(false);
				showMessageDialog(null, "Sorry, Wine  are currently out of stock", "Stock Depleted!",
						JOptionPane.WARNING_MESSAGE);
			}
		}
//cancel order
		if (e.getSource() == cancelOrder) {
			selectedItems.setText("");
			moneyInput.setText(poundsFormat.format(productTotal - productTotal));
			selectedItemTotal.setText("£0.00");
			outputMessage.setText("");
			outputMessage.setBackground(Color.white);
//gets rid of take change button incase the previous order had change to be given
			takeChange.setVisible(false);
//reset values
			totalInserted = 0;
			productTotal = 0;
		}
//enter
		if (e.getSource() == enterCoins)// if enter coins button is pressed:
		{
			String productsFW = selectedItems.getText();
			String totalFW = selectedItemTotal.getText();
			String inputFW = moneyInput.getText();
			dh.write(productsFW, totalFW, inputFW);
			double changePH = errorGiveChange;
			CFchangeRemaining.setText(decFormat.format(changePH));
//first check if anything has been input, first money, then products
//if no money is input at all
			if (totalInserted == 0) {
				outputMessage
						.setText("Error! Please input your money using the \n'InputMoney' Section!\n You need to input "
								+ poundsFormat.format(productTotal) + " !");
				outputMessage.setBackground(Color.red);
			}
//if no product is input
			else if (productTotal == 0) {

				outputMessage.setText("Error! Please select at least one product!");
				outputMessage.setBackground(Color.red);
			} else if (productTotal == totalInserted)// Correct money is input
			{
				outputMessage
						.setText(poundsFormat.format(totalInserted) + " Accepted!\n\nThank you for your purchase!");
				outputMessage.setBackground(Color.green);
//clear all other areas once accepted:
				selectedItems.setText("");
				selectedItemTotal.setText("£0.00");
				moneyInput.setText("£0.00");
//reset values to 0
				totalInserted = 0;
				productTotal = 0;
			} else if (totalInserted < productTotal)// Not enough money is input
			{
//this works out the rest of the input needed:
				double errorInputShort = productTotal - totalInserted;
//this sum is then applied with pounds format to the output message to tell the user:
				outputMessage.setText("Error! Please input the correct amount!\n\n You still have "
						+ poundsFormat.format(errorInputShort) + " to pay!");
				outputMessage.setBackground(Color.red);
			} else if (totalInserted > productTotal)// if too much money is input
			{
//make the "take change button visible
				takeChange.setVisible(true);
//disable other buttons, gives focus and is professioanl and eliminates error
				product1.setEnabled(false);
				product2.setEnabled(false);
				product3.setEnabled(false);
				product4.setEnabled(false);
				product5.setEnabled(false);
				product6.setEnabled(false);
				product7.setEnabled(false);
				product8.setEnabled(false);
				product9.setEnabled(false);
				product10.setEnabled(false);
				enterCoins.setEnabled(false);
				returnCoins.setEnabled(false);
				cancelOrder.setEnabled(false);
				fivePenceButton.setEnabled(false);
				tenPenceButton.setEnabled(false);
				twentyPenceButton.setEnabled(false);
				fiftyPenceButton.setEnabled(false);
				onePoundButton.setEnabled(false);
				twoPoundButton.setEnabled(false);

//this is then added to the output message (with pounds format)
				outputMessage.setText(poundsFormat.format(totalInserted)
						+ " Accepted!Thank you for your purchase!\nPlease take your "
						+ poundsFormat.format(errorGiveChange) + "change.\nPress the 'Take Change' button below:");
				outputMessage.setBackground(Color.green);
//clear textfields
				selectedItems.setText("");
				selectedItemTotal.setText("£0.00");
				moneyInput.setText("£0.00");
//reset values
				totalInserted = 0;
				productTotal = 0;
			}
		}
//take change button
		if (e.getSource() == takeChange) {
//removes the button as it is clicked, so it cannot be shown again till an order has been made
			takeChange.setVisible(false);
			changeFrameInit();
			changeFrame.setVisible(true);
//sets the money stock into that of the change frame
			CFfivepStock.setText(numFormat.format(fivepStockNum));
			CFtenpStock.setText(numFormat.format(tenpStockNum));
			CFtwentypStock.setText(numFormat.format(twentypStockNum));
			CFfiftypStock.setText(numFormat.format(fiftypStockNum));
			CFonepStock.setText(numFormat.format(onepStockNum));
			CFtwopStock.setText(numFormat.format(twopStockNum));
		}
//CF 5p
		if (e.getSource() == CFfivePenceButton) {
//deducts one count from the change stock
			fivepStockNum -= 1;
			CFfivepStock.setText(numFormat.format(fivepStockNum));
//deducts amount from the change remaining
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());
			calcChange -= 0.05;
			CFchangeRemaining.setText(decFormat.format(calcChange));
//if user tries to take too much change
			if (calcChange < 0) {
				calcChange += 0.05; // adds the 1pound back to the value
				CFchangeRemaining.setText(decFormat.format(calcChange));
//reset the stock value (as if it was never changed)
				fivepStockNum += 1;
				CFfivepStock.setText(numFormat.format(fivepStockNum));

//set error message
				CFoutputMessage.setText(" Error!\nYou cannot takethat much!\nYou only have £"
						+ decFormat.format(calcChange) + " in change left to take!");
				CFoutputMessage.setBackground(Color.red);
			}
			if (fivepStockNum == 0) {
				CFfivePenceButton.setEnabled(false);
				showMessageDialog(null, "Sorry, there are no 5 pence coins left.\n\nPleaseselect other coins.",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}
//CF 10p
		if (e.getSource() == CFtenPenceButton) {
//deducts one count from the change stock
			tenpStockNum -= 1;
			CFtenpStock.setText(numFormat.format(tenpStockNum));
//deducts amount from the change remaning
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());
			calcChange -= 0.1;
			CFchangeRemaining.setText(decFormat.format(calcChange));
//if user tries to take too much change
			if (calcChange < 0) {
				calcChange += 0.1; // adds the 1pound back to the value
				CFchangeRemaining.setText(decFormat.format(calcChange));
//reset the stock value (as if it was never changed)
				tenpStockNum += 1;
				CFtenpStock.setText(numFormat.format(tenpStockNum));
//set error message
				CFoutputMessage.setText(" Error!\nYou cannot takethat much!\nYou only have £"
						+ decFormat.format(calcChange) + " in change left to take!");
				CFoutputMessage.setBackground(Color.red);
			}
			if (tenpStockNum == 0) {
				CFtenPenceButton.setEnabled(false);
				showMessageDialog(null, "Sorry, there are no 10 pence coins left.\n\nPlease select other coins.",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}
//CF 20p
		if (e.getSource() == CFtwentyPenceButton) {
//deducts one count from the change stock
			twentypStockNum -= 1;

			CFtwentypStock.setText(numFormat.format(twentypStockNum));
//deducts amount from change remaining
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());
			calcChange -= 0.2;
			CFchangeRemaining.setText(decFormat.format(calcChange));
//if user tries to take too much change
			if (calcChange < 0) {
				calcChange += 0.2; // adds the 1pound back to the value
				CFchangeRemaining.setText(decFormat.format(calcChange));
//reset the stock value (as if it was never changed)
				twentypStockNum += 1;
				CFtwentypStock.setText(numFormat.format(twentypStockNum));
//set error message
				CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have £"
						+ decFormat.format(calcChange) + " in change left to take!");
				CFoutputMessage.setBackground(Color.red);
			}
			if (twentypStockNum == 0) {
				CFtwentyPenceButton.setEnabled(false);
				showMessageDialog(null, "Sorry, there are no 20 pence coins left.\n\nPlease select other coins.",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}
//CF 50p
		if (e.getSource() == CFfiftyPenceButton) {
//deducts one count from the change stock
			fiftypStockNum -= 1;
			CFfiftypStock.setText(numFormat.format(fiftypStockNum));
//deducts amount from change remaining
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());
			calcChange -= 0.5;
			CFchangeRemaining.setText(decFormat.format(calcChange));
//if user tries to take too much change
			if (calcChange < 0) {
				calcChange += 0.5; // adds the 1pound back to the value
				CFchangeRemaining.setText(decFormat.format(calcChange));
//reset the stock value (as if it was never changed)
				fiftypStockNum += 1;
				CFfiftypStock.setText(numFormat.format(fiftypStockNum));
//set error message
				CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have £"
						+ decFormat.format(calcChange) + " in change left to take!");

				CFoutputMessage.setBackground(Color.red);
			}
			if (fiftypStockNum == 0) {
				CFfiftyPenceButton.setEnabled(false);
				showMessageDialog(null, "Sorry, there are no 50 pence coins left.\n\nPlease select other coins.",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}
//CF 1pound
		if (e.getSource() == CFonePoundButton) {
//deducts one count from the change stock
			onepStockNum -= 1;
			CFonepStock.setText(numFormat.format(onepStockNum));
//deducts amount from change remaining
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());
			calcChange -= 1;
			CFchangeRemaining.setText(decFormat.format(calcChange));
//if user tries to take too much change
			if (calcChange < 0) {
				calcChange += 1; // adds the 1pound back to the value
				CFchangeRemaining.setText(decFormat.format(calcChange));
//reset the stock value (as if it was never changed)
				onepStockNum += 1;
				CFonepStock.setText(numFormat.format(onepStockNum));
//set error message
				CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have £"
						+ decFormat.format(calcChange) + " in change left to take!");
				CFoutputMessage.setBackground(Color.red);
			}
			if (onepStockNum == 0) {
				CFonePoundButton.setEnabled(false);
				showMessageDialog(null, "Sorry, there are no 1 pound coins left.\n\nPlease select other coins.",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}
//CF 2pound
		if (e.getSource() == CFtwoPoundButton) {
//deducts one count from the change stock
			twopStockNum -= 1;
			CFtwopStock.setText(numFormat.format(twopStockNum));
//deducts amount from change remaining
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());

			calcChange -= 2;
			CFchangeRemaining.setText(decFormat.format(calcChange));
//if user tries to take too much change
			if (calcChange < 0) {
				calcChange += 2; // adds the 1pound back to the value
				CFchangeRemaining.setText(decFormat.format(calcChange));
//reset the stock value (as if it was never changed)
				twopStockNum += 1;
				CFtwopStock.setText(numFormat.format(twopStockNum));
//set error message
				CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have £"
						+ decFormat.format(calcChange) + " in change left to take!");
				CFoutputMessage.setBackground(Color.red);
			}
			if (twopStockNum == 0) {
				CFtwoPoundButton.setEnabled(false);
				showMessageDialog(null, "Sorry, there are no 2 pound coins left.\n\nPlease select other coins.",
						"Stock Depleted!", JOptionPane.WARNING_MESSAGE);
			}
		}
//CF finished button
		if (e.getSource() == CFfinished) {
//gets value of change remaining
			double calcChange = Double.parseDouble(CFchangeRemaining.getText());
			if (calcChange > 0) {
				CFoutputMessage
						.setText(" Error!\n\nYou still have £" + decFormat.format(calcChange) + " in change to take!");
				CFoutputMessage.setBackground(Color.red);
			}
			if (calcChange == 0) {
				CFoutputMessage.setText(" Thank You!\nPlease press the button below to close\nthis window.");
				CFoutputMessage.setBackground(Color.green);
//enables the close button visible
				CFclose.setVisible(true);
//disables all other buttons on the frame, adds focus, gives user indication of what to do next
				CFfivePenceButton.setEnabled(false);
				CFtenPenceButton.setEnabled(false);
				CFtwentyPenceButton.setEnabled(false);
				CFfiftyPenceButton.setEnabled(false);
				CFonePoundButton.setEnabled(false);

				CFtwoPoundButton.setEnabled(false);
				CFfinished.setEnabled(false);
			}
		}
//change frame close button
		if (e.getSource() == CFclose) {
//calls function close change frame
			closeChangeFrame();
//re-enable all buttons on main frame
			product1.setEnabled(true);
			product2.setEnabled(true);
			product3.setEnabled(true);
			product4.setEnabled(true);
			product5.setEnabled(true);
			product6.setEnabled(true);
			product7.setEnabled(true);
			product8.setEnabled(true);
			product9.setEnabled(true);
			product10.setEnabled(true);
			enterCoins.setEnabled(true);
			returnCoins.setEnabled(true);
			cancelOrder.setEnabled(true);
			fivePenceButton.setEnabled(true);
			tenPenceButton.setEnabled(true);
			twentyPenceButton.setEnabled(true);
			fiftyPenceButton.setEnabled(true);
			onePoundButton.setEnabled(true);
			twoPoundButton.setEnabled(true);
			CFfivePenceButton.setEnabled(true);
			CFtenPenceButton.setEnabled(true);
			CFtwentyPenceButton.setEnabled(true);
			CFfiftyPenceButton.setEnabled(true);
			CFonePoundButton.setEnabled(true);
			CFtwoPoundButton.setEnabled(true);
			CFfinished.setEnabled(true);
//reset the output message on main frame
			outputMessage.setText("");
			outputMessage.setBackground(Color.white);
		}
//return
		if (e.getSource() == returnCoins) {
			if (totalInserted == 0)// if no money has been input
			{
				outputMessage.setText("You have not input any money!\n\nPlease try again!");
				outputMessage.setBackground(Color.red);
//clear money input
				moneyInput.setText("£0.00");
//no need to reset value to zero as nothing has been put in
			}

			else// if something HAS been input
			{
				outputMessage.setText(poundsFormat.format(totalInserted) + " Returned.\n\nPlease take your money.");
				outputMessage.setBackground(Color.red);
//clear money input
				moneyInput.setText("£0.00");
//reset money input value
				totalInserted = 0;
			}
		}
//moneyInput Section
//5 pence
		if (e.getSource() == fivePenceButton) {
//updates the total input value
			totalInserted += 0.05;
			moneyInput.setText(poundsFormat.format(totalInserted));
//updates the stock count by deducting 1
			fivepStockNum += 1;
			fivepStock.setText(numFormat.format(fivepStockNum));
		}
//10 pence
		if (e.getSource() == tenPenceButton) {
//updates the total input value
			totalInserted += 0.1;
			moneyInput.setText(poundsFormat.format(totalInserted));
//updates the stock count by deducting 1
			tenpStockNum += 1;
			tenpStock.setText(numFormat.format(tenpStockNum));
		}
//20 pence
		if (e.getSource() == twentyPenceButton) {
//updates the total input value
			totalInserted += 0.2;
			moneyInput.setText(poundsFormat.format(totalInserted));
			twentypStockNum += 1;
			twentypStock.setText(numFormat.format(twentypStockNum));
		}
//50 pence
		if (e.getSource() == fiftyPenceButton) {
//updates the total input value
			totalInserted += 0.5;

			moneyInput.setText(poundsFormat.format(totalInserted));
//updates the stock count by deducting 1
			fiftypStockNum += 1;
			fiftypStock.setText(numFormat.format(fiftypStockNum));
		}
//1 pound
		if (e.getSource() == onePoundButton) {
//updates the total input value
			totalInserted += 1;
			moneyInput.setText(poundsFormat.format(totalInserted));
//updates the stock count by deducting 1
			onepStockNum += 1;
			onepStock.setText(numFormat.format(onepStockNum));
		}
//2 pounds
		if (e.getSource() == twoPoundButton) {
//updates the total input value
			totalInserted += 2;
			moneyInput.setText(poundsFormat.format(totalInserted));
//updates the stock count by adding 1
			twopStockNum += 1;
			twopStock.setText(numFormat.format(twopStockNum));
		}
		
	}
}