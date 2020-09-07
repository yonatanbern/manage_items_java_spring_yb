package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RequestMapping("api/v1/person")
@RestController
public class ItemController {
	
	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public void addPerson(@RequestBody Item item) {
		itemService.addPerson(item);
	}
	
	@GetMapping
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping(path = "{item no}")
	public Item getItemByInum(@PathVariable("item no")int inum) {
		return itemService.selectItemById(inum);
	}
	
	@DeleteMapping(path = "{item no}")
	public String deleteItemByInum(@PathVariable("item no") int inum) {
		return itemService.deleteItemByInum(inum);
	}
	
	@PostMapping(path = "{item no}")
	public void changeAmount(@PathVariable("item no")int inum, @RequestBody MyRequest req) {
		itemService.changeAmount(inum, req);
	}

}
