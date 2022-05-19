package com.geekbrains.lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @CsvSource({"3, -4, 5", "2, 0, 3"})
     void exceptionTrowsWhenNumberIsInvalid (int a, int b, int c) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> TriangleFunction.AreaOfATriangle(a,b,c));
    }

    @ParameterizedTest
    @CsvSource({"6, 4, 1", "23, 15, 40", "8, 17, 7"})
    void exceptionTrowsWhenTriangleDoesNotExist (int a, int b, int c) {
        Assertions.assertThrows(TriangleDoesNotExistException.class,
                () -> TriangleFunction.AreaOfATriangle(a, b, c));
    }

    @Test
    void givenNumbersWhenCallAreaOfATriangleThenCalculateArea () throws TriangleDoesNotExistException {
        Double area = TriangleFunction.AreaOfATriangle(3, 5, 4);
        Assertions.assertEquals(area, 6);
    }

}
