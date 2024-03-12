package com.ty.hospitalapp.dao;

import java.util.List;


import com.ty.hospitalapp.dto.Observation;

public interface ObservationDao {
	public Observation saveObservation(int eid, Observation observation);

	public Observation getObservationById(int oid);
	
	public List<Observation> getAllObservations();
	
	public List<Observation> getObservationsByDname(String dname);

	public boolean deleteObservationById(int oid);

	public Observation updateObservationById(int oid,Observation observation);

}
