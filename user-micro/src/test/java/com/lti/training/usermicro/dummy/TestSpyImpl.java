package com.lti.training.usermicro.dummy;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class TestSpyImpl {

	@Test
	public void testSpy() {
		// spy instance of  class
		ArrayList spyArrayList = spy(ArrayList.class);
		// ArrayList spyArrayList = mock(ArrayList.class);
		spyArrayList.add("Test Data1");
		System.out.println(spyArrayList.get(0));
		System.out.println(spyArrayList.size());
		spyArrayList.add("Test Data2");
		spyArrayList.add("Test Data3");
		
		System.out.println(spyArrayList.size());
		when(spyArrayList.size()).thenReturn(5); //  will be fixed from now onwards
		System.out.println(spyArrayList.size());
		spyArrayList.add("Test Data4");
		System.out.println(spyArrayList.size());
		
		// verify if a method is called or not
		verify(spyArrayList).add("Test Data5");
	}
}






