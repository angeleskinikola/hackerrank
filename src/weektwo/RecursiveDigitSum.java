package weektwo;

import java.io.*;

class ResultRecursiveDigitSum {

  /*
   * Complete the 'superDigit' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING n
   *  2. INTEGER k
   */

  public static int superDigit(String n, int k) {
    // Write your code here
    long superDigit = 0;
    char[] numbers = n.toCharArray();
    for (char c : numbers) {
      superDigit += k * Long.parseLong(String.valueOf(c));
    }
    return (int) superDigit(superDigit);
  }

  private static long superDigit(long n) {
    if (n < 10) {
      return n;
    }
    int superDigit = 0;
    while (n > 0) {
      superDigit += n % 10;
      n = n / 10;
    }
    return superDigit(superDigit);
  }

}

public class RecursiveDigitSum {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    String n = firstMultipleInput[0];

    int k = Integer.parseInt(firstMultipleInput[1]);

    int result = ResultRecursiveDigitSum.superDigit(n, k);
    System.out.println(result);

    bufferedReader.close();
  }
}
