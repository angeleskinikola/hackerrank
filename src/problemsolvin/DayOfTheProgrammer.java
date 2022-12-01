package problemsolvin;

import java.io.*;

class DayOfTheProgrammerResult {

  /*
   * Complete the 'dayOfProgrammer' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER year as parameter.
   */

  public static String dayOfProgrammer(int year) {
    // Write your code here
    String separator = ".";
    if (year >= 1700 && year <= 1917) {
      String day = "";
      String month = "09";
      String y = String.valueOf(year);
      if (isJulianLeap(year)) {
        day = "12";
      } else {
        day = "13";
      }
      return day + separator + month + separator + y;
    } else if (year == 1918) {
      return "26.09.1918";
    } else if (year > 198 && year <= 2700) {
      String day = "";
      String month = "09";
      String y = String.valueOf(year);
      if (isGregorianLeap(year)) {
        day = "12";
      } else {
        day = "13";
      }
      return day + separator + month + separator + y;
    }
    return "";
  }

  private static boolean isJulianLeap(int year) {
    return year % 4 == 0;
  }

  private static boolean isGregorianLeap(int year) {
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        if (year % 400 == 0) {
          return true;
        }
        return false;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }
}

public class DayOfTheProgrammer {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int year = Integer.parseInt(bufferedReader.readLine().trim());

    String result = DayOfTheProgrammerResult.dayOfProgrammer(year);
    System.out.println(result);

    bufferedReader.close();
  }
}
