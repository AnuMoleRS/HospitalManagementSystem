package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Person;

public interface PersonDao {
	public Person savePerson(int eid, Person person);

	public Person getPersonById(int pid);

	public List<Person> getAllPerson();

	public List<Person> getPersonByGender(String gender);

	public List<Person> getPersonByAge(int age);
	
	public Person getPersonByPhno(long phno);

	public boolean deletePersonById(int pid);

	public Person updatePersonById(int pid,Person person);
}
