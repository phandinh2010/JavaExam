package javaExam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AppTest {

	@Test
	@ParameterizedTest
	@ValueSource(ints = { 3, 5 })
	@DisplayName("Should generate expected studients")
	void testMain(int n) {
		assertEquals(n, App.generateSVs(n).size());
	}

}
