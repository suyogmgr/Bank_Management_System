package com.bank_management_system;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.event.*;
import javax.swing.*;

public class MiniStatement extends JFrame {

	String pinNum;

	MiniStatement(String pinNum) {
		this.pinNum = pinNum;
		setTitle("MiniStatement");
		setLayout(null);

		JLabel label = new JLabel();
		add(label);

		JLabel bank = new JLabel("Nepal Bank");
		bank.setFont(new Font("Arial", Font.BOLD, 18));
		bank.setBounds(150, 40, 100, 40);
		add(bank);

		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);

		try {
			Connector c = new Connector();
			ResultSet rs = c.s.executeQuery("Select * from login where pinNum = '" + pinNum + "'");

			while (rs.next()) {
				card.setText("Card Number" + rs.getString("cardNum").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("cardNum").substring(0, 4));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Connector c = new Connector();

			ResultSet rs = c.s.executeQuery("Select * from bank where pinNum = '" + pinNum + "'");
			while (rs.next()) {
				card.setText(card.getText() + "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		card.setBounds(20,140,400,20);

		setSize(400, 600);
		setLocation(500, 200);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}
}
