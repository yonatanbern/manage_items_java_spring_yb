package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDao;
import com.example.demo.model.MyRequest;
import com.example.demo.model.Item;

@Service
public class ItemService {

	
	private final ItemDao itemDao;
	
	@Autowired
	public ItemService(@Qualifier("fakeDao")ItemDao personDao) {
		this.itemDao = personDao;
	}
	
	public int addPerson(Item person) {
		return itemDao.insertPerson(person);
		
	}
	
	public List<Item> getAllItems() {
		return itemDao.selectAllItems();
	}
	
	public Item selectItemById(int inum) {
		return itemDao.selectItemByInum(inum);
	}
	
	public String deleteItemByInum(int inum) {
		return itemDao.deleteItemByInum(inum);
	}
	
	public void changeAmount(int inum, MyRequest req) {
		itemDao.changeAmount(inum, req);
	}
}
