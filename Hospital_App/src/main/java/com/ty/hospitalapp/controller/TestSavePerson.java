package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.Person;
import com.ty.hospitalapp.service.PersonService;

public class TestSavePerson {
public static void main(String[] args) {
	Person  person= new Person();
	PersonService personService= new PersonService();
	
	person.setName("Anju");
	person.setAddress("Puthen purakkal");
	person.setPhno(9995627604l);
	person.setEmail("anjurajanklm@gmail.com");
	person.setAge(23);
	person.setGender("female");
	person.setDoB("19-04-2000");
//	person.setEncounters(null);
	
	personService.savePerson(1, person);
}
}
