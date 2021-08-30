package com.rest.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.mapper.UserMapper;
import com.rest.web.model.User;

@RestController
public class UserController {
	
	private Map<String, User> userMap;
	private UserMapper mapper;
	
	public UserController(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	/*
	 * //map초기화
	 * 
	 * @PostConstruct public void init() { userMap = new HashMap<String , User>();
	 * userMap.put("1", new User("1","황지산","010-1234-1111","경남 양산시"));
	 * userMap.put("2", new User("2","김사랑","010-1234-2222","부산광역시 서구"));
	 * userMap.put("3", new User("3","무야호","010-1234-3333","경남 창원시")); }
	 */
	
	//Create
	@PostMapping("/user/{id}")
	public void PostUser(@PathVariable("id") String id,
						 @RequestParam("name") String name,
						 @RequestParam("phone") String phone,
						 @RequestParam("address") String address) {
		
		mapper.PostUser(id, name, phone, address);	
	}	
	
	//Read
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") String id) {
		return mapper.getUser(id);
	}
	
	@GetMapping("/user/all")
	public List<User> getUserList() {
		return mapper.getUserList();
	}
	
	//Update
	@PutMapping("/user/{id}")
	public void putUser(@PathVariable("id") String id,
						@RequestParam("name") String name,
						@RequestParam("phone") String phone,
						@RequestParam("address") String address) {
		
		mapper.putUser(id, name, phone, address);
	}
	
	//Delete
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		
		mapper.deleteUser(id);
	}
}
