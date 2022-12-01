package weektwotest.betweentwosets;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'getTotalX' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    int count = 0;
    a = a.stream().sorted().collect(toList());
    b = b.stream().sorted().collect(toList());
    int maxInFirstArray = a.get(a.size() - 1);
    int minInSecondArray = b.get(0);
    for (int i = maxInFirstArray; i <= minInSecondArray; i++) {
      boolean factor = true;
      for (int j : a) {
        if (i % j != 0) {
          factor = false;
          break;
        }
      }
      if (!factor) {
        continue;
      }
      for (int j : b) {
        if (j % i != 0) {
          factor = false;
          break;
        }
      }
      if (factor) {
        count++;
      }
    }
    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int total = Result.getTotalX(arr, brr);

    System.out.println(total);

    bufferedReader.close();
  }
}
