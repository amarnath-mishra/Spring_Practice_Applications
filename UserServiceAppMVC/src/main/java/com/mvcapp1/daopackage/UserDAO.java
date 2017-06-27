package com.mvcapp1.daopackage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.mvcapp1.controllerpackage.UserData;

public interface UserDAO {
 

    public List<UserData> getAllUsers();
 
    public void addUser(UserData employee);
    
    public UserData getUserById(Integer id);
    
    public void removeUserById(Integer id);
    
    	
	
	
}
