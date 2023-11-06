package org.weather.fashion.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.weather.fashion.backend.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
