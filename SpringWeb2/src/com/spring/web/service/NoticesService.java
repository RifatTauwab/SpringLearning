package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.NoticesDAO;
import com.spring.web.dao.Notice;

@Service
public class NoticesService {

	private NoticesDAO noticesDAO;

	@Autowired
	public void setNoticesDAO(NoticesDAO noticesDAO) {
		this.noticesDAO = noticesDAO;
	}
	
	public List<Notice> getNotices() {
		return noticesDAO.getNotices();
	}
	
	public void create(Notice notice) {
		noticesDAO.create(notice);
	}
	
	public void testException() {
		noticesDAO.getNotice(55555); //it would throw an exception as no entry found with this id 
	}
}
