package com.se.core.fake;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(timeOut = 1000)
public class RandomnessVerificationTest {

	private static final int TRIES = 3;

	public void letterifyRandomness() {
		//given
		Faker faker = new Faker();

		//when
		Set<String> results = new HashSet<String>();
		for (int i = 0; i < TRIES; i++) {
			results.add(faker.letterify("???"));
		}

		//then
		assertThat(results).hasSize(TRIES);
	}

	public void numerifyRandomness() {
		//given
		Faker faker = new Faker();

		//when
		Set<String> results = new HashSet<String>();
		for (int i = 0; i < TRIES; i++) {
			results.add(faker.numerify("###"));
		}

		//then
		assertThat(results).hasSize(TRIES);
	}

	public void botifyRandomness() {
		//given
		Faker faker = new Faker();

		//when
		Set<String> results = new HashSet<String>();
		for (int i = 0; i < TRIES; i++) {
			results.add(faker.bothify("##??"));
		}

		//then
		assertThat(results).hasSize(TRIES);
	}
}
