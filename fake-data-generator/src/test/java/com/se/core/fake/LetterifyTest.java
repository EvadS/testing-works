package com.se.core.fake;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(timeOut = 1000)
public class LetterifyTest {

    public void shouldCreateRandomText() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.letterify("???");

        //then
        assertThat(result).matches("[a-z][a-z][a-z]");
    }

    public void shouldEmbedRandomLetterInText() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.letterify("Test?");

        //then
        assertThat(result).matches("Test[a-z]");
    }

    public void shouldGenerateOnlyLettersInText() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.letterify("Test??##");

        //then
        assertThat(result).matches("Test[a-z][a-z]##");
    }

}
