package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CalculatorTest {

  @Test // 1
  public void testEmptyString() {
    assertEquals(0, Calculator.add(""));
  }

  @Test // 2
  public void testOneNumber() {
    assertEquals(1, Calculator.add("1"));
    assertEquals(2, Calculator.add("2"));
  }

  @Test // 3
  public void testTwoNumber() {
    assertEquals(3, Calculator.add("1,2"));
  }

  @Test // 4
  public void testMultipleNumber() {
    assertEquals(6, Calculator.add("1,2,3"));
  }

  @Test // 5
  public void testNewLineDelim() {
    assertEquals(6, Calculator.add("1\n2,3"));
    assertEquals(6, Calculator.add("1\n2\n3"));
  }

  @Test // 6
  public void testNegativeException() {
    boolean thrown = false;
    try {
      Calculator.add("-1");
    } catch (ArithmeticException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test // 7
  public void testNegativesException() {
    boolean thrown = false;
    try {
      Calculator.add("-1,2");
    } catch (ArithmeticException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test // 8
  public void testOverThousand() {
    assertEquals(2, Calculator.add("1001,2"));
  }

  @Test // 9
  public void testNewDelimiter() {
    assertEquals(3, Calculator.add("//;\n1,2"));
    assertEquals(3, Calculator.add("//;\n1;2"));
  }

} 