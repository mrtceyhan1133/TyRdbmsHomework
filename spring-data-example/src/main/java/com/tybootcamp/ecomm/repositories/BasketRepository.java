package com.tybootcamp.ecomm.repositories;

import com.tybootcamp.ecomm.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
    List<Basket> FindAllByName(String Name);
}
