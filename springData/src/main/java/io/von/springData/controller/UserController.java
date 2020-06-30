package io.von.springData.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.von.springData.model.User;
import io.von.springData.model.UserInfo;
//import io.von.springData.model.UserInfo;
import io.von.springData.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	

	@Autowired
	private UserService userService;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
    
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		log.info("Getting all users");
		return userService.getAll();
	}
	
	@PostMapping("/allUsers")
	public User addUser(@RequestBody User user) {
		log.info("Adding a user");
		return userService.addUser(user);
	}
	
	@DeleteMapping("/allUsers/{userId}")
	public void deleteUser(@RequestBody User user, @PathVariable("userId")int userId) {
		log.info("Deleting a user");
		userService.deleteUser(user);
	}
	
	@GetMapping("/allUsers/{userId}")
	public Optional<User> getUser(@PathVariable("userId")int userId) {
		log.info("Getting a user by user ID");
		return userService.getUser(userId);
	}
	
	@PutMapping("/allUsers/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable("userId")int userId){
		return userService.updateUser(user,userId);
	}
	
	@GetMapping("/allUserInfo")
	public List<UserInfo> getAllUserInfo(){
		log.info("Getting all user infos");
		return userService.findAllUserInfo();
	}
	
	@GetMapping("/allUserInfo/{userId}")
	public UserInfo getUserInfo(@PathVariable("userId")int userId) {
		log.info("Getting a user info by user ID");
		return userService.getUserInfo(userId);
	}
}
