package com.example.demo.controllers;

import java.util.List;
import javax.sql.DataSource;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.*;

public class UserJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public boolean checkLogin(User user) {
		String SQL = "select * from user where username = ? and password = ?";

		List<User> result = jdbcTemplateObject.query(SQL, new Object[] { user.getUsername(), user.getPassword() },
				new UserMapper());

		if (result.size() > 0)
			return true;
		return false;
	}
}
