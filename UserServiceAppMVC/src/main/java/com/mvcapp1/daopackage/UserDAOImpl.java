package com.mvcapp1.daopackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.mvcapp1.controllerpackage.UserData;

@Component
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
	private EntityManager em;

	public List<UserData> getAllUsers() {
		TypedQuery<UserData> query = em.createQuery(
	            "SELECT g FROM UserData g ORDER BY g.id", UserData.class);
	        return query.getResultList();
	}

	public void addUser(UserData user) {
		 em.persist(user);
		
	}

	public UserData getUserById(Integer id) {
		return em.find(UserData.class, id);
	}

	public void removeUserById(Integer id) {
		UserData temp = getUserById(id);
		em.remove(temp);
		
	}
	
	
	

	
	
}
