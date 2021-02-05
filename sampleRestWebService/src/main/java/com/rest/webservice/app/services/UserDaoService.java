package com.rest.webservice.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.webservice.app.entities.User;

@Service
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3;
	
	static {
		User user1 = new User(1, "Gowtham", new Date());
		users.add(user1);
		
		User user2 = new User(2, "Jack", new Date());
		users.add(user2);
		
		User user3 = new User(3, "Shankar", new Date());
		users.add(user3);
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}

}
