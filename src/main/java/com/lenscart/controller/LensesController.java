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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.Lenses;
import com.lenscart.exception.LensIdNotFoundException;
import com.lenscart.exception.NoSuchLensFoundException;
import com.lenscart.exception.InvalidLensDataException;
import com.lenscart.service.ILensesService;

/*********
 * Lenses Controller Class
 *
 * Created By: Sachin Phatak
 * Date: 09/08/2022
 *********/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class LensesController {
	@Autowired
	private ILensesService lensService;

	// GetMapping

	/*
	 * Method: getAllLenses() Description: It allows to get all the Lenses.
	 * 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC
	 * and REST controllers.
	 * 
	 * @RestController: It is used to create RESTful web services using MVC.
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 * 
	 * @Autowired: It enables to inject object dependency implicitly.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@GetMapping("/lenses")
	public ResponseEntity<List<Lenses>> getAllLenses() {
		return new ResponseEntity<List<Lenses>>(lensService.getAllLenses(), HttpStatus.OK);
	}

	// GetMapping By Id

	/*
	 * Method: getLensById(@PathVariable int lensId) Description: It allows you to
	 * get the Lens by Id.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("/lenses/{lensId}")
	public ResponseEntity<Lenses> getLensById(@PathVariable("lensId") Integer lensId) throws LensIdNotFoundException {
		return new ResponseEntity<Lenses>(lensService.getLensById(lensId), HttpStatus.OK);
	}

	// PostMapping

	/*
	 * Method: addLens(@RequestBody Lenses lens) Description: It allows to add a
	 * Lens.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("/lenses")
	public ResponseEntity<Lenses> addLenses(@Valid @RequestBody Lenses lens) throws InvalidLensDataException {
		lensService.addLens(lens);
		return new ResponseEntity<Lenses>(lens, HttpStatus.OK);
	}

	// DeleteMapping

	/*
	 * Method: deleteLens(@PathVariable int lensId) Description: It allows to remove
	 * the Lens.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.      
	 */

	@DeleteMapping("/lenses/{lensId}")
	public ResponseEntity<List<Lenses>> deleteLens(@PathVariable("lensId") Integer lensId)
			throws NoSuchLensFoundException {
		lensService.deleteLens(lensId);
		return new ResponseEntity<List<Lenses>>(lensService.getAllLenses(), HttpStatus.OK);
	}

	// Put Mapping

	/*
	 * Method: updateLens(@RequestBody Lenses lenses) Description: It allows to
	 * update the Lens.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@PutMapping("/lenses")
	public ResponseEntity<Lenses> updateLens(@Valid @RequestBody Lenses lens) throws InvalidLensDataException {
		return new ResponseEntity<Lenses>(lensService.updateLens(lens), HttpStatus.OK);
	}
}
