package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testEmptyString() {
    assertEquals(0, Calculator.add(""));
  }

  @Test
  public void testOneNumber() {
    assertEquals(1, Calculator.add("1"));
    assertEquals(2, Calculator.add("2"));
  }

  @Test
  public void testTwoNumber() {
    assertEquals(3, Calculator.add("1,2"));
  }

  @Test
  public void testMultipleNumber() {
    assertEquals(6, Calculator.add("1,2,3"));
  }

  @Test
  public void testNewLineDelim() {
    assertEquals(6, Calculator.add("1\n2,3"));
    assertEquals(6, Calculator.add("1\n2\n3"));
  }

  @Test
  public void testNegativesException() {
    boolean thrown = false;
    try {
      Calculator.add("-1,2");
    } catch (ArithmeticException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

} 