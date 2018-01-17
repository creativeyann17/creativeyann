package com.creativeyann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creativeyann.model.Message;
import com.creativeyann.repositories.MessageDAO;

@Service
public class MessageService {
	
	@Autowired
	private MessageDAO messageDAO;
	
	public void save(Message message) {
		messageDAO.save(message);
	}

	public List<Message> findAll() {
		return messageDAO.findAll();
	}

}
