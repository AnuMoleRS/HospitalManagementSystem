package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.service.HospitalService;

public class TestDeleteHospital {
public static void main(String[] args) {
	HospitalService hospitalService= new HospitalService();
	hospitalService.deleteHospitalById(2);
}
}
