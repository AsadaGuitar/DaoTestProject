package com.example.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.domain.Account;
import com.example.domain.service.AccountDao;

@Component
public class AccountDaoImpl implements AccountDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
	
	@Override
	public Account findOne(String id) {
		var sql = "select * from account where id = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Account> findAll() {
		var sql = "select * from account";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int create(Account account) {
		var sql = "insert into account(id, name, age, gender) values(?, ?, ?, ?);";
		return jdbcTemplate.update(sql, account.getId(), account.getName(),
				account.getAge(), account.getGender());
	}

	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
