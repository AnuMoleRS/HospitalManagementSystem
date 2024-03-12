package com.ty.hospitalapp.dao;

import java.util.List;


import com.ty.hospitalapp.dto.MedOrder;

public interface MedOrderDao {
	public MedOrder saveMedOrder(int eid, MedOrder medOrder);

	public MedOrder getMedOrderById(int mid);
	
	public List<MedOrder> getAllMedOrders();
	
	public MedOrder getMedOrdersByDate(String OrderDate);
	
	public MedOrder getMedOrdersByDname(String dname);

	public boolean deleteMedOrderById(int mid);

	public MedOrder updateMedOrderById(int mid,MedOrder medOrder); 
	
}
