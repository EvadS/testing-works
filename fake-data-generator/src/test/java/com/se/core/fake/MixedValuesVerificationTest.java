package com.se.core.fake;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(timeOut = 1000)
public class MixedValuesVerificationTest {

	public void letterifyShouldGenerateOnlyLettersInText() {
		//given
		Faker faker = new Faker();

		//when
		String result = faker.letterify("Test??##");

		//then
		assertThat(result).matches("Test[a-z][a-z]##");
	}

	public void numerifyShouldGenerateOnlyNumbersInText() {
		//given
		Faker faker = new Faker();

		//when
		String result = faker.numerify("Test??##");

		//then
		assertThat(result).matches("Test\\?\\?[0-9][0-9]");
	}

}
