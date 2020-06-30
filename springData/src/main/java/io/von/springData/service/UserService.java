package io.von.springData.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import io.von.springData.model.User;
import io.von.springData.model.UserInfo;
import io.von.springData.repository.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepository;
		@Autowired
		private JdbcTemplate jdbcTemplate;
		//private static final Logger log = LoggerFactory.getLogger(UserService.class);
		
	    public UserInfo getUserInfo(int userId) {
	    	//log.info("Querying for UserInfo records where userId = '?' :");
	    	return jdbcTemplate.queryForObject("SELECT * FROM UserInfo WHERE userId =?",new Object[] {userId},new UserInfoRowMapper());	    			
	    }
	    
	    public List<UserInfo> findAllUserInfo(){
	    	List<UserInfo> userInfos = jdbcTemplate.query("SELECT * FROM UserInfo",new UserInfoRowMapper());
	    	return userInfos;	    	
	    }


		public List<User> getAll() {
			List<User> users = new ArrayList<>();
			userRepository.findAll().forEach(users::add);
			return users;					
		}
		
		public User addUser(User user) {
			return userRepository.save(user);
		}
		
		public void deleteUser(User user) {
			userRepository.delete(user);;
		}

		public Optional<User> getUser(int userId) {
			return userRepository.findById(userId);
		}

		public User updateUser(User user, int userId) {			
			User updatedUser = new User();
			if(getUser(userId)!= null) {
				updatedUser.setUserId(user.getUserId());
				updatedUser.setUserName(user.getUserName());
				updatedUser.setUserPassword(user.getUserPassword());
				return updatedUser;
			}else {
				return null;
			}			
		}

		
}
