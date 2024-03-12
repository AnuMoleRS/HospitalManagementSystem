package com.ty.hospitalapp.dao;

import java.util.List;


import com.ty.hospitalapp.dto.Item;

public interface ItemDao {

	public Item saveItem(int mid,Item item);
	public Item getItemById(int iId);
	public List<Item> getAllItems();
	public boolean deleteItemById(int iId);
	public Item updateItemById(int iId,Item item);
}
