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

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.InvalidSunGlassDataException;
import com.lenscart.exception.NoSuchSunGlassFoundException;
import com.lenscart.exception.SunGlassIdNotFoundException;
import com.lenscart.repository.SunGlassRepository;

@SpringBootTest
public class SunGlassServiceTest {

	@InjectMocks
	private SunGlassService service;

	@Mock
	private SunGlassRepository repository;

	@InjectMocks
	private SunGlasses sunGlass;

	@BeforeEach
	public void setUp() {
		sunGlass.setSunGlassId(101);
		sunGlass.setSunGlassName("Vincent Royal Sunglasses");
		sunGlass.setBrand("Vincent");
		sunGlass.setPrice(1500);
		sunGlass.setFrameColor("Blue");
		sunGlass.setFrameShape("Round");
		sunGlass.setGlassColor("Brown");
		sunGlass.setWeight(20);
		sunGlass.setImage("https://cdn.eyemyeye.com/shared/images/products/S66A1005/S66A1005-1.jpg");
	}

	@Test
	public void testGetAllSunGlasses() {
		Mockito.doReturn(Stream.of(sunGlass, sunGlass).collect(Collectors.toList())).when(repository).findAll();
		assertEquals(Stream.of(sunGlass, sunGlass).collect(Collectors.toList()), service.getAllSunGlasses());
		assertEquals(2, service.getAllSunGlasses().size());
	}

	@Test
	public void testAddSunGlass() throws InvalidSunGlassDataException {
		Mockito.doReturn(sunGlass).when(repository).save(Mockito.any());
		assertEquals(sunGlass.getSunGlassId(), service.addSunGlass(sunGlass).getSunGlassId());
		assertEquals(sunGlass.getSunGlassName(), service.addSunGlass(sunGlass).getSunGlassName());
		assertEquals(sunGlass.getPrice(), service.addSunGlass(sunGlass).getPrice());
	}

	@Test
	public void testUpdateSunGlass() throws InvalidSunGlassDataException {
		Mockito.doReturn(sunGlass).when(repository).save(Mockito.any());
		assertEquals(sunGlass.getSunGlassId(), service.updateSunGlass(sunGlass).getSunGlassId());
	}

	@Test
	public void testGetSunGlassById() throws SunGlassIdNotFoundException {
		int sunGlassId = 101;
		Mockito.when(repository.findById(sunGlassId)).thenReturn(Optional.of(sunGlass));
		assertEquals(sunGlass, service.getSunGlassById(sunGlassId));
		assertEquals(sunGlass.getSunGlassId(), service.getSunGlassById(sunGlassId).getSunGlassId());
	}

	@Test
	public void testDeleteSunGlass() throws NoSuchSunGlassFoundException {
		int sunGlassId = 101;
		service.deleteSunGlass(sunGlassId);
		Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}