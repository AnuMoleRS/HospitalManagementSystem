package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.ItemDao;
import com.ty.hospitalapp.dto.Item;
import com.ty.hospitalapp.dto.MedOrder;

public class ItemDaoImp implements ItemDao{

	@Override
	public Item saveItem(int mid, Item item) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedOrder medOrder =entityManager.find(MedOrder.class, mid);
		if(medOrder!=null)
		{
			item.setMedOrder(medOrder);
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
			return item;
		}
		else
		return null;
		
	}

	@Override
	public Item getItemById(int iId) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Item item = entityManager.find(Item.class, iId);
		return item;
	}

	@Override
	public List<Item> getAllItems() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select i from Item i");
		List<Item> items =query.getResultList();
		
		return items;
	}

	@Override
	public boolean deleteItemById(int iId) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Item item =entityManager.find(Item.class, iId);
		if(item!=null) {
			entityTransaction.begin();
			entityManager.refresh(item);
			entityTransaction.commit();
			return true;
		}
		else
		return false;
	}

	@Override
	public Item updateItemById(int iId, Item item) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Item item1 = entityManager.find(Item.class, iId);
		if(item1!= null) {
			item1.setName(item1.getName());
			item1.setCost(item1.getCost());
			item1.setQuantity(item1.getQuantity());
			return item1;
		}
		return item;
	}
	

}
