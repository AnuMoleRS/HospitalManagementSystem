package com.ty.hospitalapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.hospitalapp.dao.imp.AddressDaoImp;
import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Hospital;

public class AddressService {
	public void saveAddress(int bid, Address address) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address1=addressDaoImp.saveAddress(bid, address);
		if(address1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
	}
	
	public Address getAddressById(int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address1=addressDaoImp.getAddressById(aid);
		if(address1!=null)
		{
		return address1;
	}
		else
		{
			return null;
		}		
	}
	
	public List<Address> getAllAddress(){
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		List<Address> addresses=addressDaoImp.getAllAddress();
		if(addresses!=null)
		{
		return addresses;
	}
		else
		{
			return null;
		}
		
	}
	
	public void deleteAddressById(int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		boolean flag=addressDaoImp.deleteAddressById(aid);
		if(flag)
		{
			System.out.println("Data deleted");
		}
		else
		{
			System.out.println("data not deleted");
		}
		
	}
}