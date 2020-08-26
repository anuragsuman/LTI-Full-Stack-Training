package com.lti.training.usermicro.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import com.lti.training.usermicro.repository.DummyRepository;
import com.lti.training.usermicro.service.DummyBusinessService;




@RunWith(MockitoJUnitRunner.class)
public class TestDummyBusinessServiceMockPro {

	
	// create instance of service, 
	// wherever required inject/use the mock instance it is dependent on
	@InjectMocks
	private DummyBusinessService service;
	
	// creating a mock object
	@Mock 
	private DummyRepository repository;
	
	
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
	
	@Test
	public void testPrivateSum() throws Exception {
		int actual = (int) Whitebox.invokeMethod(this.service, "sum", 20, 30);
		assertEquals(55, actual);
	}
}














