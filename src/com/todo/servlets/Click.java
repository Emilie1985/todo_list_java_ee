package com.todo.servlets;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Click implements ActionListener {

	public void init() {
		Button b = new Button("boutton");
		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		System.out.println("faaaaaaaaaaaaa");
	};

}
