package weekfour;

import java.io.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'equalStacks' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h1
   *  2. INTEGER_ARRAY h2
   *  3. INTEGER_ARRAY h3
   */

  public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    Stack<Integer> s1 = getStackFromList(h1);
    Stack<Integer> s2 = getStackFromList(h2);
    Stack<Integer> s3 = getStackFromList(h3);

    long s1Sum = getSum(h1);
    long s2Sum = getSum(h2);
    long s3Sum = getSum(h3);

    long currentMinSum = Math.min(Math.min(s1Sum, s2Sum), s3Sum);
    boolean shouldIterate = true;
    while (shouldIterate) {
      if (s1Sum == s2Sum && s2Sum == s3Sum) {
        return (int) s1Sum;
      }
      if (s1Sum > currentMinSum) {
        if (s1.isEmpty()) {
          return 0;
        }
        s1Sum -= s1.pop();
      }
      if (s2Sum > currentMinSum) {
        if (s2.isEmpty()) {
          return 0;
        }
        s2Sum -= s2.pop();
      }
      if (s3Sum > currentMinSum) {
        if (s3.isEmpty()) {
          return 0;
        }
        s3Sum -= s3.pop();
      }
      currentMinSum = Math.min(Math.min(s1Sum, s2Sum), s3Sum);

    }

    return -1;
  }

  private static long getSum(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).sum();
  }

  private static Stack<Integer> getStackFromList(List<Integer> list) {
    Stack<Integer> stack = new Stack<>();
    for (int i = list.size() - 1; i >= 0; i--) {
      stack.push(list.get(i));
    }
    return stack;
  }
}

public class EqualStacks {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n1 = Integer.parseInt(firstMultipleInput[0]);

    int n2 = Integer.parseInt(firstMultipleInput[1]);

    int n3 = Integer.parseInt(firstMultipleInput[2]);

    List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.equalStacks(h1, h2, h3);

    System.out.println(String.valueOf(result));

    bufferedReader.close();
  }
}
