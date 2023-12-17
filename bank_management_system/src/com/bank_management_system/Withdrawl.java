package com.bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

	JButton withdraw, back;
	JTextField amount;
	String pinNum;

	Withdrawl(String pinNum) {
		this.pinNum = pinNum;

		setTitle("Withdrawl");
		setLayout(null);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);
		JLabel image = new JLabel(img2);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Enter the Amount You Want To Withdraw");
		text.setFont(new Font("Times New Roman", Font.BOLD, 18));
		text.setBounds(170, 355, 400, 30);
		text.setForeground(Color.WHITE);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		amount.setBounds(180, 420, 320, 30);
		image.add(amount);

		withdraw = new JButton("Withdraw");
		withdraw.setFont(new Font("Times New Roman", Font.BOLD, 18));
		withdraw.setBounds(390, 520, 110, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.BOLD, 18));
		back.setBounds(400, 560, 100, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() == withdraw) {
			String money = amount.getText();
			Date date = new Date();
			if (money.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount you want to Withdraw");
			} else {
				try {
					Connector c = new Connector();
					String query = "insert into bank values('" + pinNum + "','" + date + "','Withdraw','" + money
							+ "')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " + money + " Withdraw Sucessfully");
					setVisible(false);
					new Transaction(pinNum).setVisible(true);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		} else if (a.getSource() == back) {
			setVisible(false);
			new Transaction(pinNum).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Withdrawl("");
	}
}
