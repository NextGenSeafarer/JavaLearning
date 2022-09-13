package jUnitTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JunitTest {

    @Test
    void isDividingCorrectly() {
        assertEquals(2, testOfAsserEquals.divider(5, 2));
    }
    // проверка на точный результат, деление 5 на 2 = 2

    @Test
    void dividingByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> testOfAsserEquals.divider(0, 5));
    }
    // выбрасывание исключения при делении на ноль

    @Test
    void testDeleteAllNumbers() {
        assertEquals("Test", testOfAsserEquals.test("Test1"));
    }
    // проверка замены всех цифр на пустую строчку

    @Test
    void emptyStringThrowsRuntimeException() {
        assertThrows(RuntimeException.class,
                () -> testOfAsserEquals.test("123"));
    }

    // выбрасывание исключение при пустой строке
    @Test
    void firstNumberIsBiggerThanSecondTest() {
        assertTrue(testOfAsserEquals.isFirstNumberBiggerThanSecond(10, 2));
    }
    // проверка булевой переменной на True

    @Test
    void averageGradesTest() {
        assertEquals(2, testOfAsserEquals.averageGrade(new double[]{2.5, 2.5, 3.0, 1.0, 6.0}));
    }
    // проверка средней оценки переданной в double массиве


}