package com.exam.exam_06_13_Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void _1_더하기_1() {
        assertEquals(2, new Calc().calc("1 + 1"));
    }
    @Test
    public void _1_더하기_2() {
        assertEquals(3, new Calc().calc("1 + 2"));
    }
    @Test
    public void _1_빼기_1() {
        assertEquals(0, new Calc().calc("1 - 1"));
    }
    @Test
    public void _1_빼기_2() {
        assertEquals(-1, new Calc().calc("1 - 2"));
    }
    @Test
    public void _1_곱하기_1() {
        assertEquals(1, new Calc().calc("1 * 1"));
    }
    @Test
    public void _1_곱하기_2() {
        assertEquals(2, new Calc().calc("1 * 2"));
    }
    @Test
    public void _2_나누기_1() {
        assertEquals(2, new Calc().calc("2 / 1"));
    }
    @Test
    public void _2_나누기_2() {
        assertEquals(1, new Calc().calc("2 / 2"));
    }
    @Test
    public void 괄호_1_더하기_1() {
        assertEquals(2, new Calc().calc("(1 + 1)"));
    }
    @Test
    public void 괄호_괄호_1_더하기_2() {
        assertEquals(3, new Calc().calc("((1 + 2))"));
    }
    @Test
    public void 복합_5_곱하기_3_더하기_2() {
        assertEquals(17, new Calc().calc("5 * 3 + 2"));
    }
    @Test
    public void 복합_5_곱하기_3_더하기_1() {
        assertEquals(16, new Calc().calc("5 * 3 + 1"));
    }
    @Test
    public void 복합_5_더하기_3_곱하기_2() {
        assertEquals(11, new Calc().calc("5 + 3 * 2"));
    }
    @Test
    public void 복합_5_더하기_3_곱하기_3() {
        assertEquals(14, new Calc().calc("5 + 3 * 3"));
    }
    @Test
    public void 복합_5_곱하기_괄호_3_더하기_2() {
        assertEquals(25, new Calc().calc("5 * (3 + 2)"));
    }
    @Test
    public void 복합_5_곱하기_괄호_3_더하기_1() {
        assertEquals(20, new Calc().calc("5 * (3 + 1)"));
    }
    @Test
    public void 복합_괄호_5_더하기_3_곱하기_2() {
        assertEquals(16, new Calc().calc("(5 + 3) * 2"));
    }
    @Test
    public void 복합_괄호_5_더하기_3_곱하기_3() {
        assertEquals(24, new Calc().calc("(5 + 3) * 3"));
    }
    @Test
    public void 복합_1_빼기_1_빼기_1_빼기_1() {
        assertEquals(-2, new Calc().calc("1 - 1 - 1 - 1"));
    }
    @Test
    public void 복합_1_곱하기_1_곱하기_2_곱하기_4() {
        assertEquals(8, new Calc().calc("1 * 1 * 2 * 4"));
    }
    @Test
    public void 복합_괄호_1_더하기_1_곱하기_2() {
        assertEquals(10, new Calc().calc("(1 + 4) * 2"));
    }
//    집에서 실행하기
//    @Test
//    public void 심화_마이너스1_더하기_마이너스6() {
//        assertEquals(-7, new Calc().calc("-1 + -6"));
//    }
}
