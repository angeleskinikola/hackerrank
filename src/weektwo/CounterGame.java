package weektwo;

import java.io.*;
import java.util.stream.IntStream;

class CounterGameResult {

  /*
   * Complete the 'counterGame' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts LONG_INTEGER n as parameter.
   */
  private static int turn = 0;
  public static String counterGame(long n) {
    turn++;
    // Write your code here
    if (n == 1) {
      if (turn % 2 != 0) {
        turn = 0;
        return "Richard";
      }
      turn = 0;
      return "Louise";
    }

    double res = Math.log(n) / Math.log(2);
    if (Math.pow(2, (int) res) == n) {
      return counterGame(n / 2);
    } else {
      long resInt = (long) res;
      return counterGame((long) (n - Math.pow(2, resInt)));
    }
  }

}

public class CounterGame {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        long n = Long.parseLong(bufferedReader.readLine().trim());

        String result = CounterGameResult.counterGame(n);
        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
