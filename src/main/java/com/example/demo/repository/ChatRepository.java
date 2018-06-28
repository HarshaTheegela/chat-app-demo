package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Chat;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Integer>{
	
	 List<Chat> findByUsername(String username);
}
