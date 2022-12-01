package problemsolvin;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class SubarrayDivisionResult {

  /*
   * Complete the 'birthday' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY s
   *  2. INTEGER d
   *  3. INTEGER m
   */

  public static int birthday(List<Integer> s, int d, int m) {
    // Write your code here
    int ways = 0;
    if (s.size() == m) {
      int integerSum = 0;
      for (int i : s) {
        integerSum += i;
      }
      if (integerSum == d) {
        return 1;
      } else {
        return 0;
      }
    }
    for (int i = 0; i <= s.size() - m; i++) {
      int integersSum = 0;
      for (int j = i; j < i + m; j++) {
        integersSum += s.get(j);
      }
      if (integersSum == d) {
        ways++;
      }
    }
    return ways;
  }

}

public class SubarrayDivision {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int d = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    int result = SubarrayDivisionResult.birthday(s, d, m);
    System.out.println(result);

    bufferedReader.close();
  }
}
