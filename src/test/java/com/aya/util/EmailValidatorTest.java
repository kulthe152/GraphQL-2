package com.aya.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private final EmailValidator undertest = new EmailValidator();

    @Test
    void itShouldValidateCorrectEmail() {
        Assertions.assertThat(undertest.test("kulthe11@gmail.com")).isTrue();
    }

    @Test
    void itShouldValidateIncorrectEmail() {

        Assertions.assertThat(undertest.test("kulthe1gmail.com")).isFalse();
    }

    @Test
    void itShouldValidateAnIncorrectEmailWithoutDotAtTheEnd() {
        Assertions.assertThat(undertest.test("kulthe1gmailcom")).isFalse();
    }
}