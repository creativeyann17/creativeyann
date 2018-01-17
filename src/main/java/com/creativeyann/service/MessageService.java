package com.creativeyann.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creativeyann.model.Message;
import com.creativeyann.repositories.MessageDAO;

@Service
public class MessageService {
	
	@Autowired
	private MessageDAO messageDAO;
	
	public void save(Message message) {
		message.setDate(new Date());
		messageDAO.save(message);
	}

	public List<Message> findAll() {
		return messageDAO.findAll();
	}

	@Transactional
	public void deleteAll(List<Long> ids) {
		messageDAO.deleteAll(ids);
	}

}
