package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Lenses;
import com.lenscart.exception.LensIdNotFoundException;
import com.lenscart.exception.InvalidLensDataException;
import com.lenscart.exception.NoSuchLensFoundException;
import com.lenscart.repository.LensesRepository;

/*********
 * Lenses Service Class
 *
 * Created By: Sachin Phatak
 * Date: 10/08/2022
*********/

@Service
public class LensesService implements ILensesService {

	@Autowired
	private LensesRepository lensesRepo;

	@Override
	public List<Lenses> getAllLenses() {
		return lensesRepo.findAll();
	}

	@Override
	public Lenses getLensById(int lensId) throws LensIdNotFoundException {
		try {
			Lenses lens = lensesRepo.findById(lensId).get();
			return lens;
		} catch (Exception e) {
			throw new LensIdNotFoundException("Enter Correct Lens Id");
		}
	}

	@Override
	public Lenses addLens(Lenses lens) throws InvalidLensDataException {
		if (lens.getPrice() <= 0) {
			throw new InvalidLensDataException("Lens Price Should Be Greater Than 0");
		}
		return lensesRepo.save(lens);
	}

	public List<Lenses> deleteLens(int lensId) throws NoSuchLensFoundException {
		try {
			lensesRepo.deleteById(lensId);
			return lensesRepo.findAll();
		} catch (Exception e) {
			throw new NoSuchLensFoundException("No Such Lens Exists");
		}
	}

	@Override
	public Lenses updateLens(Lenses lens) throws InvalidLensDataException {
		if (lens.getPrice() <= 0) {
			throw new InvalidLensDataException("Product Price Should Be Greater Than 0");
		}
		return lensesRepo.save(lens);
	}

}