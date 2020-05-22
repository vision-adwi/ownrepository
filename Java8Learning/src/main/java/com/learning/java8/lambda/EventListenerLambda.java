package com.learning.java8.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventListenerLambda {
	
	public static void main(String[] s) {
		JTextField textField = new JTextField();
		textField.setBounds(50, 50, 150, 20);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(50, 100, 60, 30);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBounds(120, 100, 80, 30);

		okButton.addActionListener(e -> {
			textField.setText("Hello there");
		});

		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});

		JFrame frame = new JFrame();
		frame.add(textField);
		frame.add(okButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
