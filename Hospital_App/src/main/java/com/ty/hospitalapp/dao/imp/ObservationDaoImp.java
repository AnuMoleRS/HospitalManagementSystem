package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.ObservationDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.Observation;
import com.ty.hospitalapp.dto.User;

public class ObservationDaoImp implements ObservationDao{

	@Override
	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter =entityManager.find(Encounter.class, eid);
		if(encounter!=null)
		{
		observation.setEncounter(encounter);
		entityTransaction.begin();
		entityManager.persist(observation);
		entityTransaction.commit();
		return observation;
		}
		else
		return null;
	}

	@Override
	public Observation getObservationById(int oid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Observation observation = entityManager.find(Observation.class, oid);
		return observation;
	}

	@Override
	public List<Observation> getAllObservations() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select o from Observation o");
		List<Observation> observations  =query.getResultList();
		
		return observations;
	}

	@Override
	public List<Observation> getObservationsByDname(String dname) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select s from Observation s where s.dname=?1");
		query.setParameter(1, dname);
		List<Observation> observations =query.getResultList();
		
		return observations;
	}

	@Override
	public boolean deleteObservationById(int oid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation =entityManager.find(Observation.class, oid);
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.refresh(observation);
			entityTransaction.commit();
			return true;
		}
		else
		return false;
	}

	@Override
	public Observation updateObservationById(int oid, Observation observation) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation1 = entityManager.find(Observation.class, oid);
		if(observation1!= null) {
			observation1.setDname(observation1.getDname());
			observation1.setrObservation(observation1.getrObservation());
			return observation1;
		}
		return observation;
	}

}
