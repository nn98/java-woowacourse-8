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

    @Test
    void substringTest() {
        String testString = "(1,2)";
        assertThat(testString.substring(1,testString.length()-1)).isEqualTo("1,2");
    }

}
