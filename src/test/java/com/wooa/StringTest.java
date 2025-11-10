package com.wooa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void splitTest() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    void splitAloneTest() {
        assertThat("1".split(",")).containsExactly("1");
    }

}
