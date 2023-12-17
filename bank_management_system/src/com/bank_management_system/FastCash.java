package com.bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

	JButton r1, r2, r3, r4, r5, r6, back;
	String pinNum;

	FastCash(String pinNum) {
		this.pinNum = pinNum;

		setTitle("FastCash");
		setLayout(null);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);

		JLabel label = new JLabel(img2);
		label.setBounds(0, 0, 900, 900);
		add(label);

		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(225, 350, 500, 35);
		text.setFont(new Font("Times New Roman", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		// to write on the image
		label.add(text);

		r1 = new JButton("Rs 100");
		r1.setBounds(170, 450, 150, 30);
		r1.addActionListener(this);
		label.add(r1);

		r2 = new JButton("Rs 500");
		r2.setBounds(355, 450, 150, 30);
		r2.addActionListener(this);
		label.add(r2);

		r3 = new JButton("Rs 1000");
		r3.setBounds(170, 490, 150, 30);
		r3.addActionListener(this);
		label.add(r3);

		r4 = new JButton("Rs 2000");
		r4.setBounds(355, 490, 150, 30);
		r4.addActionListener(this);
		label.add(r4);

		r5 = new JButton("Rs 5000");
		r5.setBounds(170, 530, 150, 30);
		r5.addActionListener(this);
		label.add(r5);

		r6 = new JButton("Rs 10000");
		r6.setBounds(355, 530, 150, 30);
		r6.addActionListener(this);
		label.add(r6);

		back = new JButton("Back");
		back.setBounds(355, 565, 150, 30);
		back.addActionListener(this);
		label.add(back);

		getContentPane().setBackground(Color.WHITE);

		setUndecorated(true);
		setSize(900, 900);
		setLocation(300, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == back) {
			setVisible(false);
			new Transaction(pinNum).setVisible(true);
		} else {
			// a.getSource() is a object so JButton
			// substring(3) to reomve the 'Rs'
			String amount = ((JButton) a.getSource()).getText().substring(3);
			Connector c = new Connector();
			try {
				ResultSet rs = c.s.executeQuery("Select * from bank where pinNum = '" + pinNum + "'");
				int balance = 0;
				while (rs.next()) {
					if (rs.getString("type").equals("Deposit")) {
						balance = Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if (a.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}

				Date date = new Date();
				String query = "insert into bank values('" + pinNum + "','" + date + "','Withdraw','" + amount + "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + "Debited Sucessfully");
				new Transaction(pinNum).setVisible(true);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		new FastCash("");
	}
}
