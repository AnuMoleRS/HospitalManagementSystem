package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.AddressDaoImp;
import com.ty.hospitalapp.dao.imp.EncounterDaoImp;
import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.Hospital;

public class EncounterService {
	public void saveEncounter(int bid, int pid, Encounter encounter) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter1=encounterDaoImp.saveEncounter(bid,encounter);
		if(encounter1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
	}
	
public Encounter getEncounterById(int eid) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter1=encounterDaoImp.getEncounterById(eid);
		if(encounter1!=null)
		{
		return encounter1;
	}
		else
		{
			return null;
		}
		
	}

public List<Encounter> getAllEncounter(){
	EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
	List<Encounter> encounters=encounterDaoImp.getAllEncounters();
	if(encounters!=null)
	{
	return encounters;
}
	else
	{
		return null;
	}
}

public Encounter updateEncounterById(int eid) {
	EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
	Encounter encounter1=encounterDaoImp.getEncounterById(eid);
	if(encounter1!=null)
	{
		return encounter1;
	}
	else
	{
		return null;
	}
}
}
