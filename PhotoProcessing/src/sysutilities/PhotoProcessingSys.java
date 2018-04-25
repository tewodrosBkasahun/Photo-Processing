package sysutilities;

import javax.swing.*;

public class PhotoProcessingSys {

	String name;
	double balance;
	Address address;
	StringBuffer tran = new StringBuffer("");
	int tranNum = 0;

	public PhotoProcessingSys(String name, String street, String city, String state, String zipCode) {
		this.name = name;
		balance = 0;
		try {
			address = new Address(street, city, state, zipCode);
		} catch (IllegalArgumentException e) {
			address = new Address();
		}
	}

	public PhotoProcessingSys() {
		this.name = "NONAME";
		address = new Address();
	}

	public String toString() {
		return "Customer Name: " + name + "\n" + "Customer Address: " + address + "\nBalance: " + balance;

	}

	public String imageTransaction(String imageName, String task, String taskOptions, boolean graphicalMode) {

		String returned;
		if (graphicalMode) {
			PictureManager.graphicalModeOn();
		} else {
			PictureManager.graphicalModeOff();
		}

		if (task.equals("display")) {
			returned = (PictureManager.displayPicture(imageName));
			balance++;
		} else if (task.equals("clear")) {
			returned = (PictureManager.clearScreen());
			balance++;
		} else if (task.equals("displaylast")) {
			returned = (PictureManager.displayLastPicture());
			balance++;
		} else if (task.equals("blackandwhite")) {
			returned = (PictureManager.displayPictureBlackWhitePosterize(imageName, true, false));
			balance++;
		} else if (task.equals("posterize")) {
			returned = (PictureManager.displayPictureBlackWhitePosterize(imageName, false, true));
			balance++;
		} else if (task.equals("blackandwhiteposterize")) {
			returned = (PictureManager.displayPictureBlackWhitePosterize(imageName, true, true));
			balance++;
		} else if (task.equals("selectcolors")) {
			boolean isRed = false;
			boolean isGreen = false;
			boolean isBlue = false;
			taskOptions.trim();
			if (taskOptions.indexOf("r") >= 0 || taskOptions.indexOf("R") >= 0)
				isRed = true;
			if (taskOptions.indexOf("g") >= 0 || taskOptions.indexOf("G") >= 0)
				isGreen = true;
			if (taskOptions.indexOf("b") >= 0 || taskOptions.indexOf("B") >= 0)
				isBlue = true;

			returned = (PictureManager.displayPictureSelectRedGreenBlue(imageName, isRed, isGreen, isBlue));
			balance += 2;
		} else {
			returned = ("Invalid photoProcessing option");
		}

		if (graphicalMode)
			JOptionPane.showInternalMessageDialog(null, "Continue");

		tranNum++;
		tran.append("Transaction #" + tranNum + ": " + returned);

		return returned;

	}

	public String getTransactions() {
		return "Image Transactions \n" + tran.toString();
	}

	public double getBalance() {
		return balance;
	}

}