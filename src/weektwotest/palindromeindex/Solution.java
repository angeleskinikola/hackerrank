package weektwotest.palindromeindex;

import java.io.*;
import java.util.stream.IntStream;

class Result {

  /*
   * Complete the 'palindromeIndex' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int palindromeIndex(String s) {
    // Write your code here
    if (isPalindrome(s)) {
      return -1;
    }

    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length() / 2; i++) {
      if (sb.charAt(i) != sb.charAt(s.length() - i - 1)) {
        if (isPalindrome(new StringBuilder(s).deleteCharAt(i).toString())) {
          return i;
        } else if (isPalindrome(new StringBuilder(s).deleteCharAt(s.length() - i - 1).toString())) {
          return s.length() - i - 1;
        }
      }
    }
    return -1;
  }

  private static boolean isPalindrome(String s) {
    StringBuilder stringBuilder = new StringBuilder(s);
    String reverse = stringBuilder.reverse().toString();
    return reverse.equals(s);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s = bufferedReader.readLine();

        int result = Result.palindromeIndex(s);

        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}