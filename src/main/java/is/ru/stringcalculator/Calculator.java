package is.ru.stringcalculator;

public class Calculator {

  static String baseDelimiters[] = {",", "\n"};
  
  public static int add(String text){
    if(text.equals(""))
        return 0;
    else
        if(textContainsAnyOf(text, baseDelimiters)){
            String numbers[] = text.split(",|\n");
            return sum(numbers);
        }
        return toInt(text);
  }

  private static int toInt(String number){
    return Integer.parseInt(number);
  }

  private static int sum(String [] numbers){
    int total = 0;
    int newNumb;
    String negativeNumbers = "";
    for(String number : numbers){
        newNumb = toInt(number);
        if(newNumb < 0)
          if(negativeNumbers == "")
            negativeNumbers = number;
          else
            negativeNumbers += ","+number;
        total += newNumb;
    }  
    if(negativeNumbers != "")
      throw new ArithmeticException("Negatives not allowed:" + negativeNumbers);
    return total;
  }

  private static boolean textContainsAnyOf(String text, String [] theseDelimiters){
    for(String delimiter : theseDelimiters){
      if(text.contains(delimiter))
        return true;
    }
    return false;
  }
} 