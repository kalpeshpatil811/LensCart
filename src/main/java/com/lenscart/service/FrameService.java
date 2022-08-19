package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Frames;
import com.lenscart.exception.FrameIdNotFoundException;
import com.lenscart.exception.InvalidFrameDataException;
import com.lenscart.exception.NoSuchFrameFoundException;
import com.lenscart.repository.FrameRepository;

/***************************
 * Frame Service Class
 *
 * Created By: Laxman Adkune
 * Date: 10/08/2022
 ***************************/

@Service
public class FrameService implements IFrameService {

	@Autowired
	private FrameRepository frameRepo;

	@Override
	public Frames addFrame(Frames frame) throws InvalidFrameDataException {
		if (frame.getPrice() <= 0) {
			throw new InvalidFrameDataException("Frame price should be greater than 0 ");
		}
		if (frame.getSize().equals("small") || frame.getSize().equals("medium") || frame.getSize().equals("large")) {
			return frameRepo.save(frame);
		} else {
			throw new InvalidFrameDataException("Shape size should be samll/medium/large ");
		}
	}

	@Override
	public List<Frames> getAllFrames() {
		return frameRepo.findAll();
	}

	@Override
	public Frames getFrameById(int frameId) throws FrameIdNotFoundException {
		try {
			Frames frame = frameRepo.findById(frameId).get();
			return frame;
		} catch (Exception e) {
			throw new FrameIdNotFoundException("Enter correct frame Id");
		}
	}

	@Override
	public List<Frames> deleteFrame(int frameId) throws NoSuchFrameFoundException {
		try {
			frameRepo.deleteById(frameId);
			return frameRepo.findAll();
		} catch (Exception e) {
			throw new NoSuchFrameFoundException("No such frame exist");
		}
	}

	@Override
	public Frames updateFrame(Frames frame) throws InvalidFrameDataException {
		if (frame.getPrice() <= 0) {
			throw new InvalidFrameDataException("Frame price should be greater than 0 ");
		}
		if (frame.getSize().equals("small") || frame.getSize().equals("medium") || frame.getSize().equals("large")) {
			return frameRepo.save(frame);
		} else {
			throw new InvalidFrameDataException("Shape size should be samll/medium/large ");
		}
	}
}
