package com.lti.training.usermicro.assertapis;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestHamcrestApi {
	@Test
	public void test1() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,45));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(100)));
		
		assertThat("ABCDE", containsString("BCD"));
	}
}
