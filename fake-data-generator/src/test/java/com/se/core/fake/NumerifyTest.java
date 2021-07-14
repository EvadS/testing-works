package com.se.core.fake;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(timeOut = 1000)
public class NumerifyTest {

    public void shouldCreateRandomNumber() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.numerify("###");

        //then
        assertThat(result).matches("[0-9][0-9][0-9]");
    }

    public void shouldEmbedRandomNumberInText() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.numerify("Test#");

        //then
        assertThat(result).matches("Test[0-9]");
    }

    public void shouldGenerateOnlyNumbersInText() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.numerify("Test??##");

        //then
        assertThat(result).matches("Test\\?\\?[0-9][0-9]");
    }

}
