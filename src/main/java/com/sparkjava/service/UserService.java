package com.sparkjava.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.sparkjava.models.User;

public class UserService {
	
	public static Map<Object, Object> users = new HashMap<Object, Object>();
    private static final AtomicInteger count = new AtomicInteger(0);
 
    public User findById(String id) {
        return (User) users.get(id);
    }
 
    public User add(String name, String email) {
        int currentId = count.incrementAndGet();
        User user = new User(currentId, name, email);
        users.put(String.valueOf(currentId), user);
        return user;
    }
 
    public void delete(String id) {
        users.remove(id);
    }
 
    public List<Object> findAll() {
        return new ArrayList<Object>(users.values());
    }
 
    public UserService() {
    }

}
