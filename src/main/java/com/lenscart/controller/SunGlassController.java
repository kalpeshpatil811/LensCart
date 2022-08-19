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

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.SunGlassIdNotFoundException;
import com.lenscart.exception.InvalidSunGlassDataException;
import com.lenscart.exception.NoSuchSunGlassFoundException;
import com.lenscart.service.ISunGlassService;

/***************************
 * Sun Glasses Controller Class
 *
 * Created By: Kalpesh Patil
 * Date: 09/08/2022
 ***************************/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class SunGlassController {
	@Autowired
	private ISunGlassService sunglassService;

	// GetMapping

	/*
	 * Method: getAllSunGlasses() Description: It allows to get all the Sunglasses.
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

	@GetMapping("sunglass")
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses() {
		return new ResponseEntity<List<SunGlasses>>(sunglassService.getAllSunGlasses(), HttpStatus.OK);
	}

	// GetMapping By I'd

	/*
	 * Method: getSunGlassById(@PathVariable("sunglassId") int sunglassId)
	 * Description: It allows you to get the Sunglass by I'd.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("sunglass/{sunglassId}")
	public ResponseEntity<SunGlasses> getSunGlassById(@PathVariable("sunglassId") int sunglassId)
			throws SunGlassIdNotFoundException {
		return new ResponseEntity<SunGlasses>(sunglassService.getSunGlassById(sunglassId), HttpStatus.OK);
	}

	// PostMapping

	/*
	 * Method: addSunGlass(@Valid @RequestBody SunGlasses sunGlass) Description: It
	 * allows to add the SunGlass.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("sunglass")
	public ResponseEntity<SunGlasses> addSunGlass(@Valid @RequestBody SunGlasses sunGlass)
			throws InvalidSunGlassDataException {
		return new ResponseEntity<SunGlasses>(sunglassService.addSunGlass(sunGlass), HttpStatus.OK);
	}

	// DeleteMapping by I'd

	/*
	 * Method: deleteSunGlass(@PathVariable("sunglassId") int sunglassId)
	 * Description: It allows to remove the Sunglass by I'd.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("sunglass/{sunglassId}")
	public ResponseEntity<List<SunGlasses>> deleteSunGlass(@PathVariable("sunglassId") int sunglassId)
			throws NoSuchSunGlassFoundException {
		List<SunGlasses> sunglassList = sunglassService.deleteSunGlass(sunglassId);
		return new ResponseEntity<List<SunGlasses>>(sunglassList, HttpStatus.OK);
	}

	// Put Mapping

	/*
	 * Method: updateSunGlass(@Valid @RequestBody SunGlasses sunGlass) Description:
	 * It allows to update the Sunglass.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@PutMapping("sunglass")
	public ResponseEntity<SunGlasses> updateSunGlass(@Valid @RequestBody SunGlasses sunGlass)
			throws InvalidSunGlassDataException {
		return new ResponseEntity<SunGlasses>(sunglassService.updateSunGlass(sunGlass), HttpStatus.OK);
	}

}
