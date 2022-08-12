package com.lenscart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.lenscart.entity.Glass;
import com.lenscart.exception.GlassIdNotFoundException;
import com.lenscart.exception.InvalidGlassDataException;
import com.lenscart.exception.NoSuchGlassFoundException;
import com.lenscart.repository.GlassRepository;

@SpringBootTest
public class GlassServiceTest {
	@InjectMocks
	private GlassService glassService;

	@Mock
	private GlassRepository glassRepo;

	@InjectMocks
	private Glass glass;

	@BeforeEach
	public void setUp() {
		// Glass glass = new Glass();

		glass.setGlassId(001);
		glass.setGlassName("Blue Block");
		glass.setBrand("John Jacobs");
		glass.setType("zero power");
		glass.setPowerRange(10);
		glass.setPrice(1200);
		glass.setGlassImage(
				"https://static5.lenskart.com/media/catalog/product/pro/1/thumbnail/628x301/9df78eab33525d08d6e5fb8d27136e95//v/i/vincent-chase-vc-e13786-c2-eyeglasses_vincent-chase-vc-e13786-c2-eyeglasses_g_3319.jpg");
	}

	@Test
	public void testGetAllGlass() {
		Mockito.doReturn(Stream.of(glass, glass).collect(Collectors.toList())).when(glassRepo).findAll();
		assertEquals(Stream.of(glass, glass).collect(Collectors.toList()), glassService.getAllGlass());
		assertEquals(2, glassService.getAllGlass().size());
	}

	@Test
	public void testAddGlass() throws InvalidGlassDataException {
		Mockito.doReturn(glass).when(glassRepo).save(Mockito.any());
		assertEquals(glass.getGlassId(), glassService.addGlass(glass).getGlassId());
		assertEquals(glass.getGlassName(), glassService.addGlass(glass).getGlassName());
		assertEquals(glass.getPrice(), glassService.addGlass(glass).getPrice());
	}

	@Test
	public void testUpdateGlass() throws InvalidGlassDataException {
		Mockito.doReturn(glass).when(glassRepo).save(Mockito.any());
		assertEquals(glass.getGlassId(), glassService.addGlass(glass).getGlassId());
		assertEquals(glass.getGlassName(), glassService.addGlass(glass).getGlassName());
		assertEquals(glass.getPrice(), glassService.addGlass(glass).getPrice());
	}

	@Test
	public void testGetGlassById() throws GlassIdNotFoundException {
		int glassId = 1001;
		Mockito.when(glassRepo.findById(glassId)).thenReturn(Optional.of(glass));
		assertEquals(glass, glassService.getGlassById(glassId));
		assertEquals(glass.getGlassId(), glassService.getGlassById(glassId).getGlassId());
	}

	@Test
	public void testDeleteGlass() throws NoSuchGlassFoundException {
		int glassId = 1001;
		glassService.deleteGlass(glassId);
		Mockito.verify(glassRepo, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}
}
