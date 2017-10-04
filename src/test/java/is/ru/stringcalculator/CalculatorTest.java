package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public static void testEmptyString() {
    assertEquals(0, Calculator.add(""));
  }
} 