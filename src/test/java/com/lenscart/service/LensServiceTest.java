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

import com.lenscart.entity.Lenses;
import com.lenscart.exception.InvalidLensDataException;
import com.lenscart.exception.LensIdNotFoundException;
import com.lenscart.exception.NoSuchLensFoundException;
import com.lenscart.repository.LensesRepository;

@SpringBootTest
public class LensServiceTest {

	@InjectMocks
	private LensesService service;

	@Mock
	private LensesRepository repository;

	@InjectMocks
	private Lenses lens;

	@BeforeEach
	public void setUp() {
		lens.setLensId(101);
		lens.setBrand("Vincent Royal Sunglasses");
		lens.setLenseImage("https://cdn.eyemyeye.com/shared/images/products/S66A1005/S66A1005-1.jpg");
		lens.setShape("Round");
		lens.setColor("Blue");
		lens.setPrice(1500);
	}

	@Test
	public void testGetAllLenses() {
		Mockito.doReturn(Stream.of(lens, lens).collect(Collectors.toList())).when(repository).findAll();
		assertEquals(Stream.of(lens, lens).collect(Collectors.toList()), service.getAllLenses());
		assertEquals(2, service.getAllLenses().size());
	}

	@Test
	public void testAddLenses() throws InvalidLensDataException {
		Mockito.doReturn(lens).when(repository).save(Mockito.any());
		assertEquals(lens.getLensId(), service.addLens(lens).getLensId());
		assertEquals(lens.getBrand(), service.addLens(lens).getBrand());
		assertEquals(lens.getPrice(), service.addLens(lens).getPrice());
	}

	@Test
	public void testUpdateLens() throws InvalidLensDataException {
		Mockito.doReturn(lens).when(repository).save(Mockito.any());
		assertEquals(lens.getLensId(), service.updateLens(lens).getLensId());
		assertEquals(lens.getBrand(), service.updateLens(lens).getBrand());
		assertEquals(lens.getPrice(), service.updateLens(lens).getPrice());
	}

	@Test
	public void testGetLensById() throws LensIdNotFoundException {
		int lensId = 1001;
		Mockito.when(repository.findById(lensId)).thenReturn(Optional.of(lens));
		assertEquals(lens, service.getLensById(lensId));
		assertEquals(lens.getLensId(), service.getLensById(lensId).getLensId());
	}

	@Test
	public void testDeleteLens() throws NoSuchLensFoundException {
		int lensId = 1001;
		service.deleteLens(lensId);
		Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}
