package com.example.domain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.dao.AccountDaoImpl;
import com.example.domain.dao.DaoFactory;
import com.example.domain.service.AccountDao;

@Controller
@RequestMapping("hello")
public class WelcomeController {
	
	@Autowired 
	DaoFactory daoFactory;

	@GetMapping
	public String welcome(Model model) {
		AccountDao dao = daoFactory.getAccountDao();
		model.addAttribute(dao.findOne("001"));
		System.out.println(dao.findOne("001").getName());
		System.out.println(dao.findAll().get(0).getName());
		return "hello";
	}
}
