package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Lenses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;

@Service
public interface ILensesService {

	public List<Lenses> getAllLenses();

	public Lenses getLensById(int lensId) throws IdNotFoundException;
	
	public Lenses addLens(Lenses lens) throws InvalidProductDataException;

	public List<Lenses> deleteLens(int productId) throws IdNotFoundException;
	
	public Lenses updateLens(Lenses lenses) throws InvalidProductDataException;

}



	
