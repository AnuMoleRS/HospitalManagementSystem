package com.ty.hospitalapp.dao;

import java.util.List;


import com.ty.hospitalapp.dto.Encounter;

public interface EncounterDao {
	public Encounter saveEncounter(int bid,Encounter encounter);
	public Encounter getEncounterById(int eid);
	public List<Encounter> getAllEncounters();
	public boolean deleteEncounterById(int eid);
//	public Encounter updateEncounterById(int eid);
	Encounter updateEncounterById(int eid, Encounter encounter);
}
