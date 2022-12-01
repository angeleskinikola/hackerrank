package weektwo;

import java.io.*;

class SumVsXorResult {

  /*
   * Complete the 'sumXor' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static long sumXor(long n) {
    // Write your code here
    if (n == 0) {
      return 1;
    }
    String bitString = Long.toBinaryString(n);
    long zeroCount = bitString.length() - bitString.replace("0", "").length();
    return (long) Math.pow(2, zeroCount);
  }

}

public class SumVsXor {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(bufferedReader.readLine().trim());

    long result = SumVsXorResult.sumXor(n);

    System.out.println(result);

    bufferedReader.close();
  }
}
