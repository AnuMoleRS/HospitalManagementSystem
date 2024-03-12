package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.PersonDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.Person;

public class PersonDaoImp implements PersonDao{

	@Override
	public Person savePerson(int eid, Person person) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null)
		{
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
		}
		else
		return null;
	}

	@Override
	public Person getPersonById(int pid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Person person= entityManager.find(Person.class, pid);
		return person;
	}

	@Override
	public List<Person> getAllPerson() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select p from Person p");
		List<Person> persons =query.getResultList();
	
		return persons;
	}

	@Override
	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select p from Person p where p.gender=?1");
		query.setParameter(1, gender);
		List<Person> persons =query.getResultList();
		if(persons.size()>0) {
		    return persons;
		}
		else {
			System.out.println("No data found");
			return null;
		}
	}

	@Override
	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select p from Person p where p.age=?1");
		query.setParameter(1, age);
		List<Person> persons =query.getResultList();
		
		if(persons.size()>0) {
		    return persons;
		}
		else {
			System.out.println("No data found");
			return null;
		}
	}

	@Override
	public Person getPersonByPhno(long phno) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query= entityManager.createQuery("select p from Person p where p.phno=?1");
		query.setParameter(1, phno);
		List<Person> persons =query.getResultList();
		if(persons.size()>0) {
			Person person= persons.get(0);
		    return person;
		}
		else {
			System.out.println("No data found");
			return null;
		}
	}

	@Override
	public boolean deletePersonById(int pid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person =entityManager.find(Person.class, pid);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.refresh(person);
			entityTransaction.commit();
			return true;
		}
		else
		return false;
	}

	@Override
	public Person updatePersonById(int pid, Person person) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person1 = entityManager.find(Person.class, pid);
		if(person1!= null) {
			person1.setName(person1.getName());
			person1.setAddress(person1.getAddress());
			person1.setPhno(person1.getPhno());
			person1.setEmail(person1.getEmail());
			person1.setAge(person1.getAge());
			person1.setAge(person1.getAge());
			person1.setGender(person1.getGender());
			person1.setDoB(person1.getDoB());
			return person1;
		}
		return person;
	}
	
}
