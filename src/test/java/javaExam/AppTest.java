package javaExam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest {

	@ParameterizedTest
	@ValueSource(ints = { 3, 5 })
	@DisplayName("Should generate expected studients")
	public void testGenerate(int n) {
		assertEquals(n, App.generateSVs(n).size());
	}

	@ParameterizedTest
	@ValueSource(ints = { 15 })
	@DisplayName("Should get top 10 studients")
	public void testGetTop10(int n) {
		assertEquals(10, App.getTop10Students(App.generateSVs(n)).size());
	}
}
