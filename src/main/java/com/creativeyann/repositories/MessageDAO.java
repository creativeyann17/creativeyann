package com.creativeyann.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creativeyann.model.Message;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long> {
	
	@Modifying
	@Query("DELETE FROM Message WHERE id IN (:ids)")
	public void deleteAll(@Param("ids") List<Long> ids);

}
