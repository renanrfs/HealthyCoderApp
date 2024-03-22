package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_When_DietIsRecommended() {
        //given
        double weight = 89.0;
        double height = 1.72;

        //when
        boolean isRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isRecommended);
    }

    @Test
    void should_ReturnFalse_When_DietIsNotRecommended() {
        //given
        double weight = 50.0;
        double height = 1.92;

        //when
        boolean isRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(isRecommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightIsZero() {
        //given
        double weight = 50.0;
        double height = 0.0;

        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_When_ListNotEmpty() {
        //given
        List<Coder> coders = List.of(new Coder(1.85, 80.0), new Coder(1.72, 75.0), new Coder(1.92, 85.0));

        //when
        Coder worstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertAll(
                () -> assertEquals(1.72, worstBMI.getHeight()),
                () -> assertEquals(75.0, worstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNull_When_ListIsEmpty() {
        //given
        List<Coder> coders = List.of();

        //when
        Coder worstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertNull(worstBMI);
    }

    @Test
    void should_ReturnBMIScores_When_ListNotEmpty() {
        //given
        List<Coder> coders = List.of(new Coder(1.85, 80.0), new Coder(1.72, 75.0), new Coder(1.92, 85.0));
        double[] expectedBMIScores = {23.37, 25.35, 23.06};

        //when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        //then
        assertArrayEquals(expectedBMIScores, bmiScores);
    }

}