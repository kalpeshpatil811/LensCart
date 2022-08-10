package com.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.Lenses;
import com.lenscart.service.ILensesService;

@RestController
@RequestMapping("/lenscart")
public class LensesController {
	@Autowired
	private ILensesService lensService;

	@GetMapping("/lenses")
	public ResponseEntity<List<Lenses>> getAllLenses() {
		return new ResponseEntity<List<Lenses>>(lensService.getAllLenses(), HttpStatus.OK);
	}

	@GetMapping("/lenses/{lensId}")
	public ResponseEntity<Lenses> getLensById(@PathVariable("lensId") Integer lensId) {
		return new ResponseEntity<Lenses>(lensService.getLensById(lensId), HttpStatus.OK);
	}

	@PostMapping("/lenses")
	public ResponseEntity<Lenses> addLenses(@RequestBody Lenses lens) {
		lensService.addLens(lens);
		return new ResponseEntity<Lenses>(lens, HttpStatus.OK);
	}
	
	@DeleteMapping("/lenses/{lensId}")
	public ResponseEntity<Lenses> deleteLens(@PathVariable("lensId") Integer lensId) {
		lensService.deleteLens(lensId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@PutMapping("/lenses")
	public ResponseEntity<Lenses> updateLens(@RequestBody Lenses lens) {
		return new ResponseEntity<Lenses>(lensService.updateLens(lens), HttpStatus.OK);
	}
}
	
