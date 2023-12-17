package com.bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener {

	JComboBox rel, bCat, quali, money, Ojob;
	JTextField panNo, adharNo;
	JRadioButton yes, no, yes1, no1;
	String form;

	SignUp2(String form) {

		this.form = form;
		setTitle("Sign Up Page");
		setLayout(null);

		JLabel formno = new JLabel("Page 2: Additional Details");
		formno.setFont(new Font("Helvetica", Font.BOLD, 25));
		formno.setBounds(200, 20, 500, 40);
		add(formno);

		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Times New Roman", Font.BOLD, 22));
		religion.setBounds(100, 80, 200, 30);
		add(religion);

		String valReligion[] = { " ", "Hindu", "Christian", "Muslim", "Other" };

		rel = new JComboBox(valReligion);
		rel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rel.setBackground(Color.WHITE);
		rel.setBounds(350, 80, 400, 30);
		add(rel);

		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Times New Roman", Font.BOLD, 22));
		category.setBounds(100, 130, 200, 40);
		add(category);

		String cat[] = { "", "Genereal", "OBC", "SC", "ST", "Other" };
		bCat = new JComboBox(cat);
		bCat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		bCat.setBackground(Color.WHITE);
		bCat.setBounds(350, 130, 400, 30);
		add(bCat);

		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Times New Roman", Font.BOLD, 22));
		income.setBounds(100, 190, 200, 40);
		add(income);

		String sMoney[] = { "", "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000" };
		money = new JComboBox(sMoney);
		money.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		money.setBackground(Color.WHITE);
		money.setBounds(350, 190, 400, 30);
		add(money);

		JLabel education = new JLabel("Educational");
		education.setFont(new Font("Times New Roman", Font.BOLD, 22));
		education.setBounds(100, 240, 200, 40);
		add(education);

		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Times New Roman", Font.BOLD, 22));
		qualification.setBounds(100, 270, 200, 40);
		add(qualification);

		String edu[] = { "", "Non-Graduate", "Graduate", "Post-Grudate", "Doctrate", "Others" };
		quali = new JComboBox(edu);
		quali.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		quali.setBackground(Color.WHITE);
		quali.setBounds(350, 270, 400, 30);
		add(quali);

		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Times New Roman", Font.BOLD, 22));
		occupation.setBounds(100, 320, 200, 40);
		add(occupation);

		String job[] = { "", "Salaried", "Selfemployed", "Business", "Student", "Retired", "Others" };
		Ojob = new JComboBox(job);
		Ojob.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Ojob.setBackground(Color.WHITE);
		Ojob.setBounds(350, 320, 400, 30);
		add(Ojob);

		JLabel pan = new JLabel("PAN Number:");
		pan.setFont(new Font("Times New Roman", Font.BOLD, 22));
		pan.setBounds(100, 370, 200, 40);
		add(pan);

		panNo = new JTextField();
		panNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panNo.setBounds(350, 370, 400, 30);
		add(panNo);

		JLabel adhar = new JLabel("Adhar Number:");
		adhar.setFont(new Font("Times New Roman", Font.BOLD, 22));
		adhar.setBounds(100, 420, 200, 40);
		add(adhar);

		adharNo = new JTextField();
		adharNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		adharNo.setBounds(350, 420, 400, 30);
		add(adharNo);

		JLabel senior = new JLabel("Senior Cirizen:");
		senior.setFont(new Font("Times New Roman", Font.BOLD, 22));
		senior.setBounds(100, 470, 200, 40);
		add(senior);

		yes = new JRadioButton("Yes");
		yes.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		yes.setBounds(350, 470, 100, 30);
		yes.setBackground(Color.WHITE);
		add(yes);

		no = new JRadioButton("No");
		no.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		no.setBounds(550, 470, 100, 30);
		no.setBackground(Color.WHITE);
		add(no);

		ButtonGroup conformation = new ButtonGroup();
		conformation.add(yes);
		conformation.add(no);

		JLabel eAccount = new JLabel("Exisiting Account:");
		eAccount.setFont(new Font("Times New Roman", Font.BOLD, 22));
		eAccount.setBounds(100, 520, 200, 40);
		add(eAccount);

		yes1 = new JRadioButton("Yes");
		yes1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		yes1.setBounds(350, 520, 100, 30);
		yes1.setBackground(Color.WHITE);
		add(yes1);

		no1 = new JRadioButton("No");
		no1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		no1.setBounds(550, 520, 100, 30);
		no1.setBackground(Color.WHITE);
		add(no1);

		ButtonGroup conformation1 = new ButtonGroup();
		conformation1.add(yes1);
		conformation1.add(no1);

		JButton next = new JButton("Next");
		next.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		next.setBounds(600, 570, 100, 30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
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
		String religion = (String) rel.getSelectedItem();
		String catogery = (String) bCat.getSelectedItem();
		String income = (String) money.getSelectedItem();
		String qualification = (String) quali.getSelectedItem();
		String occupation = (String) Ojob.getSelectedItem();
		String senior = (yes.isSelected()) ? "Yes" : "No";
		String account = (yes.isSelected()) ? "yes" : "No";

		String pan = panNo.getText();
		String adhar = adharNo.getText();

		/*
		 * String senior = null; if(yes.isSelected()) { senior = "Yes"; }else
		 * if(no.isSelected()) { senior = "No"; }
		 */

		try {
			Connector c = new Connector();
			String query = "insert into signup2 values ('" + form + "','" + religion + "', '" + catogery + "','"
					+ income + "', '" + qualification + "', '" + occupation + "', '" + senior + "', '" + account
					+ "', '" + pan + "', '" + adhar + "' )";
			c.s.executeUpdate(query);
			setVisible(false);
			new SignUp3(form).setVisible(true);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

	}

	public static void main(String[] args) {
		new SignUp2("");
	}
}
