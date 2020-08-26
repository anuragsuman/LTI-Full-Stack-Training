package com.lti.training.usermicro.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.lti.training.usermicro.service.DummyBusinessService;

// Test Suite : Container to hold test cases
public class TestDummyBusinessService {

	// Test case would be method
	private DummyBusinessService service;
	
	@BeforeClass
	public static void initialSetUp() {
		// once before any test case is executed
	}
	
	@Before
	public void setUp() {
		// would execute before every test case
		this.service = new DummyBusinessService();
	}
	
	@Test
	public void testCalculateSumStd() {
		// DummyBusinessService service = new DummyBusinessService();
		int []data = new int[] {1, 2, 3};
		int actualResult = service.calculateSum(data);
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	// @Ignore 
	public void testCalculateSumEmpty() {
		// DummyBusinessService service = new DummyBusinessService();
		int []data = new int[] {};
		int actualResult = service.calculateSum(data);
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	// @Ignore 
	public void testCalculateSumSingle() {
		// DummyBusinessService service = new DummyBusinessService();
		int []data = new int[] {4};
		int actualResult = service.calculateSum(data);
		int expectedResult = 4;
		assertEquals(expectedResult, actualResult);
	}
	
	@After
	public void cleanUp() {
		// executes after every test case
	}
	
	@AfterClass
	public static void finalCleanUp() {
		// once after all test cases are executed
	}
}
















