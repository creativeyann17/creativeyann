package com.creativeyann.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
    @Size(min=2, max=50)
	@Column(length=50)
	private String subject;
	
	@NotNull
    @Size(min=2, max=50)
	@Column(length=50)
	private String email;
	
	@NotNull
    @Size(min=2, max=1000)
	@Column(length=1000)
	private String content;
	
	@Column(nullable=false)
	private Date date;
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return super.toString();
		}
	}

}
