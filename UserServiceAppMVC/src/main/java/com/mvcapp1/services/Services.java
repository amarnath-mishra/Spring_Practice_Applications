package com.mvcapp1.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mvcapp1.controllerpackage.UserData;
import com.mvcapp1.daopackage.UserDAO;
import com.mvcapp1.daopackage.UserDAOImplentation;
import com.mvcapp1.daopackage.UserJDBCTemplate;

@Controller
@Transactional
public class Services {
	
//	@Autowired
//    public UserJDBCTemplate ud;
	
	@Autowired
	public UserDAOImplentation ud;
	//public UserDAO ud ;
	
	public void setUd(UserDAOImplentation ud) {
		this.ud = ud;
	}

	public ArrayList<UserData> addUser(UserData user)
	{
		
	return (ArrayList) ud.addUser(user);	
	}
	
	public ArrayList<UserData> showUser()
	{
		return (ArrayList) ud.getAll();
	}

	public ArrayList updateUser(UserData user) {
		
		return  (ArrayList) ud.editAndUpdateUser(user);
	}

	public UserData editUser(int id) {
		
		return ud.editUser(id);
	//	return ud.editAndUpdateUser(id);
	}

	public ArrayList<UserData> delUser(int id) {

		return (ArrayList)ud.deleteUser(id);
	}

	 public void upload(List<UserData> users) {
		 int count =0;
	        for(UserData user: users) {
	        	addUser(user);
	        	count++;
	        	if(count ==2)
	        		throw new RuntimeException("Got new Exception while uploading");
	        
	        }
	    }

	
}
