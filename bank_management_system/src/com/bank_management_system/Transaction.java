package com.bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

	JButton deposit, withdrawl, fastCash, ministatement, pinChange, balance, exit;
	String pinNum;

	Transaction(String pinNum) {
		this.pinNum = pinNum;

		setTitle("Transaction");
		setLayout(null);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);

		JLabel label = new JLabel(img2);
		label.setBounds(0, 0, 900, 900);
		add(label);

		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(235, 350, 500, 35);
		text.setFont(new Font("Times New Roman", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		// to write on the image
		label.add(text);

		deposit = new JButton("Deposit");
		deposit.setBounds(170, 450, 150, 30);
		deposit.addActionListener(this);
		label.add(deposit);

		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355, 450, 150, 30);
		withdrawl.addActionListener(this);
		label.add(withdrawl);

		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 490, 150, 30);
		fastCash.addActionListener(this);
		label.add(fastCash);

		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355, 490, 150, 30);
		ministatement.addActionListener(this);
		label.add(ministatement);

		pinChange = new JButton("Pin Change");
		pinChange.setBounds(170, 530, 150, 30);
		pinChange.addActionListener(this);
		label.add(pinChange);

		balance = new JButton("Balance Inquiry");
		balance.setBounds(355, 530, 150, 30);
		balance.addActionListener(this);
		label.add(balance);

		exit = new JButton("Exit");
		exit.setBounds(355, 565, 150, 30);
		exit.addActionListener(this);
		label.add(exit);

		getContentPane().setBackground(Color.WHITE);

		setUndecorated(true);
		setSize(900, 900);
		setLocation(300, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == exit) {
			System.exit(0);
		} else if (a.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinNum).setVisible(true);
		} else if (a.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinNum).setVisible(true);
		} else if (a.getSource() == fastCash) {
			setVisible(false);
			new FastCash(pinNum).setVisible(true);
		} else if (a.getSource() == pinChange) {
			setVisible(false);
			new PinChange(pinNum).setVisible(true);
		} else if (a.getSource() == balance) {
			setVisible(false);
			new BalanceEnquiry(pinNum).setVisible(true);
		}else if (a.getSource() == ministatement) {
			setVisible(false);
			new MiniStatement(pinNum).setVisible(true);
		}

	}

	public static void main(String[] args) {
		new Transaction("");
	}
}
