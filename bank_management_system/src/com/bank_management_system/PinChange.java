package com.bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin, newPin;
	JButton back, change;
	String pinNum;
	PinChange(String pinNum){
		this.pinNum = pinNum;
		setTitle("PIN CHANGE");
		setLayout(null);
		
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);
		JLabel image = new JLabel(img2);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel changePin = new JLabel("CHAGE YOUR PIN");
		changePin.setFont(new Font("Arial", Font.BOLD,18));
		changePin.setBounds(250,320,300,40);
		changePin.setForeground(Color.white);
		image.add(changePin);
		
		JLabel pinText = new JLabel("New Pin");
		pinText.setFont(new Font("Arial", Font.BOLD,16));
		pinText.setBounds(160,360,300,40);
		pinText.setForeground(Color.white);
		image.add(pinText);
		
		
		pin = new JPasswordField();
		pin.setFont(new Font("Arial", Font.PLAIN,16));
		pin.setBounds(320,360,170,30);
		image.add(pin);
		
		JLabel rePin = new JLabel("RE-Enter New Pin");
		rePin.setFont(new Font("Arial", Font.BOLD,16));
		rePin.setBounds(160,400,300,40);
		rePin.setForeground(Color.white);
		image.add(rePin);
		
		newPin = new JPasswordField();
		newPin.setFont(new Font("Arial", Font.PLAIN,16));
		newPin.setBounds(320,400,170,30);
		image.add(newPin);
		
		change = new JButton("Change");
		change.setBounds(400,525,100,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(400,560,100,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(400,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == change) {
		try {
			String nPin = pin.getText();
			String rPin = newPin.getText();
			
			if(!nPin.equals(rPin)) {
				JOptionPane.showMessageDialog(null,"Entered PIN does not match");
				return;
			}
			if(nPin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter PIN");
				return;
			}
			
			if(rPin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please re-enter PIN");
				return;
			}
			Connector c = new Connector();
			String query1 = "UPDATE bank SET pinNum = '" + rPin + "' WHERE pinNum = '" + pinNum + "'";
			String query2 = "UPDATE login SET pinNum = '" + rPin + "' WHERE pinNum = '" + pinNum + "'";
			String query3 = "UPDATE signup3 SET pinNum = '" + rPin + "' WHERE pinNum = '" + pinNum + "'";
			
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			c.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null,"PIN Changed Sucessfully");
			
			setVisible(false);
			new Transaction(rPin).setVisible(true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}else {		
		setVisible(false);
		new Transaction(pinNum).setVisible(true);
	}
}
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}
}
