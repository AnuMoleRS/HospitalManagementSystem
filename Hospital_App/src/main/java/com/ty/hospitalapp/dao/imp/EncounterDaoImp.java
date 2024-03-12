package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.EncounterDao;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Encounter;

public class EncounterDaoImp implements EncounterDao {

	@Override
	public Encounter saveEncounter(int bid, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
            encounter.setBranch(branch);
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		} else
			return null;
	}

	@Override
	public Encounter getEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Encounter encounter = entityManager.find(Encounter.class, eid);
		return encounter;
	}

	@Override
	public List<Encounter> getAllEncounters() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select e from Encounter e");
		List<Encounter> encounters = query.getResultList();

//		for (Encounter encounter : encounters) {
//
//			System.out.println("The Encounter id is " + encounter.getEid());
//			System.out.println("The Encounter date of join is " + encounter.getDateofJoin());
//			System.out.println("The Encounter date of discharge is " + encounter.getDateofDischarge());
//			System.out.println();
//		}
		return encounters;
	}

	@Override
	public boolean deleteEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.refresh(encounter);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	@Override
	public Encounter updateEncounterById(int eid, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter1 = entityManager.find(Encounter.class, eid);
		if (encounter1 != null) {
			encounter1.setDateofJoin(encounter1.getDateofJoin());
			encounter1.setDateofDischarge(encounter1.getDateofDischarge());
			return encounter1;
		}
		return encounter;
	}

}
