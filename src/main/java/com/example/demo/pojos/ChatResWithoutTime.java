package com.example.demo.pojos;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ChatResWithoutTime {

	
	private String username;
	private String text;

	public ChatResWithoutTime() {
		// TODO Auto-generated constructor stub
	}

	public ChatResWithoutTime(String username, String text) {
		this.setText(text);
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	
	
}
