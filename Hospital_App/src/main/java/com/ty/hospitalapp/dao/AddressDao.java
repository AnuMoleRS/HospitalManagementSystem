package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Address;

public interface AddressDao {
	public Address saveAddress(int bid, Address address);

	public Address getAddressById(int aid);

	public boolean deleteAddressById(int aid);

//	public Address updateAddressById(int aid);

	public Address updateAddressById(int aid, Address address);
	
	public List<Address> getAllAddress();
}
