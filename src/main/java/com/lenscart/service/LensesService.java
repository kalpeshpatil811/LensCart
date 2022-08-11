package com.lenscart.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Lenses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.repository.LensesRepository;


@Service
public class LensesService implements ILensesService {

	@Autowired
	private LensesRepository LensesRepo;

	@Override
	public List<Lenses> getAllLenses() {
		return LensesRepo.findAll();
	}

	@Override
	public Lenses getLensById(int lensId) throws IdNotFoundException {
		try {
			Lenses lens = LensesRepo.findById(lensId).get();
			return lens;
		}catch (Exception e){
		throw new IdNotFoundException("Enter correct product Id");
		}
	}
	
	@Override
	public Lenses addLens(Lenses lens) throws InvalidProductDataException{
		if (lens.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		return LensesRepo.save(lens);
	}

	public List<Lenses> deleteLens(int lensId) throws IdNotFoundException {
		try{
			LensesRepo.deleteById(lensId);
			return LensesRepo.findAll();
		}catch (Exception e) {
			throw new IdNotFoundException("No such product exists");
		}
	}
	
	@Override
	public Lenses updateLens(Lenses lens) throws InvalidProductDataException {
		if (lens.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		return LensesRepo.save(lens);
	}

}