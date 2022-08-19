package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Glass;
import com.lenscart.exception.GlassIdNotFoundException;
import com.lenscart.exception.InvalidGlassDataException;
import com.lenscart.exception.NoSuchGlassFoundException;
import com.lenscart.repository.GlassRepository;

/***************************
 * Glass Service Class
 *
 * Created By: Disha Kale
 * Date: 10/08/2022
 ***************************/

@Service
public class GlassService implements IGlassService {

	@Autowired
	private GlassRepository glassRepo;

	@Override
	public Glass addGlass(Glass glass) throws InvalidGlassDataException {
		if (glass.getPrice() <= 0) {
			throw new InvalidGlassDataException("Product price should be greater than 0");
		} else if (glass.getType().equals("zero power") || glass.getType().equals("digital screen protection")
				|| glass.getType().equals("single vision") || glass.getType().equals("bifocal powered glass")) {
			return glassRepo.save(glass);
		}

		else {
			throw new InvalidGlassDataException(
					"Please Enter Zero power/digital screen protection/single vision/bifocal powered glass");
		}
	}

	@Override
	public List<Glass> getAllGlass() {
		return glassRepo.findAll();
	}

	@Override
	public Glass getGlassById(int glassId) throws GlassIdNotFoundException {

		try {
			Glass glass = glassRepo.findById(glassId).get();
			return glass;

		} catch (Exception e) {
			throw new GlassIdNotFoundException("Id is not Present ");
		}

	}

	public List<Glass> deleteGlass(int glassId) throws NoSuchGlassFoundException {
		try {
			glassRepo.deleteById(glassId);
			return glassRepo.findAll();
		} catch (Exception e) {
			throw new NoSuchGlassFoundException("Product not found. ");
		}

	}

	public Glass updateGlass(Glass glass) throws InvalidGlassDataException {
		if (glass.getPrice() <= 0) {
			throw new InvalidGlassDataException("Product price should be greater than 0");
		} else if (glass.getType().equals("zero power") || glass.getType().equals("digital screen protection")
				|| glass.getType().equals("single vision") || glass.getType().equals("bifocal powered glass")) {
			return glassRepo.save(glass);
		}

		else {
			throw new InvalidGlassDataException(
					"Please Enter Zero power/digital screen protection/single vision/bifocal powered glass");
		}
	}
}
