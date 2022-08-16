package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Cart;
import com.lenscart.repository.CartRepository;

@Service
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
	public List<Cart> getAllCartItemsByCustomerId(int customerId) {
		return cartRepo.findAllByCustomerId(customerId);
	}

}
