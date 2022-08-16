package com.lenscart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.Cart;
import com.lenscart.service.ICartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class CartController {
	@Autowired
	private ICartService cartService;

	@GetMapping("cart")
	public ResponseEntity<List<Cart>> getAllCartItems() {
		return new ResponseEntity<List<Cart>>(cartService.getAllCartItems(), HttpStatus.OK);
	}

	@PostMapping("cart")
	public ResponseEntity<Cart> addToCart(@Valid @RequestBody Cart cartItem) {
		return new ResponseEntity<Cart>(cartService.addToCart(cartItem), HttpStatus.OK);
	}

	@DeleteMapping("cart/{itemId}")
	public ResponseEntity<List<Cart>> removeFromCart(@PathVariable("itemId") int itemId) {
		List<Cart> cartList = cartService.removeFromCart(itemId);
		return new ResponseEntity<List<Cart>>(cartList, HttpStatus.OK);
	}

	@DeleteMapping("cart/c/{customerId}")
	public ResponseEntity<String> removeAllByCustomerId(@PathVariable("customerId") int customerId) {
		String response = cartService.removeAllByCustomerId(customerId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("cart/{customerId}")
	public ResponseEntity<List<Cart>> getAllCartItemsByCustomerId(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<List<Cart>>(cartService.getAllCartItemsByCustomerId(customerId), HttpStatus.OK);
	}
}
