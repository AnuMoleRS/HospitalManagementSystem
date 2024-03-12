package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dao.imp.EncounterDaoImp;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.service.EncounterService;

public class TestSaveEncounter {
public static void main(String[] args) {
	Encounter encounter= new Encounter();
	EncounterService encounterService= new EncounterService();

	encounter.setDateofJoin("9-1-2023");
	encounter.setDateofDischarge("12-1-2023");
	encounter.setObservations(null);
	encounter.setPerson(null);
	encounter.setBranch(null);
	
	encounterService.saveEncounter(0, 0, encounter);
}
}
