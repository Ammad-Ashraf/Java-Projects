package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService 
{

    //fake user list

    List<User> list = List.of(
            new User(1311L, "Daniyal", "23525625"),
            new User(1312L, "Shoaib", "99999"),
            new User(1314L, "Shahzaib", "888")
    );

    @Override
    public User getUser(Long id)
    {
        
    	User foundUser = null;
    	for (User user : list)
    	{
    	    if (user.getUserId().equals(id)) 
    	    {
    	        foundUser = user;
    	        break; //
    	    }
    	}
    	return foundUser;
	
    }
}
