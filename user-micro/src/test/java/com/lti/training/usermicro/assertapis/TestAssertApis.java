package com.lti.training.usermicro.assertapis;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class TestAssertApis {

	@Test
	public void test1() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers)
					.hasSize(3)
					.contains(12,45)
					.allMatch(val -> val > 10)
					.allMatch(val -> val < 100)
					.noneMatch(val -> val < 0);
		assertThat("").isEmpty();
		assertThat("ABCDE").contains("BCD")
							.startsWith("ABC");
					
		// assertThat(numbers).contains(12,15);
	}
}
