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
        String singleSizeArr[] = new String[] {text};
        return sum(singleSizeArr);
  }

  private static int toInt(String number){
    return Integer.parseInt(number);
  }

  private static int sum(String [] numbers){
    checkForNegatives(numbers);
    int total = 0;
    int newNumb;
    for(String number : numbers){
        newNumb = toInt(number);
        total += ignoreOver1000(newNumb);
    }  
    return total;
  }

  private static void checkForNegatives(String [] numbers){
    String negativeNumbers = "";
    int newNumb;
    for(String number : numbers){
      newNumb = toInt(number);
      if(newNumb < 0)
        if(negativeNumbers == "")
          negativeNumbers = number;
        else
          negativeNumbers += ","+number;
    }  
    if(negativeNumbers != "")
      throw new ArithmeticException("Negatives not allowed:" + negativeNumbers);
  }

  private static boolean textContainsAnyOf(String text, String [] theseDelimiters){
    for(String delimiter : theseDelimiters){
      if(text.contains(delimiter))
        return true;
    }
    return false;
  }

  private static int ignoreOver1000(int numb){
    if(numb > 1000)
      return 0;
    else
      return numb;
  }
} 