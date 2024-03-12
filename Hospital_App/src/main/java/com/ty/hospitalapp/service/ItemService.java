package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.AddressDaoImp;
import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dao.imp.ItemDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.dto.Item;

public class ItemService {
	public void saveItem(int mid, Item item) {
		ItemDaoImp itemDaoImp=new  ItemDaoImp();
		Item item1=itemDaoImp.saveItem(mid, item);
		if(item1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
	}
	
public Item getItemById(int iId) {
	ItemDaoImp itemDaoImp=new  ItemDaoImp();
	Item item1=itemDaoImp.getItemById(iId);
	if(item1!=null)
	{
	return item1;
}
	else
	{
		return null;
	}
	
}

public List<Item> getAllItems() {
	ItemDaoImp itemDaoImp=new  ItemDaoImp();
	List<Item> items=itemDaoImp.getAllItems();
	if(items!=null)
	{
	return items;
}
	else
	{
		return null;
	}
}

public void deleteItemById(int iId) {
	ItemDaoImp itemDaoImp=new  ItemDaoImp();
	boolean flag=itemDaoImp.deleteItemById(iId);
	if(flag)
	{
		System.out.println("Data deleted");
	}
	else
	{
		System.out.println("data not deleted");
	}
}

public Item updateItemById(int iId) {
	ItemDaoImp itemDaoImp=new  ItemDaoImp();
	Item item1=itemDaoImp.getItemById(iId);
	if(item1!=null)
	{
		return item1;
	}
	else
	{
		return null;
	}
}
}
