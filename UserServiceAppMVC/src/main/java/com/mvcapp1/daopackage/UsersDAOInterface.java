package com.mvcapp1.daopackage;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.mvcapp1.controllerpackage.UserData;

public interface UsersDAOInterface {
   /** 
      * This is the method to be used to initialize
      * database resources ie. connection.
   */
   public void setDataSource(DataSource ds);
   
   /** 
      * This is the method to be used to create
      * a record in the User table.
   */
   public ArrayList<UserData> addUser(UserData user);
   
   /** 
      * This is the method to be used to list down
      * a record from the User table corresponding
      * to a passed User id.
   */
   public UserData getUser(Integer id);
   
   /** 
      * This is the method to be used to list down
      * all the records from the User table.
   */
   public ArrayList<UserData> getAll();
   
   /** 
      * This is the method to be used to delete
      * a record from the User table corresponding
      * to a passed User id.
   */
   public ArrayList deleteUser(Integer id);
   
   /** 
      * This is the method to be used to update
      * a record into the User table.
   */
   public List<UserData> editAndUpdateUser(UserData u);
}