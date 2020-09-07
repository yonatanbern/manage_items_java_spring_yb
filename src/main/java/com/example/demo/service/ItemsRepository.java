package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Item;

public interface ItemsRepository extends CrudRepository<Item, Integer>{}
