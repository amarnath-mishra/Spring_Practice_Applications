package com.mvcapp1.daopackage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;

import com.mvcapp1.controllerpackage.UserData;

@Controller
public class UserDAOImplentation implements UsersDAOInterface{
	@PersistenceContext
	EntityManager em;

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<UserData> addUser(UserData user) {
		em.persist(user);
		return getAll();
	}

	public UserData getUser(Integer id) {
		return em.find(UserData.class, id);
	}

	public ArrayList<UserData> getAll() {
		TypedQuery<UserData> query = em.createQuery(
	            "SELECT g FROM UserData g ORDER BY g.id", UserData.class);
	        return (ArrayList<UserData>) query.getResultList();
	}

	public ArrayList deleteUser(Integer id) {
		UserData temp = getUser(id);
		em.remove(temp);
		return getAll();
	}

	public List<UserData> editAndUpdateUser(UserData u) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserData editUser(int id) {
		return em.find(UserData.class, id);
	}

}
