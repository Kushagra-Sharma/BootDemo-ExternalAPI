package com.user.externalapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.externalapi.entity.Post;
import com.user.externalapi.entity.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/users")
	public List<User> getUser() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		User[] users = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/", User[].class);
		Post[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/", Post[].class);
		
		for(int i=0;i<users.length;i++) {
			if(users[i].getId().equals(posts[i].getId())) {
				users[i].setTitle(posts[i].getTitle());
				users[i].setBody(posts[i].getBody());
			}
		}
		
		List<User> userList = Arrays.asList(users);
		return userList;
	}
}
