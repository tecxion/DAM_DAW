package com.fpdrioja.ed.ud03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrincipalTest {

	
	@Nested
    class PropuestosEjercicio {

        @Test
        void test1_Ejercicio() {
            assertEquals("c13i", Principal.wordEnds("abcXY123XYijk", "XY"));
        }

        @Test
        void test2_Ejercicio() {
            assertEquals("13", Principal.wordEnds("XY123XY", "XY"));
        }

        @Test
        void test3_Ejercicio() {
            assertEquals("11", Principal.wordEnds("XY1XY", "XY"));
        }
    }
	
    @Nested
    class CajaBlanca {

        @Test
        void test1_EspaciosTrim() {
            assertEquals("", Principal.wordEnds("abc", " "));
        }

        @Test
        void test2_LongitudInsuficiente() {
            assertEquals("", Principal.wordEnds("abc", "abcd"));
        }

        @Test
        void test3_NoInicio() {
            assertEquals("b", Principal.wordEnds("abc", "c"));
        }

        @Test
        void test4_Inicio() {
            assertEquals("b", Principal.wordEnds("abc", "a"));
        }

        @Test
        void test5_NoEncontrado() {
            assertEquals("", Principal.wordEnds("abc", "1"));
        }

        @Test
        void test6_SinPosterior() {
            assertEquals("a", Principal.wordEnds("ab", "b"));
        }

        @Test
        void test7_ConPosterior() {
            assertEquals("ac", Principal.wordEnds("abc", "b"));
        }
    }

    @Nested
    class CajaNegra {

        @Test
        void testPosicionesBasicas() {
            assertAll(
                () -> assertEquals("b", Principal.wordEnds("abc", "a")),
                () -> assertEquals("ac", Principal.wordEnds("abc", "b")),
                () -> assertEquals("b", Principal.wordEnds("abc", "c"))
            );
        }

        @Test
        void testMultiplesApariciones() {
            assertEquals("ac12", Principal.wordEnds("abc1b2", "b"));
        }

        @Test
        void testPalabraRepetidaEnCadena() {
            assertEquals("ac", Principal.wordEnds("abcabc", "abc"));
        }

        @Test
        void testRobustezNulos() {
            assertAll(
                () -> assertThrows(NullPointerException.class, () -> Principal.wordEnds(null, null)),
                () -> assertThrows(NullPointerException.class, () -> Principal.wordEnds("abc", null)),
                () -> assertThrows(NullPointerException.class, () -> Principal.wordEnds(null, "abc"))
            );
        }

        @Test
        void testCadenasVaciasYNulas() {
            assertAll(
                () -> assertEquals("", Principal.wordEnds("", "abc")),
                () -> assertEquals("", Principal.wordEnds("abc", "")),
                () -> assertEquals("", Principal.wordEnds("", ""))
            );
        }

        @Test
        void testIdentidadYMayorLongitud() {
            assertAll(
                () -> assertEquals("", Principal.wordEnds("abc", "abc")),
                () -> assertEquals("", Principal.wordEnds("abc", "abcd"))
            );
        }
    }
}