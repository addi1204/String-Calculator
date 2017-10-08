package is.ru.stringcalculator;

public class Calculator {

  //static String baseDelimiters[] = {",", "\n"};
  
  public static int add(String text){
    String baseDelimiters[] = {",", "\n", "xxxx"};
    String splitString = ",|\n";


    if(text.equals("")){
      return 0;
    }

    if(text.startsWith("//")){  
      String firstLine = text.split("\n")[0];
      String newDelimiter = firstLine.substring(2);
      baseDelimiters[2] = newDelimiter;
      text = text.substring(text.indexOf("\n")+1);
      splitString += "|" + newDelimiter;
      //System.out.print(text);
    }

    if(textContainsAnyOf(text, baseDelimiters)){
      String numbers[] = text.split(splitString);
      return sum(numbers);
    }
    else{
      String singleSizeArr[] = new String[] {text};
      return sum(singleSizeArr);
    }
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