package com.geekbrains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.geekbrains.lesson4.TriangleFunction.TriangleArea;
import static com.geekbrains.lesson4.TriangleFunction.calculaterHalfPerimeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Позитивная проверка площади треугольника 1")
    void positivCalculateTriangleAreaTest1(){
        logger.info("info log");
        double result = TriangleArea(3, 4, 5);
        Assertions.assertEquals(6, result);
    }
    @Test
    @DisplayName("Позитивная проверка площади треугольника 2")
    void positivCalculateTriangleAreaTest2(){
        logger.info("info log");
        double result = TriangleArea(6, 7, 8);
        Assertions.assertEquals(20.33316256758894, result);
    }
}
