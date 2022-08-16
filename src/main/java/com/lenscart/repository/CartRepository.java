package com.lenscart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	public List<Cart> findAllByCustomerId(int customerId);
}
