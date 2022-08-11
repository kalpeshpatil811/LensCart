package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;

@Service
public interface ISunGlassService {

	public List<SunGlasses> getAllSunGlasses();

	public SunGlasses getSunGlassById(int sunGlassId) throws IdNotFoundException;

	public List<SunGlasses> deleteSunGlass(int productId) throws NoSuchProductFoundException;

	public SunGlasses addSunGlass(SunGlasses sunGlass) throws InvalidProductDataException;

	public SunGlasses updateSunGlass(SunGlasses sunGlass) throws InvalidProductDataException;

}
