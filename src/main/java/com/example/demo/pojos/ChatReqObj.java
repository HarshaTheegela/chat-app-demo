package com.example.demo.pojos;

import javax.validation.constraints.NotNull;

public class ChatReqObj {
	
	@NotNull
	private String username;
	@NotNull
	private String text;
    private Integer timeout;
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
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
    
    
}
