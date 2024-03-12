package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.AddressDao;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Branch;

public class AddressDaoImp implements AddressDao {

	@Override
	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			address.setBranch(branch);
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		} else
			return null;
	}

	@Override
	public Address getAddressById(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Address address = entityManager.find(Address.class, aid);
		return address;
	}

	@Override
	public boolean deleteAddressById(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address = entityManager.find(Address.class, aid);
		if (address != null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	@Override
	public Address updateAddressById(int aid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address1 = entityManager.find(Address.class, aid);
		if (address1 != null) {
			address1.setStreet(address.getStreet());
			address1.setState(address.getState());
			address1.setCountry(address.getCountry());
			address1.setPin(address.getPin());
			entityTransaction.begin();
			entityManager.merge(address1);
			entityTransaction.commit();
			return address1;
		} else
			return address;
	}

	@Override
	public List<Address> getAllAddress() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select a from Address a");
		List<Address> addresses = query.getResultList();

//		for (Address address : addresses) {
//
//			System.out.println("The Branch id is " + address.getAid());
//			System.out.println("The Branch name is " + address.getStreet());
//			System.out.println("The Branch Phno is " + address.getState());
//			System.out.println("The Branch email is " + address.getCountry());
//			System.out.println("The Branch hospital is " + address.getPin());
//			System.out.println();
//		}
		return addresses;
	}

}
