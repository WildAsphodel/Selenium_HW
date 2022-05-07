package com.geekbrains.lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    //TRACE, DEBUG, INFO, WARN, ERROR
    @BeforeAll
    static void beforeAll() {
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        System.out.println("Метод выполнился 1 раз перед всеми тестами класса");
        WebDriverManager.chromedriver().setup();
        System.out.println("Хром дравер зарегистрирован!!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    @Disabled
    @DisplayName("Позитивный тест с простым числом")
    void givenPrimeNumberWhenCallIsPrimeThenTrue() {
        boolean result = Functions.isPrime(7);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123321", "12321"})
    void isPalindromeTest(String word) {
        Assertions.assertTrue(Functions.isPalindrome(word));
    }

    @ParameterizedTest
    @CsvSource({"12321, true", "324561345, false"})
    void isPalindromeParametrizedTest(String word, boolean result) {
        Assertions.assertEquals(Functions.isPalindrome(word), result);
    }

    @ParameterizedTest
    @MethodSource("catAndBoolDataProvider")
    void anyObjectParametrizedTest(Cat test, Boolean result) {
        Assertions.assertEquals(test.getAge(), 10);
    }

    private static Stream<Arguments> catAndBoolDataProvider() {
        return Stream.of(
                Arguments.of(new Cat("moris", 10), true),
                Arguments.of(new Cat("Barsik", 11), false)
        );
    }

    @Test
    void assumeTest() {
        Assumptions.assumeTrue(1 == 2);
        Assertions.assertTrue(1 == 1);
    }

    @Test
    void assertAllTest() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(1 == 1),
                () -> Assertions.assertTrue(1 == 2),
                () -> Assertions.assertTrue(1 == 3)
        );
    }

    @AfterEach
    void afterEach() {
        //driver.quit();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится после всех тестов");
    }
}

