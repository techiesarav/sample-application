package com.example.redis.sampleapplication.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.redis.sampleapplication.entity.Account;

public class AccountMapper implements RowMapper{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt(1));
		account.setName(rs.getString(2));
		account.setLocation(rs.getString(3));
		return account;
	}
}
