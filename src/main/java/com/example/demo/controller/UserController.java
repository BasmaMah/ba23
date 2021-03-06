package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produit;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/save")
	public void save(@RequestBody  Users user){
		userRepository.save(user);
	}
	
	@GetMapping("/all")
	public List<Users> load(){
		return userRepository.findAll();
	}
	
	@DeleteMapping(value = "/delete/{userId}")
	public void delete(@PathVariable(required = true) long id) {
		System.out.println("id = "+id);
		Users user = userRepository.findByUserId(id);
		userRepository.delete(user);
	}
	
	@GetMapping(value = "/count")
	public long countUser() {
		return userRepository.count();
	}

}
