package com.bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	long Random;
	JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField,
			dateTextField, pinTextField;
	JButton next;
	JRadioButton male, female, married, unmarried;

	SignUp(String form) {
		// to get random value
		Random ran = new Random();
		// integer random = ran.nextInt(9000) + 1000;

		// Maths.abs to get positive value
		Random = Math.abs((ran.nextLong() % 9000L) + 1000L);

		setTitle("Sign Up Page");
		setLayout(null);

		JLabel formno = new JLabel("Application Form No: " + Random);
		formno.setFont(new Font("Times New Roman", Font.BOLD, 35));
		formno.setBounds(200, 20, 500, 40);
		add(formno);

		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Times New Roman", Font.BOLD, 25));
		personalDetails.setBounds(255, 80, 400, 40);
		add(personalDetails);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Times New Roman", Font.BOLD, 22));
		name.setBounds(100, 140, 200, 40);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameTextField.setBounds(300, 145, 400, 30);
		add(nameTextField);

		JLabel fname = new JLabel("Fathers Name:");
		fname.setFont(new Font("Times New Roman", Font.BOLD, 22));
		fname.setBounds(100, 190, 300, 40);
		add(fname);

		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		fnameTextField.setBounds(300, 195, 400, 30);
		add(fnameTextField);

		JLabel dob = new JLabel("DOB:");
		dob.setFont(new Font("Times New Roman", Font.BOLD, 22));
		dob.setBounds(100, 240, 200, 40);
		add(dob);

		dateTextField = new JTextField();
		dateTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateTextField.setBounds(300, 245, 400, 30);
		add(dateTextField);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Times New Roman", Font.BOLD, 22));
		gender.setBounds(100, 290, 200, 40);
		add(gender);

		male = new JRadioButton("Male");
		male.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		male.setBackground(Color.WHITE);
		male.setBounds(300, 290, 100, 40);
		add(male);

		female = new JRadioButton("Female");
		female.setBackground(Color.WHITE);
		female.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		female.setBounds(450, 290, 100, 40);
		add(female);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);

		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Times New Roman", Font.BOLD, 22));
		email.setBounds(100, 340, 200, 40);
		add(email);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		emailTextField.setBounds(300, 345, 400, 30);
		add(emailTextField);

		JLabel status = new JLabel("Martial Status:");
		status.setFont(new Font("Times New Roman", Font.BOLD, 22));
		status.setBounds(100, 390, 200, 40);
		add(status);

		married = new JRadioButton("Married");
		married.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		married.setBackground(Color.WHITE);
		// married.setForeground(Color.WHITE);
		married.setBounds(300, 390, 100, 40);
		add(married);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setBackground(Color.WHITE);
		unmarried.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		unmarried.setBounds(450, 390, 150, 40);
		add(unmarried);

		ButtonGroup martial = new ButtonGroup();
		martial.add(married);
		martial.add(unmarried);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Times New Roman", Font.BOLD, 22));
		address.setBounds(100, 440, 200, 40);
		add(address);

		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		addressTextField.setBounds(300, 445, 400, 30);
		add(addressTextField);

		JLabel city = new JLabel("City:");
		city.setFont(new Font("Times new Roman", Font.BOLD, 22));
		city.setBounds(100, 490, 200, 40);
		add(city);

		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cityTextField.setBounds(300, 495, 400, 30);
		add(cityTextField);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Times new Roman", Font.BOLD, 22));
		state.setBounds(100, 540, 200, 40);
		add(state);

		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		stateTextField.setBounds(300, 545, 400, 30);
		add(stateTextField);

		JLabel pin = new JLabel("Pin Code:");
		pin.setFont(new Font("Times new Roman", Font.BOLD, 22));
		pin.setBounds(100, 590, 200, 40);
		add(pin);

		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pinTextField.setBounds(300, 595, 400, 30);
		add(pinTextField);

		next = new JButton("Next");
		next.setFont(new Font("Times New Roman", Font.BOLD, 22));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(600, 650, 100, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);

		setResizable(false);
		setSize(850, 800);
		setLocation(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String form = "" + Random; // making it string from long
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = dateTextField.getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		}

		String email = emailTextField.getText();
		String martial = null;
		if (married.isSelected()) {
			martial = "Married";
		} else if (unmarried.isSelected()) {
			martial = "Unmarried";
		}

		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();

		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name Required");
			} else {
				Connector c = new Connector();
				String query = "insert into signup values ('" + form + "','" + name + "','" + fname + "','" + dob
						+ "', '" + gender + "','" + email + "', '" + martial + "', '" + address + "', '" + city + "', '"
						+ state + "', '" + pin + "')";
				c.s.executeUpdate(query);

				setVisible(false);
				new SignUp2(form).setVisible(true);
			}
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}

	public static void main(String[] args) {
		new SignUp(" ");
	}
}