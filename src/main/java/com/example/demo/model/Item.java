package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private final UUID id;
	private final String name;
	private final int inum;
	private int amount;
	
	public Item(@JsonProperty("inventory code") UUID id,@JsonProperty("name") String name, @JsonProperty("item no") int inum, 
			@JsonProperty("amount") int amount) {
		
		this.id = id;
		this.name = name;
		this.inum = inum;
		this.amount = amount;
	}
	
	public Item() {
		this.id = UUID.randomUUID();
		this.name = "";
		this.inum = 0;
		this.amount = 0;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getInum() {
		return inum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
