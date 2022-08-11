package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Frames;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.repository.FrameRepository;

@Service
public class FrameService implements IFrameService {
	
	@Autowired
	private FrameRepository frameRepo;

	@Override
	public Frames addFrame(Frames frame) throws InvalidProductDataException{
		
		if(frame.getSize().equals("small") || frame.getSize().equals("medium") || frame.getSize().equals("large")) 
		{
			return frameRepo.save(frame);
		}
		else if (frame.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0 ");
		}
		else
		{
		throw new InvalidProductDataException("Shape size should be samll/medium/large ");
		}
	}

	@Override
	public List<Frames> getAllFrames() {
		return frameRepo.findAll();
	}

	@Override
	public Frames getFrameById(int frameId) throws IdNotFoundException{
		Frames frame = frameRepo.findById(frameId).get();
		if(frame == null) {
			throw new IdNotFoundException("Enter correct product Id");
		}
		return frame;
	}

	@Override
	public List<Frames> deleteFrame(int frameId)throws NoSuchProductFoundException {
		try {
			frameRepo.deleteById(frameId);
			return frameRepo.findAll();
		} catch (Exception e) {
			throw new NoSuchProductFoundException("No such product exist");
		}
	}

	@Override
	public Frames updateFrame(Frames frame) throws InvalidProductDataException{
		
		if(frame.getSize().equals("small") || frame.getSize().equals("medium") || frame.getSize().equals("large")) 
		{
			return frameRepo.save(frame);
		}
		else if (frame.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0 ");
		}
		else
		{
		throw new InvalidProductDataException("Shape size should be samll/medium/large ");
		}
	}
}
