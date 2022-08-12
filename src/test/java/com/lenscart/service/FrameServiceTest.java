package com.lenscart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.lenscart.entity.Frames;
import com.lenscart.exception.FrameIdNotFoundException;
import com.lenscart.exception.InvalidFrameDataException;
import com.lenscart.exception.NoSuchFrameFoundException;
import com.lenscart.repository.FrameRepository;
import com.lenscart.service.FrameService;

@SpringBootTest
public class FrameServiceTest {

	@InjectMocks
	private FrameService service;

	@Mock
	private FrameRepository repository;

	@InjectMocks
	private Frames frame;

	@BeforeEach
	public void setUp() {
		frame.setFrameId(101);
		frame.setFrameName("Vincent Royal Sunglasses");
		frame.setBrand("Vincent");
		frame.setColor("Blue");
		frame.setPrice(1500);
		frame.setDescription("Best frame");
		frame.setShapeOptions("oval");
		frame.setSize("large");
		frame.setFrameImage("https://cdn.eyemyeye.com/shared/images/products/S66A1005/S66A1005-1.jpg");
	}

	@Test
	public void testGetAllFrames() {
		Mockito.doReturn(Stream.of(frame, frame).collect(Collectors.toList())).when(repository).findAll();
		assertEquals(Stream.of(frame, frame).collect(Collectors.toList()), service.getAllFrames());
		assertEquals(2, service.getAllFrames().size());
	}

	@Test
	public void testAddFrame() throws InvalidFrameDataException {
		Mockito.doReturn(frame).when(repository).save(Mockito.any());
		assertEquals(frame.getFrameId(), service.addFrame(frame).getFrameId());
		assertEquals(frame.getFrameName(), service.addFrame(frame).getFrameName());
		assertEquals(frame.getBrand(), service.addFrame(frame).getBrand());
		assertEquals(frame.getColor(), service.addFrame(frame).getColor());
		assertEquals(frame.getPrice(), service.addFrame(frame).getPrice());
		assertEquals(frame.getDescription(), service.addFrame(frame).getDescription());
		assertEquals(frame.getShapeOptions(), service.addFrame(frame).getShapeOptions());
		assertEquals(frame.getSize(), service.addFrame(frame).getSize());
		assertEquals(frame.getFrameImage(), service.addFrame(frame).getFrameImage());
	}

	@Test
	public void testUpdateFrame() throws InvalidFrameDataException {
		Mockito.doReturn(frame).when(repository).save(Mockito.any());
		assertEquals(frame.getFrameId(), service.updateFrame(frame).getFrameId());
		assertEquals(frame.getFrameName(), service.updateFrame(frame).getFrameName());
		assertEquals(frame.getBrand(), service.updateFrame(frame).getBrand());
		assertEquals(frame.getColor(), service.updateFrame(frame).getColor());
		assertEquals(frame.getPrice(), service.updateFrame(frame).getPrice());
		assertEquals(frame.getDescription(), service.updateFrame(frame).getDescription());
		assertEquals(frame.getShapeOptions(), service.updateFrame(frame).getShapeOptions());
		assertEquals(frame.getSize(), service.updateFrame(frame).getSize());
		assertEquals(frame.getFrameImage(), service.updateFrame(frame).getFrameImage());
	}

	@Test
	public void testGetFrameById() throws FrameIdNotFoundException {
		int frameId = 1;
		Mockito.when(repository.findById(frameId)).thenReturn(Optional.of(frame));
		assertEquals(frame, service.getFrameById(frameId));
		assertEquals(frame.getFrameId(), service.getFrameById(frameId).getFrameId());
	}

	@Test
	public void testDeleteFrame() throws NoSuchFrameFoundException {
		int frameId = 1001;
		service.deleteFrame(frameId);
		Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}
}
