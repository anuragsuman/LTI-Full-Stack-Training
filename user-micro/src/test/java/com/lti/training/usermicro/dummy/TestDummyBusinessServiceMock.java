package com.lti.training.usermicro.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.lti.training.usermicro.repository.DummyRepository;
import com.lti.training.usermicro.service.DummyBusinessService;

public class TestDummyBusinessServiceMock {

	private DummyBusinessService service;
	
	@Mock
	private DummyRepository repository;
	
	@Before
	public void setUp(){
		this.service = new DummyBusinessService();
		this.repository = mock(DummyRepository.class);
		this.service.setRepository(repository);
	}
	
	@Test
	public void testCalculateSumFromRepositoryStd() {
		// DummyBusinessService service = new DummyBusinessService();
		int []data = new int[] {1, 2, 3};
		// simulate the function of repository
		when(this.repository.getNumbersFromDB()).thenReturn(data);
		
		int actualResult = service.calculateSumFromRepository();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testCalculateSumFromRepositoryEmpty() {
		// DummyBusinessService service = new DummyBusinessService();
		int []data = new int[] {};
		// simulate the function of repository
		when(this.repository.getNumbersFromDB()).thenReturn(data);
		
		int actualResult = service.calculateSumFromRepository();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testCalculateSumFromRepositorySingle() {
		// DummyBusinessService service = new DummyBusinessService();
		int []data = new int[] {4};
		// simulate the function of repository
		when(this.repository.getNumbersFromDB()).thenReturn(data);
		
		int actualResult = service.calculateSumFromRepository();
		int expectedResult = 4;
		assertEquals(expectedResult, actualResult);
	}
	
}















