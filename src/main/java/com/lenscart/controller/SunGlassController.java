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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lenscart")
public class SunGlassController {
	@Autowired
	private ISunGlassService sunglassService;

	@GetMapping("sunglass")
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses() {
		return new ResponseEntity<List<SunGlasses>>(sunglassService.getAllSunGlasses(), HttpStatus.OK);
	}

	@GetMapping("sunglass/{sunglassId}")
	public ResponseEntity<SunGlasses> getSunGlassById(@PathVariable("sunglassId") int sunglassId)
			throws SunGlassIdNotFoundException {
		return new ResponseEntity<SunGlasses>(sunglassService.getSunGlassById(sunglassId), HttpStatus.OK);
	}

	@PostMapping("sunglass")
	public ResponseEntity<SunGlasses> addSunGlass(@Valid @RequestBody SunGlasses sunGlass)
			throws InvalidSunGlassDataException {
		return new ResponseEntity<SunGlasses>(sunglassService.addSunGlass(sunGlass), HttpStatus.OK);
	}

	@DeleteMapping("sunglass/{sunglassId}")
	public ResponseEntity<List<SunGlasses>> deleteSunGlass(@PathVariable("sunglassId") int sunglassId)
			throws NoSuchSunGlassFoundException {
		List<SunGlasses> sunglassList = sunglassService.deleteSunGlass(sunglassId);
		return new ResponseEntity<List<SunGlasses>>(sunglassList, HttpStatus.OK);
	}

	@PutMapping("sunglass")
	public ResponseEntity<SunGlasses> updateSunGlass(@Valid @RequestBody SunGlasses sunGlass)
			throws InvalidSunGlassDataException {
		return new ResponseEntity<SunGlasses>(sunglassService.updateSunGlass(sunGlass), HttpStatus.OK);
	}

}
