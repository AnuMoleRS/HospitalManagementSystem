package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.AddressDaoImp;
import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dao.imp.MedOrderDaoImp;
import com.ty.hospitalapp.dao.imp.MedOrderDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrderService {
	public void saveMedOrder(int eid, MedOrder medOrder) {
		MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
		MedOrder medorder1=medOrderDaoImp.saveMedOrder(eid, medOrder);
		if(medorder1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
	}
	
public MedOrder getMedOrderById(int mid) {
	MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
	MedOrder medorder1=medOrderDaoImp.getMedOrderById(mid);
	if(medorder1!=null)
	{
	return medorder1;
}
	else
	{
		return null;
	}	
}

public List<MedOrder> getAllMedOrder() {
	MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
	List<MedOrder> medOrders=medOrderDaoImp.getAllMedOrders();
	if(medOrders!=null)
	{
	return medOrders;
}
	else
	{
		return null;
	}
	
}

public void deleteMedOrderById(int mid) {
	MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
	boolean flag=medOrderDaoImp.deleteMedOrderById(mid);
	if(flag)
	{
		System.out.println("Data deleted");
	}
	else
	{
		System.out.println("data not deleted");
	}
}

public MedOrder getMedOrderByDoctorName(String dname) {
	MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
	MedOrder medorder1=medOrderDaoImp.getMedOrdersByDname(dname);
	if(medorder1!=null)
	{
	return medorder1;
}
	else
	{
		return null;
	}	
	
}

public MedOrder getMedOrderByDate(String orderdate) {
	MedOrderDaoImp medOrderDaoImp = new MedOrderDaoImp();
	MedOrder medorder1=medOrderDaoImp.getMedOrdersByDate(orderdate);
	if(medorder1!=null)
	{
	return medorder1;
}
	else
	{
		return null;
	}
}
	
}





