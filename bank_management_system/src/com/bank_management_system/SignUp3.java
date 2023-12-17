package com.bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener {

	JRadioButton j1, j2, j3, j4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String form;

	SignUp3(String form) {
		this.form = form;
		setTitle("SignUp Page");
		setSize(850, 820);
		setLayout(null);
		setLocation(400, 100);

		JLabel details = new JLabel("Page 3: Account Details");
		details.setFont(new Font("Times New Roman", Font.BOLD, 30));
		details.setBounds(250, 40, 500, 40);
		add(details);

		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Times New Roman", Font.BOLD, 22));
		type.setBounds(200, 100, 200, 40);
		add(type);

		j1 = new JRadioButton("Saving Account");
		j1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		j1.setBounds(200, 160, 200, 30);
		j1.setBackground(Color.WHITE);
		add(j1);

		j2 = new JRadioButton("Fixed Deposit Account");
		j2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		j2.setBounds(450, 160, 200, 30);
		j2.setBackground(Color.WHITE);
		add(j2);

		j3 = new JRadioButton("Current Account");
		j3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		j3.setBounds(200, 210, 200, 30);
		j3.setBackground(Color.WHITE);
		add(j3);

		j4 = new JRadioButton("Recurring Deposit Account");
		j4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		j4.setBounds(450, 210, 300, 30);
		j4.setBackground(Color.WHITE);
		add(j4);

		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(j1);
		accountGroup.add(j2);
		accountGroup.add(j3);
		accountGroup.add(j4);

		JLabel cardNo = new JLabel("Card Number");
		cardNo.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cardNo.setBounds(200, 270, 200, 40);
		add(cardNo);

		JLabel number = new JLabel("XXXX-XXXX-XXXX-4459");
		number.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		number.setBounds(400, 270, 300, 40);
		add(number);

		JLabel cardNumber = new JLabel("Your 16 Digit Card Number");
		cardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cardNumber.setBounds(200, 300, 300, 20);
		add(cardNumber);

		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		pin.setBounds(200, 340, 200, 40);
		add(pin);

		JLabel pinNo = new JLabel("XXXX");
		pinNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pinNo.setBounds(400, 340, 100, 40);
		add(pinNo);

		JLabel pinNumber = new JLabel("Your 4 Digit Password");
		pinNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pinNumber.setBounds(200, 370, 300, 20);
		add(pinNumber);

		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Times New Roman", Font.BOLD, 22));
		services.setBounds(200, 400, 200, 40);
		add(services);

		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c1.setBounds(200, 450, 200, 30);
		add(c1);

		c2 = new JCheckBox("E-Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c2.setBounds(400, 450, 200, 30);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c3.setBounds(200, 490, 200, 30);
		add(c3);

		c4 = new JCheckBox("Email and SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c4.setBounds(400, 490, 200, 30);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c5.setBounds(200, 530, 200, 30);
		add(c5);

		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c6.setBounds(400, 530, 200, 30);
		add(c6);

		c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		c7.setBounds(200, 600, 600, 20);
		add(c7);

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		submit.setBounds(250, 680, 150, 30);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cancel.setBounds(450, 680, 150, 30);
		cancel.addActionListener(this);
		add(cancel);

		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == submit) {
			String accountType = null;
			if (j1.isSelected()) {
				accountType = "Saving Account";
			} else if (j2.isSelected()) {
				accountType = "Fixed Deposit Account";
			} else if (j3.isSelected()) {
				accountType = "Current Account";
			} else if (j4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}

			Random random = new Random();
			String cardNum = Long.toString(Math.abs(random.nextLong() % 9000000L + 8888888800000000L));

			String pinNum = Long.toString(Math.abs(random.nextLong() % 9000L + 1000L));

			String facility = "";
			if (c1.isSelected()) {
				facility = facility + "ATM CARD";
			} else if (c2.isSelected()) {
				facility = facility + "E-Banking";
			} else if (c3.isSelected()) {
				facility = facility + "Mobile Banking";
			} else if (c4.isSelected()) {
				facility = facility + "Email and SMS Alerts";
			} else if (c5.isSelected()) {
				facility = facility + "Cheque Book";
			} else if (c6.isSelected()) {
				facility = facility + "E-Statement";
			}

			try {
				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "The Account Type is Required");
				} else if (facility.equals("")) {
					JOptionPane.showMessageDialog(null, "Need To Select Atleast One Faculity");

					/*
					 * else if(c7.equals("")) {
					 * JOptionPane.showMessageDialog(null,"Need To Agree The Terms And Services"); }
					 */

				} else {
					Connector c = new Connector();
					String query = "insert into signup3 values ('" + form + "','" + accountType + "', '" + cardNum
							+ "','" + pinNum + "', '" + facility + "')";
					String query1 = "insert into login values ('" + form + "','" + cardNum + "','" + pinNum + "')";
					c.s.execute(query);
					c.s.execute(query1);

					JOptionPane.showMessageDialog(null, "Card No: " + cardNum + "\nPin No:" + pinNum);

					setVisible(false);

					new Transaction(pinNum).setVisible(true);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else if (a.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new SignUp3("");
	}
}
