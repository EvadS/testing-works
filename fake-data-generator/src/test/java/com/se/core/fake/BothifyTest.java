package com.se.core.fake;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(timeOut = 1000)
public class BothifyTest {

    public void shouldEmbedRandomElementsInText() {
        //given
        Faker faker = new Faker();

        //when
        String result = faker.bothify("Test?#");

        //then
        assertThat(result).matches("Test[a-z][0-9]");
    }

}
