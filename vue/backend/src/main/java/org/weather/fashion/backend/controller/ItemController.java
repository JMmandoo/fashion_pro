package org.weather.fashion.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weather.fashion.backend.entity.Item;
import org.weather.fashion.backend.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/api/items")
  public List<Item> getItems(){
List<Item> items = itemRepository.findAll();
    return items;
  }
}
