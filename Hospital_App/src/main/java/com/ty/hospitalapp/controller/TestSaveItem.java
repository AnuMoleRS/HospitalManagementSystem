package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dao.imp.ItemDaoImp;
import com.ty.hospitalapp.dto.Item;
import com.ty.hospitalapp.service.ItemService;

public class TestSaveItem {
	public static void main(String[] args) {
		Item item = new Item();
		ItemService itemService = new ItemService();

		item.setName("Dolo");
		item.setCost(25);
		item.setQuantity(10);
//		item.setMedOrder();
		
		itemService.saveItem(1, item);
	}
}
