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

import com.lenscart.entity.Glass;
import com.lenscart.exception.GlassIdNotFoundException;
import com.lenscart.exception.InvalidGlassDataException;
import com.lenscart.exception.NoSuchGlassFoundException;
import com.lenscart.service.IGlassService;

/***************************
 * Glass Controller Class
 *
 * Created By: Disha Kale
 * Date: 09/08/2022
 ***************************/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class GlassController {

	@Autowired
	private IGlassService glassService;

	// GetMapping

	/*
	 * Method: getAllGlass() Description: It allows to get all the Glasses.
	 * 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC
	 * and REST controllers.
	 * 
	 * @RestController: It is used to create RESTful web services using MVC.
	 * 
	 * @Autowired: It enables to inject object dependency implicitly.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@GetMapping("glass")
	public ResponseEntity<List<Glass>> getAllGlass() {
		return new ResponseEntity<List<Glass>>(glassService.getAllGlass(), HttpStatus.OK);
	}

	// GetMapping By I'd

	/*
	 * Method: getGlassById(@PathVariable Integer glassId) Description: It allows
	 * you to get the glass by I'd.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("glass/{glassId}")
	public ResponseEntity<Glass> getGlassById(@PathVariable("glassId") int glassId) throws GlassIdNotFoundException {
		return new ResponseEntity<Glass>(glassService.getGlassById(glassId), HttpStatus.OK);
	}

	// PostMapping

	/*
	 * Method: addGlass(@RequestBody Glass glass) Description: It allows to add the
	 * Glass.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("glass")
	public ResponseEntity<Glass> addGlass(@Valid @RequestBody Glass glass) throws InvalidGlassDataException {
		glassService.addGlass(glass);
		return new ResponseEntity<Glass>(glass, HttpStatus.OK);
	}

	// DeleteMapping

	/*
	 * Method: deleteGlassById(@PathVariable Integer glassId) Description: It allows
	 * to remove the Glass.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("/glass/{glassId}")
	public ResponseEntity<List<Glass>> deleteGlass(@PathVariable("glassId") int glassId)
			throws NoSuchGlassFoundException {
		List<Glass> glassList = glassService.deleteGlass(glassId);
		return new ResponseEntity<List<Glass>>(glassList, HttpStatus.OK);
	}

	// Put Mapping

	/*
	 * Method: updateGlass(@RequestBody Glass glass) Description: It allows to
	 * update the Glass.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@PutMapping("glass")
	public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass) throws InvalidGlassDataException {
		return new ResponseEntity<Glass>(glassService.updateGlass(glass), HttpStatus.OK);
	}

}
