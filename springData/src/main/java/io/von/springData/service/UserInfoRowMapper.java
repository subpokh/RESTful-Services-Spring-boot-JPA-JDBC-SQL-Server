package io.von.springData.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.von.springData.model.UserInfo;

public class UserInfoRowMapper implements RowMapper<UserInfo>{

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(rs.getInt("userId"));
		userInfo.setFirstName(rs.getString("firstName"));
		userInfo.setLastName(rs.getString("lastName"));
		userInfo.setUserAdress(rs.getString("userAdress"));
		return userInfo;
	}

}
