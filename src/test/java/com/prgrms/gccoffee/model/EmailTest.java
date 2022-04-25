package com.prgrms.gccoffee.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void testInvalidEmail() {
        assertThatThrownBy(() -> new Email("acccc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid email address");
    }

    @Test
    void testValidEmail() {
        Email email = new Email("hwan@gmail.com");
        assertThat(email.getAddress()).isEqualTo("hwan@gmail.com");
    }

    @Test
    void testEqualEmail() {
        Email email = new Email("hwan@gmail.com");
        Email email2 = new Email("hwan@gmail.com");
        assertThat(email).isEqualTo(email2);
    }

}
