package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenscart.entity.Cart;
import com.lenscart.repository.CartRepository;

/***************************
 * Cart Service Class
 *
 * Created By: Kalpesh Patil
 * Date: 10/08/2022
 ***************************/

@Service
@Transactional
public class CartService implements ICartService {

	@Autowired
	CartRepository cartRepo;

	@Override
	public List<Cart> getAllCartItems() {
		return cartRepo.findAll();
	}

	@Override
	public Cart addToCart(Cart cartItem) {
		return cartRepo.save(cartItem);
	}

	@Override
	public List<Cart> removeFromCart(int itemId) {
		cartRepo.deleteById(itemId);
		return cartRepo.findAll();
	}

	@Override
	public String removeAllByCustomerId(int customerId) {
		cartRepo.deleteByCustomerId(customerId);
		return "All Cart Items Deleted Successfully!";
	}

	@Override
	public List<Cart> getAllCartItemsByCustomerId(int customerId) {
		return cartRepo.findAllByCustomerId(customerId);
	}

}
