package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.lenscart.entity.Frames;
import com.lenscart.exception.FrameIdNotFoundException;
import com.lenscart.exception.InvalidFrameDataException;
import com.lenscart.exception.NoSuchFrameFoundException;


@Service
public interface IFrameService {

	public Frames addFrame(Frames frame) throws InvalidFrameDataException;

	public List<Frames> getAllFrames();

	public Frames getFrameById(int frameId)throws FrameIdNotFoundException;

	public List<Frames> deleteFrame(int frameId) throws NoSuchFrameFoundException;

	public Frames updateFrame(Frames frame)throws InvalidFrameDataException;
}
