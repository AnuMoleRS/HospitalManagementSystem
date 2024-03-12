package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dao.imp.PersonDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.dto.Person;

public class PersonService {
	public void savePerson(int eid, Person person) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person1=personDaoImp.savePerson(eid, person);
		if(person1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
	}
	
	public Person getPersonById(int pid) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person1=personDaoImp.getPersonById(pid);
		if(person1!=null)
		{
		return person1;
	}
		else
		{
			return null;
		}
	}

	
public List<Person> getAllPerson() {
	PersonDaoImp personDaoImp=new PersonDaoImp();
	List<Person> persons=personDaoImp.getAllPerson();
	if(persons!=null)
	{
	return persons;
}
	else
	{
		return null;
	}	
}

public void deletePersonById(int pid) {
	PersonDaoImp personDaoImp=new PersonDaoImp();
	boolean flag=personDaoImp.deletePersonById(pid);
	if(flag)
	{
		System.out.println("Data deleted");
	}
	else
	{
		System.out.println("data not deleted");
	}
}
	
public List<Person> getPersonByGender(String gender) {
	PersonDaoImp personDaoImp=new PersonDaoImp();
	Person person1=(Person) personDaoImp.getPersonByGender(gender);
	if(person1!=null)
	{
	return (List<Person>) person1;
}
	else
	{
		return null;
	}
	
}

public List<Person> getPersonByAge(int age) {
	PersonDaoImp personDaoImp=new PersonDaoImp();
	Person person1=(Person) personDaoImp.getPersonByAge(age);
	if(person1!=null)
	{
	return (List<Person>) person1;
}
	else
	{
		return null;
	}
}
	
public Person getPersonByPhone(long phno) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person1=(Person) personDaoImp.getPersonByPhno(phno);
		if(person1!=null)
		{
		return (Person) person1;
	}
		else
		{
			return null;
		}
		
		
	}
	}
