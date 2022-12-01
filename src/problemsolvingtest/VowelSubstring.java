package problemsolvingtest;

import java.io.*;
import java.util.LinkedList;

class VowelSubstringResult {

  /*
   * Complete the 'findSubstring' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER k
   */

  public static String findSubstring(String s, int k) {
    // Write your code here
//    String substringBuilder = "Not found!";
    StringBuilder substringBuilder = new StringBuilder();
    int vowelCount = 0;
    int tempVowelCount = 0;

    String substring = "Not found!";
    for (int i = 0; i < s.length(); i++) {
      if (substringBuilder.length() == k) {
        if (isVowel(substringBuilder.charAt(0))) {
          tempVowelCount--;
        }
        substringBuilder.deleteCharAt(0);
      }
      substringBuilder.append(s.charAt(i));
      if (isVowel(s.charAt(i))) {
        tempVowelCount++;
      }
      if (tempVowelCount > vowelCount) {
        vowelCount = tempVowelCount;
        substring = substringBuilder.toString();
      }
      if (tempVowelCount != 0 && tempVowelCount == vowelCount && substring.length() < substringBuilder.length()) {
        substring = substringBuilder.toString();
      }
    }
    return substring;
  }

  private static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}

public class VowelSubstring {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String s = bufferedReader.readLine();

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    String result = VowelSubstringResult.findSubstring(s, k);
    System.out.println(result);

    bufferedReader.close();
  }
}
