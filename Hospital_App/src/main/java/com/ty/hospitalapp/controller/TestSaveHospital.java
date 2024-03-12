package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.service.HospitalService;

public class TestSaveHospital {
public static void main(String[] args) {
	Hospital hospital= new Hospital();
	HospitalService hospitalService= new HospitalService();
	hospital.setName("EMC");
	hospital.setWebsite("www.emc.com");
	hospitalService.saveHospital(hospital);
}
}
