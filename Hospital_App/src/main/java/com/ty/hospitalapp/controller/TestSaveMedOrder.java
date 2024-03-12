package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.MedOrder;
import com.ty.hospitalapp.service.MedOrderService;

public class TestSaveMedOrder {
public static void main(String[] args) {
	MedOrder medOrder= new MedOrder();
	MedOrderService medOrderService= new MedOrderService();

	medOrder.setDname(null);
	medOrder.setOrderDate(null);
	medOrder.setItems(null);
	medOrder.setEncounter(null);
	
	medOrderService.saveMedOrder(1, medOrder);
}
}
