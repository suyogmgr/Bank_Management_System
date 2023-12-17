package com.bank_management_system;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.ImageIcon;


public class BalanceEnquiry extends JFrame implements ActionListener {
	
	JButton back;
	String pinNum;
	BalanceEnquiry(String pinNum){
		this.pinNum = pinNum;
		setTitle("BalanceEnquiry");
		setLayout(null);
		
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);
		JLabel image  = new JLabel(img2);
		image.setBounds(0,0,900,900);
		add(image);
		
		back = new JButton("Back");
		back.setFont(new Font("Arial", Font.BOLD,18));
		back.setBackground(Color.white);
		back.setBounds(400,560,100,30);
		back.addActionListener(this);
		image.add(back);
		
		Connector c = new Connector();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("Select * from bank where pinNum = '"+pinNum+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance = Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		JLabel label = new JLabel("Your Current Account Balance is Rs "+ balance);
		label.setForeground(Color.white);
		label.setBounds(180,300,400,40);
		image.add(label);
		
		setSize(900,900);
		setLocation(400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == back) {
			setVisible(false);
			new Transaction(pinNum).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
	
}
