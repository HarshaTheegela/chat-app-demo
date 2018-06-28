package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.ChatReqObj;
import com.example.demo.pojos.ChatResOnCreation;
import com.example.demo.pojos.ChatResWithTime;
import com.example.demo.pojos.ChatResWithoutTime;
import com.example.demo.service.ChatService;

@RestController
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/chat/{id}")
	public @ResponseBody ChatResWithTime getChatById(@PathVariable("id") Integer id) {
		return chatService.getChatById(id);
	}
	
	@GetMapping("/chats/{username}")
	public @ResponseBody List<ChatResWithoutTime> getChatsByUsername(@PathVariable("username") String username) {
		return chatService.getChatsByUsername(username);
	}
	
	@PostMapping("/chat")
	public  @ResponseBody ResponseEntity<ChatResOnCreation> postChat(@Valid @RequestBody ChatReqObj chatReqObj) {
		ChatResOnCreation chat = chatService.postChat(chatReqObj);
		return new ResponseEntity<ChatResOnCreation>(chat, HttpStatus.CREATED);
		 
	}
	

}
