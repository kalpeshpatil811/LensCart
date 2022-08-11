package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.repository.SunGlassRepository;

@Service
public class SunGlassService implements ISunGlassService {

	@Autowired
	private SunGlassRepository sunGlassRepo;

	@Override
	public SunGlasses addSunGlass(SunGlasses sunGlass) throws InvalidProductDataException {
		if (sunGlass.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		if (sunGlass.getWeight() <= 0) {
			throw new InvalidProductDataException("Product weight should be greater than 0");
		}
		return sunGlassRepo.save(sunGlass);
	}

	@Override
	public List<SunGlasses> getAllSunGlasses() {
		return sunGlassRepo.findAll();
	}

	@Override
	public SunGlasses getSunGlassById(int sunGlassId) throws IdNotFoundException {
		try {
			SunGlasses sunGlass = sunGlassRepo.findById(sunGlassId).get();
			return sunGlass;
		} catch (Exception e) {
			throw new IdNotFoundException("Id is not present, enter correct Id");
		}
	}

	@Override
	public List<SunGlasses> deleteSunGlass(int sunGlassId) throws NoSuchProductFoundException {
		try {
			sunGlassRepo.deleteById(sunGlassId);
			return sunGlassRepo.findAll();
		} catch (Exception e) {
			throw new NoSuchProductFoundException("No such product exists");
		}
	}

	@Override
	public SunGlasses updateSunGlass(SunGlasses sunGlass) throws InvalidProductDataException {
		if (sunGlass.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		if (sunGlass.getWeight() <= 0) {
			throw new InvalidProductDataException("Product weight should be greater than 0");
		}
		return sunGlassRepo.save(sunGlass);
	}

}
