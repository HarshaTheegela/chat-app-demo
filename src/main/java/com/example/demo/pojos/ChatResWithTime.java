package com.example.demo.pojos;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ChatResWithTime {

	private String username;
	private String text;
	private String expiration_date;

	public ChatResWithTime() {
		// TODO Auto-generated constructor stub
	}

	public ChatResWithTime(String username, String text, String time) {
		
		this.setExpiration_date(time.toString());
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

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

}
