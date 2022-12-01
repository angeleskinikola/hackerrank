package weekthree;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SherlockAndTheValidStringResult {

  /*
   * Complete the 'isValid' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String isValid(String s) {
    // Write your code here
    boolean isValid = true;
    Map<Character, Integer> charToAppearance = new HashMap<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (charToAppearance.containsKey(c)) {
        charToAppearance.put(c, charToAppearance.get(c) + 1);
      } else {
        charToAppearance.put(c, 1);
      }
    }
    int[] appearances = new int[charToAppearance.size()];
    int i = 0;
    for (Character c : charToAppearance.keySet()) {
      appearances[i++] = charToAppearance.get(c);
    }
    Arrays.sort(appearances);
    int first = appearances[0];
    int second = appearances[1];
    int last = appearances[appearances.length - 1];
    int secondLast = appearances[appearances.length - 2];

    // if first == last then all appearances are with same frequency
    if (first == last) {
      return "YES";
    } else {
      if (first == 1 && second == last) {
        return "YES";
      } else {
        if (first == second && second == secondLast && secondLast == (last - 1)) {
          return "YES";
        } else {
          return "NO";
        }
      }
    }

  }

}

public class SherlockAndTheValidString {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String s = bufferedReader.readLine();

    String result = SherlockAndTheValidStringResult.isValid(s);

    System.out.println(result);

    bufferedReader.close();
  }
}