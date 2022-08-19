package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.SunGlassIdNotFoundException;
import com.lenscart.exception.InvalidSunGlassDataException;
import com.lenscart.exception.NoSuchSunGlassFoundException;
import com.lenscart.repository.SunGlassRepository;

/***************************
 * Sun Glasses Service Class
 *
 * Created By: Kalpesh Patil
 * Date: 10/08/2022
 ***************************/

@Service
public class SunGlassService implements ISunGlassService {

	@Autowired
	private SunGlassRepository sunGlassRepo;

	@Override
	public SunGlasses addSunGlass(SunGlasses sunGlass) throws InvalidSunGlassDataException {
		if (sunGlass.getPrice() <= 0) {
			throw new InvalidSunGlassDataException("Product price should be greater than 0");
		}
		if (sunGlass.getWeight() <= 0) {
			throw new InvalidSunGlassDataException("Product weight should be greater than 0");
		}
		return sunGlassRepo.save(sunGlass);
	}

	@Override
	public List<SunGlasses> getAllSunGlasses() {
		return sunGlassRepo.findAll();
	}

	@Override
	public SunGlasses getSunGlassById(int sunGlassId) throws SunGlassIdNotFoundException {
		try {
			SunGlasses sunGlass = sunGlassRepo.findById(sunGlassId).get();
			return sunGlass;
		} catch (Exception e) {
			throw new SunGlassIdNotFoundException("Id is not present, enter correct Id");
		}
	}

	@Override
	public List<SunGlasses> deleteSunGlass(int sunGlassId) throws NoSuchSunGlassFoundException {
		try {
			sunGlassRepo.deleteById(sunGlassId);
			return sunGlassRepo.findAll();
		} catch (Exception e) {
			throw new NoSuchSunGlassFoundException("No such product exists");
		}
	}

	@Override
	public SunGlasses updateSunGlass(SunGlasses sunGlass) throws InvalidSunGlassDataException {
		if (sunGlass.getPrice() <= 0) {
			throw new InvalidSunGlassDataException("Product price should be greater than 0");
		}
		if (sunGlass.getWeight() <= 0) {
			throw new InvalidSunGlassDataException("Product weight should be greater than 0");
		}
		return sunGlassRepo.save(sunGlass);
	}

}
