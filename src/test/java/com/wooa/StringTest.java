package com.wooa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void splitTest() {
        assertThat("1,2".split(",")).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    void splitAloneTest() {
        assertThat("1".split(",")).isEqualTo(new String[]{"1"});
    }

}
