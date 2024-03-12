package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.BranchDao;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Hospital;

public class BranchDaoImp implements BranchDao {

	@Override
	public Branch saveBranch(int hid, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital = entityManager.find(Hospital.class, hid);
		if (hospital != null) {
			branch.setHospital(hospital);
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		} else
			return null;

	}

	@Override
	public Branch getBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Branch branch = entityManager.find(Branch.class, bid);
		return branch;
	}
	
	@Override
	public List<Branch> getAllBranch() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select b from Branch b");
		List<Branch> branchs = query.getResultList();
		
//		for (Branch branch : branchs) {
//			
//			System.out.println("The Branch id is " + branch.getBid());
//			System.out.println("The Branch name is " + branch.getName());
//			System.out.println("The Branch Phno is " + branch.getPhno());
//			System.out.println("The Branch email is " + branch.getEmail());
//			System.out.println();
//		}
		return branchs;
	}

	@Override
	public boolean deleteBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.refresh(branch);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	@Override
	public Branch updateBranchById(int bid, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch1 = entityManager.find(Branch.class, bid);
		if (branch1 != null) {
			branch1.setName(branch1.getName());
			branch1.setPhno(branch1.getPhno());
			branch1.setEmail(branch1.getEmail());
			branch1.setAddress(branch1.getAddress());
			return branch1;
		}
		return branch;
	}


}
