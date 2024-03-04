import org.example.data.Polynomial;
import org.example.logic.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PolynomeCalculatorTest  {
    @Test
    public void testAdd(){
        assertEquals(new Adder().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("2x^2+4x+2").toString());
        assertEquals(new Adder().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^3-2x+1")).toString(),
                new Polynomial("x^3+x^2+2").toString());
        assertEquals(new Adder().performOperation(new Polynomial("-x^2+2x+1"), new Polynomial("x^2-2x+1")).toString(),
                new Polynomial("2").toString());
    }
    @Test
    public void testSubtract(){
        assertEquals(new Subtractor().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("0").toString());
        assertEquals(new Subtractor().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^3-2x+1")).toString(),
                new Polynomial("-x^3+x^2+4x").toString());
        assertEquals(new Subtractor().performOperation(new Polynomial("-x^2+2x+1"), new Polynomial("x^2-2x+1")).toString(),
                new Polynomial("-2x^2+4x").toString());
    }
    @Test
    public void testMultiplication(){
        assertEquals(new Multiplier().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("x^4+4x^3+6x^2+4x+1").toString());
        assertEquals(new Multiplier().performOperation(new Polynomial("x^3+2x^2+x+2"), new Polynomial("x")).toString(),
                new Polynomial("x^4+2x^3+x^2+2x").toString());
        assertEquals(new Multiplier().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^3-2x+1")).toString(),
                new Polynomial("x^5+2x^4-x^3-3x^2+1").toString());
    }
    @Test
    public void testDivision(){
        assertEquals(new Divider().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("1").toString());
    }
    @Test
    public void testModulo(){
        assertEquals(new Modulo().performOperation(new Polynomial("x^2+2x+1"), new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("0").toString());
    }
    @Test
    public void testDerivation(){
        assertEquals(new Derivator().performOperation(new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("2x+2").toString());
        assertEquals(new Derivator().performOperation(new Polynomial("x^3-2x+1")).toString(),
                new Polynomial("3x^2-2").toString());
        assertEquals(new Derivator().performOperation(new Polynomial("-x^2+2x+1")).toString(),
                new Polynomial("-2x+2").toString());
    }
    @Test
    public void testIntegration(){
        assertEquals(new Integrator().performOperation(new Polynomial("x^2+2x+1")).toString(),
                new Polynomial("0.33x^3+x^2+x").toString());
        assertEquals(new Integrator().performOperation(new Polynomial("x^3-2x+1")).toString(),
                new Polynomial("0.25x^4-x^2+x").toString());
        assertEquals(new Integrator().performOperation(new Polynomial("-x^2+2x+1")).toString(),
                new Polynomial("-0.33x^3+x^2+x").toString());
    }
}
