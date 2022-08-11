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
import com.lenscart.entity.Frames;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.service.IFrameService;

@RestController
@RequestMapping("/lenscart")
public class FrameController {
	
	@Autowired
	private IFrameService frameService;
	
	
	//add new frame
	@PostMapping("frame")
	public ResponseEntity<Frames> addFrame(@Valid @RequestBody Frames frame) 
			throws InvalidProductDataException{
		return new ResponseEntity<Frames>(frameService.addFrame(frame), HttpStatus.OK);
	}
	
	//get all frame details
	@GetMapping("frame")
	public ResponseEntity<List<Frames>> getAllFrames() {
		return new ResponseEntity<List<Frames>>(frameService.getAllFrames(), HttpStatus.OK);
	}
	
	
	//get frame details by ID
	@GetMapping("frame/{frameId}")
	public ResponseEntity<Frames> getFrameById(@PathVariable("frameId") int frameId)
			throws IdNotFoundException {
		return new ResponseEntity<Frames>(frameService.getFrameById(frameId), HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("frame/{frameId}")
	public ResponseEntity<List<Frames>> deleteFrame(@PathVariable("frameId") int frameId)
			throws NoSuchProductFoundException{
		List<Frames> framelist = frameService.deleteFrame(frameId);
		return new ResponseEntity<List<Frames>> (framelist,HttpStatus.OK);
	}
	
	//Update frame details
	@PutMapping("frame")
	public ResponseEntity<Frames> updateFrame(@Valid @RequestBody Frames frame)
			throws InvalidProductDataException{
		return new ResponseEntity<Frames> (frameService.updateFrame(frame),HttpStatus.OK);
	}
	
}
