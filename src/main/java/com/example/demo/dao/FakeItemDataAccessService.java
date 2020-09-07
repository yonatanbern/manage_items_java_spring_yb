package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MyRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemsRepository;

@Repository("fakeDao")
public class FakeItemDataAccessService implements ItemDao {

	private static List<Item> DB = new ArrayList<>();

	@Autowired
	ItemsRepository itemsRepository;

	@Override
	public int insertPerson(UUID id, Item item) {
		DB.add(new Item(id, item.getName(), item.getInum(), item.getAmount()));
		itemsRepository.save(item);
		return 1;
	}

	@Override
	public Item selectItemByInum(int inum) {
		int s = DB.size();
		for (int i = 0; i < s; i++) {
			if (DB.get(i).getInum() == inum) {
				return DB.get(i);
			}
		}
		return null;
	}

	@Override
	public String deleteItemByInum(int inum) {
		Item p = selectItemByInum(inum);
		if (p != null) {
			// deleting H2 db
			itemsRepository.deleteAll();
			int s = DB.size();
			for (int i = 0; i < s; i++) {
				if (DB.get(i).getInum() == inum) {
					DB.remove(i);
					// update H2 DB 
					int t = DB.size();
					for (int j = 0; j < t; j++) {
						itemsRepository.save(DB.get(j));
					}
					return "Item removed from DB";
				}
			}

		}
		return "item Not found";
	}

	@Override
	public List<Item> selectAllItems() {
		return DB;
	}

	@Override
	public void changeAmount(int inum, MyRequest req) {

		Item p = selectItemByInum(inum);
		if (p != null) {
			int s = DB.size();
			for (int i = 0; i < s; i++) {
				if (DB.get(i).getInum() == inum) {

					if (req.getReq().equals("sub")) {

						int newAmt = DB.get(i).getAmount() - req.getNum();
						if (newAmt < 0) {
							newAmt = 0;
						}
						DB.get(i).setAmount(newAmt);
							
					} else if (req.getReq().equals("add")) {

						int newAmt = DB.get(i).getAmount() + req.getNum();
						DB.get(i).setAmount(newAmt);
					}
				}
			}
			//update H2 DB 
			itemsRepository.deleteAll();
			int t = DB.size();
			for (int j = 0; j < t; j++) {
				itemsRepository.save(DB.get(j));
			}

		}
	}

}
