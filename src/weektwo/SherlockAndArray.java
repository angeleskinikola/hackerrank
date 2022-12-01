package weektwo;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SherlockAndArray {

  /*
   * Complete the 'balancedSums' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static String balancedSums(List<Integer> arr) {
    // Write your code here
    int leftSum = 0;
    int rightSum = 0;
    if (arr.size() == 1) {
      return "YES";
    }
    for (int i = 0; i < arr.size(); i++) {
      rightSum += arr.get(i);
    }
    for (int i = 0; i < arr.size(); i++) { // i = 0
      leftSum += arr.get(i - 1);
      rightSum -= arr.get(i);
      if (leftSum == rightSum) {
        return "YES";
      }
    }
    return "NO";
  }

}

class SolutionSherlockAndArray {
  public static void main(String[] args) throws IOException {

    System.out.println(SherlockAndArray.balancedSums(List.of(1, 2, 3, 3)));
  }
}

