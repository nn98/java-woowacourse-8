package com.wooa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    void chatAtTest(int index, char target) {
        String testString = "abc";
        assertThat(testString.charAt(index)).isEqualTo(target);
    }

    @Test
    void charAtExceptionTest() {
        String testString = "abc";
        assertThatThrownBy(() -> testString.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3", "length 3");
    }

}
