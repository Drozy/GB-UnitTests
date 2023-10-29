package seminars.third.hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainHWTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 8, -12, 102})
    void checkEvensInEvenOddNumber(int num) {
        assertTrue(MainHW.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 3, 11, -19, 233})
    void checkOddsInEvenOddNumber(int num) {
        assertFalse(MainHW.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 34, 60, 75, 99})
    void testTrueNumberInInterval(int num) {
        assertTrue(MainHW.numberInInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 3, 25, -19, 100, 456})
    void testFalseNumberInInterval(int num) {
        assertFalse(MainHW.numberInInterval(num));
    }
}