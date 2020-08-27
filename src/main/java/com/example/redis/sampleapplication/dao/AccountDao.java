package com.example.redis.sampleapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.redis.sampleapplication.entity.Account;
import com.example.redis.sampleapplication.mapper.AccountMapper;

@Repository
public class AccountDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<Account> getAll(){
		return jdbcTemplate.query("select * from account",
				new RowMapper<Account>(){

					@Override
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						Account account = new Account();
						account.setId(rs.getInt(1));
						account.setName(rs.getString(2));
						account.setLocation(rs.getString(3));
						return account;
					}});
	}
	
	public Account getAccount(int id) {
		SqlParameterSource parameter = new MapSqlParameterSource().addValue("id", 
				id);
		return (Account) namedParameterJdbcTemplate.queryForObject(
				"select * from account where id =:id", parameter, new AccountMapper());
	}
	
	
	public void updateAccount(Account account) {
		SqlParameterSource parameter = new MapSqlParameterSource()
				.addValue("name", account.getName())
				.addValue("location", account.getLocation())
				.addValue("id",account.getId());
		namedParameterJdbcTemplate.update(
				"update account set name = :name, location = :location where id = :id"
				,parameter);
	}
	
	public void deleteAccount(int id) {
		SqlParameterSource parameter = new MapSqlParameterSource().addValue("id", 
				id);
		namedParameterJdbcTemplate.update(
				"delete from account"
				+ " where id=:id", parameter);
	}
}
