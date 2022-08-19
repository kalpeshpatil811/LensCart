package com.lenscart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Cart;

/***************************
 * Cart Repository Class
 *
 * Created By: Kalpesh Patil
 * Date: 09/08/2022
 ***************************/

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findAllByCustomerId(int customerId);

	public void deleteByCustomerId(int customerId);
}
