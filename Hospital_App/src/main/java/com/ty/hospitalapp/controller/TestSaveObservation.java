package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.Observation;
import com.ty.hospitalapp.service.ObservationService;

public class TestSaveObservation {
public static void main(String[] args) {
	Observation observation= new Observation();
	ObservationService observationService= new ObservationService();

	observation.setDname("Felsi");
	observation.setrObservation("Fever");
//	observation.setEncounter(null);
	
	observationService.saveObservation(0, observation);
}
}
