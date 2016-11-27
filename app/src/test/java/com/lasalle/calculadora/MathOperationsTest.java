package com.lasalle.calculadora;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MathOperationsTest {

    private MathOperations p;

    @Before
    public void setUp() {
        p = new MathOperations();
    }

    @Test
    public void multiplyAbsolute() throws Exception {
        assertEquals(6,p.multiplicar(3,2));
    }

    @Test
    public void multiplySigned() throws Exception {
        assertEquals(-4,p.multiplicar(-2,2));
        assertEquals(4,p.multiplicar(-2,-2));
        assertEquals(-4,p.multiplicar(2,-2));

    }

    @Test
    public void restarSigned() throws Exception {
        assertEquals(0,p.restar(-2,-2));
        assertEquals(-4,p.restar(-2,2));
        assertEquals(4,p.restar(2,-2));

    }
    @Test
    public void restarAbsolute() throws Exception {
        assertEquals(0,p.restar(2,2));
    }

}