package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Lenses;
import com.lenscart.exception.LensIdNotFoundException;
import com.lenscart.exception.InvalidLensDataException;
import com.lenscart.exception.NoSuchLensFoundException;

@Service
public interface ILensesService {

	public List<Lenses> getAllLenses();

	public Lenses getLensById(int lensId) throws LensIdNotFoundException;
	
	public Lenses addLens(Lenses lens) throws InvalidLensDataException;

	public List<Lenses> deleteLens(int productId) throws NoSuchLensFoundException;
	
	public Lenses updateLens(Lenses lenses) throws InvalidLensDataException;

}



	
