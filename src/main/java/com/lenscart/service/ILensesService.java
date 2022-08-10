package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Lenses;

@Service
public interface ILensesService {

	public List<Lenses> getAllLenses();

	public Lenses getLensById(Integer lensId);
	
	public Lenses addLens(Lenses lens);

	public void deleteLens(Integer productId);
	
	public Lenses updateLens(Lenses lenses);

}
	



	
