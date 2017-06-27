package com.mvcapp1.controllerpackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table (name = "user")
public class UserData {
   
	 @Range(min = 20,max =10000)
	 @Id
	  @Column (name = "id")
	   private Integer id;
	 
	  @Column (name = "firstname")
	  private String firstName;
	  
	  @NotEmpty  
	  @Column (name = "lastname")
	   private String lastName;
	   
	   
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	 	  
}
