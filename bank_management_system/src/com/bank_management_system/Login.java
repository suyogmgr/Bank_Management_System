package com.bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	// declaring globally
	JButton login, clear, signup;
	JTextField cardText;
	JPasswordField cardText1;

	// creating a constructor
	Login() {

		setTitle("ATM");// setting name
		setLayout(null);// to change the layout for the icon

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
		Image img1 = img.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		// cannot put Image into JLabel
		ImageIcon img2 = new ImageIcon(img1);
		JLabel label = new JLabel(img2);
		label.setBounds(180, 10, 100, 100); // to move the icons on the top left corner
		add(label);// adding to the Frame

		// adding text
		JLabel text = new JLabel("Welcome to the ATM");
		text.setFont(new Font("Open Sans", Font.BOLD, 30));// changing the font
		// making it visible
		text.setBounds(290, 40, 400, 40);
		add(text);

		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Open Sans", Font.BOLD, 30));
		cardNo.setBounds(120, 150, 150, 40);
		add(cardNo);

		cardText = new JTextField();
		cardText.setBounds(300, 150, 250, 40);
		cardText.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add(cardText);

		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Open Sans", Font.BOLD, 30));
		pin.setBounds(120, 220, 150, 40);
		add(pin);

		cardText1 = new JPasswordField();
		cardText1.setBounds(300, 220, 250, 40);
		cardText1.setFont(new Font("Open Sans", Font.PLAIN, 20));
		add(cardText1);

		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 40);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);

		clear = new JButton("CLEAR");
		clear.setBounds(450, 300, 100, 40);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);

		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 250, 40);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);

		// to change the background color
		getContentPane().setBackground(Color.WHITE);
		// getContentPane().setBackground(new Color(15,21,32));

		setSize(800, 450);// size of the Frame
		setLocation(400, 300);
		setVisible(true);// to make the Frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// to close the Frame
		setResizable(false);// can't resize Frame
		// setLocation(400, 250);// changing the default location of where the Frame
		// will open

	}

	// Overriding the interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			cardText.setText("");
			cardText1.setText("");
		} else if (e.getSource() == login) {
			Connector c = new Connector();
			String cardNum = cardText.getText();
			String pinNum = cardText1.getText();
			String query = "Select * from login where cardNum = '" + cardNum + "' and pinNum = '" + pinNum + "'";
			try {
				// to check the data from the database and compare them
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transaction(pinNum).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		} else if (e.getSource() == signup) {
			setVisible(false);
			new SignUp(null).setVisible(true);
		}
	}

	public static void main(String[] args) {

		new Login();
	}
}