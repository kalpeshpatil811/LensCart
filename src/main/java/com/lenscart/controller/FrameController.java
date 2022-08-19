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
import com.lenscart.entity.Frames;
import com.lenscart.exception.FrameIdNotFoundException;
import com.lenscart.exception.InvalidFrameDataException;
import com.lenscart.exception.NoSuchFrameFoundException;
import com.lenscart.service.IFrameService;

/***************************
 * Frame Controller Class
 *
 * Created By: Laxman Adkune
 * Date: 09/08/2022
 ***************************/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class FrameController {

	@Autowired
	private IFrameService frameService;

	// PostMapping

	/*
	 * Method: addFrame(@Valid @RequestBody Frames frame) Description: It allows to
	 * add the Frames.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 * 
	 * @Valid annotation for method level validation. We also use it to mark a
	 * member attribute for validation
	 */

	@PostMapping("frame")
	public ResponseEntity<Frames> addFrame(@Valid @RequestBody Frames frame) throws InvalidFrameDataException {
		return new ResponseEntity<Frames>(frameService.addFrame(frame), HttpStatus.OK);
	}

	// GetMapping

	/*
	 * Method: getAllFrames() Description: It allows to get all the Frames.
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

	@GetMapping("frame")
	public ResponseEntity<List<Frames>> getAllFrames() {
		return new ResponseEntity<List<Frames>>(frameService.getAllFrames(), HttpStatus.OK);
	}

	// GetMapping By I'd

	/*
	 * Method: getFrameById(@PathVariable("frameId") int frameId) Description: It
	 * allows you to get the frame by I'd.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("frame/{frameId}")
	public ResponseEntity<Frames> getFrameById(@PathVariable("frameId") int frameId) throws FrameIdNotFoundException {
		return new ResponseEntity<Frames>(frameService.getFrameById(frameId), HttpStatus.OK);
	}

	// DeleteMapping by I'd

	/*
	 * Method: deleteFrame(@PathVariable("frameId") int frameId) Description: It
	 * allows to remove the frame y I'd.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("frame/{frameId}")
	public ResponseEntity<List<Frames>> deleteFrame(@PathVariable("frameId") int frameId)
			throws NoSuchFrameFoundException {
		List<Frames> framelist = frameService.deleteFrame(frameId);
		return new ResponseEntity<List<Frames>>(framelist, HttpStatus.OK);
	}

	// Put Mapping

	/*
	 * Method: updateFrame(@Valid @RequestBody Frames frame) Description: It allows
	 * to update the Frames.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @Valid annotation for method level validation. We also use it to mark a
	 * member attribute for validation
	 */

	@PutMapping("frame")
	public ResponseEntity<Frames> updateFrame(@Valid @RequestBody Frames frame) throws InvalidFrameDataException {
		return new ResponseEntity<Frames>(frameService.updateFrame(frame), HttpStatus.OK);
	}

}
