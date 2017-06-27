package com.mvcapp1.daopackage;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mvcapp1.controllerpackage.UserData;

public class UserJDBCTemplate implements UsersDAOInterface {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   public ArrayList<UserData> addUser(UserData u) {
	   
	   int id = u.getId();
	   UserData checkuserifexists =null;
	   try{
	    checkuserifexists = getUser(id);
//	    if(checkuserifexists !=null)
		   {
			   String firstname =u.getFirstName();
			   String lastname = u.getLastName();
		      String SQL = "insert into user (id,firstname, lastname) values (?, ?, ?)";
		      jdbcTemplateObject.update( SQL,id, firstname, lastname);
		      System.out.println("Created Record firstName = " + firstname + " lastname = " + lastname);
		   }
	   }
	   catch(Exception e){
		   System.out.println("trapped here");
		   
			   String firstname =u.getFirstName();
			   String lastname = u.getLastName();
		      String SQL = "insert into user (id,firstname, lastname) values (?, ?, ?)";
		      jdbcTemplateObject.update( SQL,id, firstname, lastname);
		      System.out.println("Created Record firstName = " + firstname + " lastname = " + lastname);
		   
	   }
	   
	  System.out.println("User already exists ");
      return getAll();
   }
   public UserData getUser(Integer id) {
      String SQL = "select * from user where id = ?";
      UserData user = jdbcTemplateObject.queryForObject(SQL, 
         new Object[]{id}, new UserMapper());
      
      return user;
   }
   public ArrayList<UserData> getAll() {
      String SQL = "select * from user";
      List <UserData> users = jdbcTemplateObject.query(SQL, new UserMapper());
      return (ArrayList<UserData>) users;
   }
   public ArrayList<UserData> deleteUser(Integer id) {
      String SQL = "delete from user where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return getAll();
   }
   public List<UserData> editAndUpdateUser(UserData u){
	   deleteUser(u.getId());
	   int id = u.getId();
	   String firstname =u.getFirstName();
	   String lastname = u.getLastName();
      String SQL = "update user set firstname = ?, lastname = ? where id = ?";
      jdbcTemplateObject.update(SQL, firstname,lastname, id);
      System.out.println("Updated Record with ID = " + id );
      return getAll();
   }
   
   public UserData editUser(int id) {
		// TODO Auto-generated method stub
		return getUser(id);
	}
  
}