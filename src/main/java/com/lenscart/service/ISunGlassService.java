package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.SunGlassIdNotFoundException;
import com.lenscart.exception.InvalidSunGlassDataException;
import com.lenscart.exception.NoSuchSunGlassFoundException;

@Service
public interface ISunGlassService {

	public List<SunGlasses> getAllSunGlasses();

	public SunGlasses getSunGlassById(int sunGlassId) throws SunGlassIdNotFoundException;

	public List<SunGlasses> deleteSunGlass(int productId) throws NoSuchSunGlassFoundException;

	public SunGlasses addSunGlass(SunGlasses sunGlass) throws InvalidSunGlassDataException;

	public SunGlasses updateSunGlass(SunGlasses sunGlass) throws InvalidSunGlassDataException;

}
