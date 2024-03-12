package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.service.HospitalService;

public class TestUpdateHospital {
public static void main(String[] args) {
	HospitalService  hospitalService= new HospitalService();
	Hospital hospital= new Hospital();
	hospital.setName("wxxashy");;
	hospitalService.updateHospitalById(4, hospital);
}
}
