package weektwotest.anagram;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

class Result {

  /*
   * Complete the 'anagram' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int anagram(String s) {
    // Write your code here
    if (s.length() % 2 != 0 || s.length() == 0) {
      return -1;
    }
    String firstHalf = s.substring(0, s.length() / 2);
    String secondHalf = s.substring(s.length() / 2);
    StringBuilder firstHalfStringBuilder = new StringBuilder(firstHalf);
    StringBuilder secondHalfStringBuilder = new StringBuilder(secondHalf);
    int differenceCount = 0;
    for (int i = 0; i < firstHalf.length(); i++) {
      int indexInSecondHalf = secondHalf.indexOf(firstHalfStringBuilder.charAt(i));
      if (indexInSecondHalf == -1) {
        differenceCount++;
        continue;
      }
      secondHalfStringBuilder.deleteCharAt(indexInSecondHalf);
      secondHalf = secondHalfStringBuilder.toString();
    }
    return differenceCount;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s = bufferedReader.readLine();

        int result = Result.anagram(s);

        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
