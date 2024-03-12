package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.MedOrderDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.MedOrder;
import com.ty.hospitalapp.dto.Person;
import com.ty.hospitalapp.dto.User;

public class MedOrderDaoImp implements MedOrderDao {

	@Override
	public MedOrder saveMedOrder(int eid, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			medOrder.setEncounter(encounter);
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return medOrder;
		} 
		else 
			return null;

	}

	@Override
	public MedOrder getMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		return medOrder;
	}

	@Override
	public List<MedOrder> getAllMedOrders() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select m from MedOrder m");
		List<MedOrder> medOrders = query.getResultList();
		return medOrders;
	}
	

	@Override
	public MedOrder getMedOrdersByDate(String OrderDate) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select m from MedOrder m where m.OrderDate=?1");
		query.setParameter(1, OrderDate);
		List<MedOrder> medOrders =query.getResultList();
		if(medOrders.size()>0) {
			MedOrder medOrder= medOrders.get(0);
		    return medOrder;
		}
		else {
			System.out.println("No data found");
			return null;
		}
	}

	@Override
	public MedOrder getMedOrdersByDname(String dname) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select m from MedOrder m where m.dname=?1");
		query.setParameter(1, dname);
		List<MedOrder> medOrders =query.getResultList();
		if(medOrders.size()>0) {
			MedOrder medOrder= medOrders.get(0);
		    return medOrder;
		}
		else {
			System.out.println("No data found");
			return null;
		}
	}

	@Override
	public boolean deleteMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if (medOrder != null) {
			entityTransaction.begin();
			entityManager.refresh(medOrder);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	@Override
	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		MedOrder medOrder1 = entityManager.find(MedOrder.class, mid);
		if (medOrder1 != null) {
			medOrder1.setDname(medOrder1.getDname());
			medOrder1.setOrderDate(medOrder1.getOrderDate());
			return medOrder1;
		}
		return medOrder;
	}

}
