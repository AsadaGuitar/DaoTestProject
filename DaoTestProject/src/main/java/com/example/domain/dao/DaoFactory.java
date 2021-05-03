package com.example.domain.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.service.AccountDao;

@Component
public class DaoFactory {

	@Autowired
	AccountDaoImpl accountDaoImpl;
	
	public AccountDao getAccountDao() {
		return accountDaoImpl;
	}
}
