package org.example;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class TestTriangleArea {

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13),
                Arguments.of(new Triangle(3, 3, 3), 9));
    }

    public static Stream<Arguments> areaTriangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(8, 11, 6), 23.42),
                Arguments.of(new Triangle(4, 7, 6), 11.98));

    }

    @ParameterizedTest(name = "Периметр треугольника: позитивный сценарий, периметр треугольника {0} == {1}")
    @MethodSource("triangles")
    void countPerimeterPositiveTest(Triangle triangle, int expectedResult) {
        int perimeter = triangle.countPerimeter();
        assertThat(perimeter).as("Проверяем, что периметр должен ....")
                .isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "Площадь треугольника: позитивный сценарий {0} == {1}")
    @MethodSource("areaTriangles")
    void areaPerimeterPositiveTest(Triangle triangle, double expectedResult) {
        double area = triangle.countArea();
        assertThat(area).as("Проверяем, что площадь должна ....")
                .isEqualTo(expectedResult);
    }

    public static Stream<Arguments> negativeTriangles() {
        return Stream.of(Arguments.of(new Triangle(0, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Sides must be positive"),
                Arguments.of(new Triangle(3, 3, 0), "Sides must be positive"),
                Arguments.of(new Triangle(3, 3, -1), "Sides must be positive"),
                Arguments.of(new Triangle(3, -1, 3), "Sides must be positive"),
                Arguments.of(new Triangle(-1, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(-1, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(6, 1, 1), "One side can't be greater than sum of others"),
                Arguments.of(new Triangle(1, 2, 1), "One side can't be greater than sum of others")
        );
    }

    @ParameterizedTest(name = "Периметр треугольника: негативный сценарий (треугольник {0}, ошибка:{1})")
    @MethodSource("negativeTriangles")
    public void countPerimeterNegativeTest(Triangle triangle, String errorText) {
        assertThatThrownBy(triangle::countPerimeter)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorText);
    }




}




