package com.lenscart.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Lenses;
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
	public Lenses getLensById(Integer lensId) {
		return LensesRepo.findById(lensId).get();

	}

	@Override
	public Lenses addLens(Lenses lens){
		return LensesRepo.save(lens);
	}

	@Override
	public void deleteLens(Integer productId) {
		LensesRepo.deleteById(productId);
	}

	@Override
	public Lenses updateLens(Lenses lenses) {
		return LensesRepo.save(lenses);
	}

}