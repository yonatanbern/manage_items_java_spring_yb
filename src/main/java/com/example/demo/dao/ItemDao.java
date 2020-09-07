package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.MyRequest;
import com.example.demo.model.Item;

public interface ItemDao {
	
	int insertPerson(UUID id,Item person);
	
	default int insertPerson(Item person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Item> selectAllItems();
	
	Item selectItemByInum(int inum);
	
	String deleteItemByInum(int inum);
	
	void changeAmount(int inum, MyRequest req);

}
