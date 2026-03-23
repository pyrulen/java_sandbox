package dev.pyrulen.leet.bigint;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BigIntMultiplierTest {

    private BigIntMultiplier app;

    @BeforeEach
    void setUp() {
        app = new BigIntMultiplier();
    }

    @Test
    @Order(1)
    void test1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("121932631112635269", app.multiplyLargeNumbers("123456789", "987654321"));
        });
    }

    @Test
    @Order(2)
    void test2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("56088", app.multiplyLargeNumbers("123", "456"));
        });
    }

    @Test
    @Order(3)
    void test3() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("20000", app.multiplyLargeNumbers("100", "200"));
        });
    }

    @Test
    @Order(4)
    void test4() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("250000", app.multiplyLargeNumbers("500", "500"));
        });
    }

    @Test
    @Order(5)
    void test5() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("1000000000000000000", app.multiplyLargeNumbers("1000000000", "1000000000"));
        });
    }

    @Test
    @Order(6)
    void test6() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("999999999", app.multiplyLargeNumbers("999999999", "1"));
        });
    }

    @Test
    @Order(7)
    void test7() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("0", app.multiplyLargeNumbers("0", "500"));
        });
    }

    @Test
    @Order(8)
    void test8() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("1", app.multiplyLargeNumbers("1", "1"));
        });
    }

    @Test
    @Order(9)
    void test9() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("81", app.multiplyLargeNumbers("9", "9"));
        });
    }

    @Test
    @Order(10)
    void test10() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals("12345678987654321", app.multiplyLargeNumbers("111111111", "111111111"));
        });
    }
}
