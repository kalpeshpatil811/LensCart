package com.lenscart.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.lenscart.exception.LensIdNotFoundException;
import com.lenscart.exception.NoSuchLensFoundException;
import com.lenscart.exception.InvalidLensDataException;
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
	public ResponseEntity<Lenses> getLensById(@PathVariable("lensId") Integer lensId) throws LensIdNotFoundException {
		return new ResponseEntity<Lenses>(lensService.getLensById(lensId), HttpStatus.OK);
	}

	@PostMapping("/lenses")
	public ResponseEntity<Lenses> addLenses(@Valid @RequestBody Lenses lens) throws InvalidLensDataException {
		lensService.addLens(lens);
		return new ResponseEntity<Lenses>(lens, HttpStatus.OK);
	}
	
	@DeleteMapping("/lenses/{lensId}")
	public ResponseEntity<List<Lenses>> deleteLens(@PathVariable("lensId") Integer lensId) throws NoSuchLensFoundException {
		lensService.deleteLens(lensId);
		return new ResponseEntity<List<Lenses>>(lensService.getAllLenses(), HttpStatus.OK);
	}
	
	@PutMapping("/lenses")
	public ResponseEntity<Lenses> updateLens(@Valid @RequestBody Lenses lens) throws InvalidLensDataException {
		return new ResponseEntity<Lenses>(lensService.updateLens(lens), HttpStatus.OK);
	}
}
	
