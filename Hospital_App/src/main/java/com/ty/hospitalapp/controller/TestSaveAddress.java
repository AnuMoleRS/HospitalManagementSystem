package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.service.AddressService;

public class TestSaveAddress {
public static void main(String[] args) {
	Address address= new Address();
	AddressService addressService= new AddressService();
	address.setCountry("India");
	address.setState("Kerala");
	address.setStreet("Mamangalam");
	address.setPin(68025);
	
	addressService.saveAddress(1, address);
}
}
