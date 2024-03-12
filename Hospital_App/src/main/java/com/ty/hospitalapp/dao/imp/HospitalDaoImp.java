package com.ty.hospitalapp.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospitalapp.dao.HospitalDao;
import com.ty.hospitalapp.dto.Hospital;

public class HospitalDaoImp implements HospitalDao{

	@Override
	public Hospital saveHospital(Hospital hospital) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return hospital;
	}

	@Override
	public Hospital getHospitalById(int hid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Hospital hospital=entityManager.find(Hospital.class, hid);
		return hospital;
	}

	@Override
	public boolean deleteHospitalById(int hid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, hid);
		if(hospital != null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	
	public Hospital updateHospitalById(int hid,Hospital hospital) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		 Hospital hospital1=entityManager.find(Hospital.class, hid);
		 if(hospital!=null)
		 {
			 hospital1.setName(hospital.getName());
			 hospital1.setWebsite(hospital.getWebsite());
			 entityTransaction.begin();
	 			entityManager.merge(hospital);
	 			entityTransaction.commit();
	 			return null;
	 			
			 }
		 else 
			 return hospital;
	}

	@Override
	public Hospital updateHospitalById(int hid) {
		// TODO Auto-generated method stub
		return null;
	}


}
