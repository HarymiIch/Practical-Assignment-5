package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStateMachineTest {

    private final TestStateMachine machine = new TestStateMachine();

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "abcTES, 3",
            "T, 1",
            "TE, 2",
            "TES, 3",
            "TEST, F",
            "hello world, S",
            "TTEST, F",
            "TESTEST, F"
    })
    void testStateMachine(String input, String expectedState) {
        String actualState = machine.process(input);
        assertEquals(expectedState, actualState);
    }
}