package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dao.imp.ObservationDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.dto.Observation;

public class ObservationService {
	public void saveObservation(int eid, Observation observation) {
	ObservationDaoImp observationDaoImp=new ObservationDaoImp();
	Observation observation1=observationDaoImp.saveObservation(eid, observation);
	if(observation1!=null)
	{
		System.out.println("Data saved");
	}
	else
	{
	System.out.println("Sorry data not saved");
	
	}
}
	
public Observation getObservationById(int oid) {
	ObservationDaoImp observationDaoImp=new ObservationDaoImp();
	Observation observation1=observationDaoImp.getObservationById(oid);
	if(observation1!=null)
	{
	return observation1;
	}
	else
	{
		return null;
	}
}
	
public List<Observation> getAllObservation() {
	ObservationDaoImp observationDaoImp=new ObservationDaoImp();
	List<Observation> observations=observationDaoImp.getAllObservations();
	if(observations!=null)
	{
	return observations;
}
	else
	{
		return null;
	}
}

public void deleteObservationById(int oid) {
	ObservationDaoImp observationDaoImp=new ObservationDaoImp();
	boolean flag=observationDaoImp.deleteObservationById(oid);
	if(flag)
	{
		System.out.println("Data deleted");
	}
	else
	{
		System.out.println("data not deleted");
	}
}

//
//
public Observation getObservationByDoctorName(String dname) {
	ObservationDaoImp observationDaoImp=new ObservationDaoImp();
	List<Observation> observation1=observationDaoImp.getObservationsByDname(dname);
	if(observation1!=null)
	{
	return (Observation)observation1;
	}
	else
	{
		return null;
	}
}
}

