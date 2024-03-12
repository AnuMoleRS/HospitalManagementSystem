package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.UserDao;
import com.ty.hospitalapp.dto.User;

public class UserDaoImp implements UserDao{

	@Override
	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public User getUserById(int uid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		User user= entityManager.find(User.class, uid);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select u from User u");
		List<User> users =query.getResultList();
		
		return users;
	}

	@Override
	public boolean deleteUserById(int uid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user=entityManager.find(User.class, uid);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else
		return false;
	}

	@Override
	public User updateUserById(int uid, User user) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user1 = entityManager.find(User.class, uid);
		if(user1!= null) {
			user1.setName(user1.getName());
			user1.setPhno(user1.getPhno());
			user1.setEmail(user1.getEmail());
			user1.setPassword(user1.getPassword());
			user1.setRole(user1.getRole());
			return user1;
		}
		return user;
	}

	@Override
	public User getUserByName(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select s from User s where s.name=?1");
		query.setParameter(1,name);
		List<User> users =query.getResultList();
		if(users.size()>0) {
			User user= users.get(0);
		    return user;
		}
		else {
			System.out.println("No data found");
			return null;
		}
	}

	@Override
	public User getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select s from User s where s.role=?1");
		query.setParameter(1, role);
		List<User> users =query.getResultList();
		if(users.size()>0) {
			User user= users.get(0);
		    return user;
		}
		else {
			System.out.println("No data found");
			return null;
		}
		
	}

}
