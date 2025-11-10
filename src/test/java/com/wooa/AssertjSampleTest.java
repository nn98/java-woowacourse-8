package com.wooa;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AssertjSampleTest {
    @Test
    void works() {
        assertThat(1 + 1).isEqualTo(2);
    }
}