package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.Glass;
import com.lenscart.exception.GlassIdNotFoundException;
import com.lenscart.exception.InvalidGlassDataException;
import com.lenscart.exception.NoSuchGlassFoundException;

@Service
public interface IGlassService {
	
	public List<Glass> getAllGlass();

	public Glass getGlassById(int glassId) throws GlassIdNotFoundException;

	public Glass addGlass(Glass glasslass) throws InvalidGlassDataException ;

	public List<Glass> deleteGlass(int glassId) throws NoSuchGlassFoundException;
	
	public Glass updateGlass(Glass glass) throws InvalidGlassDataException;

}
