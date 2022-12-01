package weekthreetest;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'pairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY arr
   */

  public static int pairs(int k, List<Integer> arr) {
    // Write your code here
    arr = arr.stream().sorted().collect(toList());
    int count = 0;
    for (int i = arr.size() - 1; i > 0; i--) {
      int x = arr.get(i);
      for (int j = i - 1; j >= 0; j--) {
        int y = arr.get(j);
        if (x - y == k) {
          count++;
        } else {
          if (x - y > k) {
            break;
          }
        }
      }
    }
    return count;
  }

}

public class Pairs {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.pairs(k, arr);

    System.out.println(String.valueOf(result));

    bufferedReader.close();
  }
}
