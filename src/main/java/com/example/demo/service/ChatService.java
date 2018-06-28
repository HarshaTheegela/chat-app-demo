package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Chat;
import com.example.demo.pojos.ChatReqObj;
import com.example.demo.pojos.ChatResOnCreation;
import com.example.demo.pojos.ChatResWithTime;
import com.example.demo.pojos.ChatResWithoutTime;
import com.example.demo.repository.ChatRepository;

@Service
public class ChatService {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	@Autowired
	private ChatRepository chatRepo;

	public List<ChatResWithoutTime> getChatsByUsername(String username) {
		List<Chat> chats = chatRepo.findByUsername(username);
		List<ChatResWithoutTime> lst = chats.stream().filter(c -> {
			long timeCheck = System.currentTimeMillis() - c.getPostTime();
			if (timeCheck < c.getTimeout() * 1000) {
				return true;
			} else {
				return false;
			}

		}).map(c -> new ChatResWithoutTime(c.getUsername(), c.getText())).collect(Collectors.toList());
		return lst;
	}

	
	private String convertTime(long ms) {
		LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(ms), ZoneId.systemDefault());
		String format = time.format(formatter);
		return format.toString();
	}
	
	public ChatResWithTime getChatById(int id) {
		Chat chat = chatRepo.findById(id).get();
		ChatResWithTime chatRes = new ChatResWithTime(chat.getUsername(),chat.getText(), convertTime(chat.getPostTime()));
		return chatRes;
	}

	public ChatResOnCreation postChat(ChatReqObj chatReqObj) {
		Chat chat = new Chat(chatReqObj.getUsername(), chatReqObj.getText(), chatReqObj.getTimeout());
		Chat chatRes = chatRepo.save(chat);
		int id = chatRes.getId();
		return new ChatResOnCreation(id);
	}

}
