package weekfour;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MaximumSubarrayResult {

  /*
   * Complete the 'maxSubarray' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> maxSubarray(List<Integer> arr) {
    // Write your code here
    int maxSubArraySum = arr.get(0); // sets first element to be max subarray sum
    int maxSubsequenceSum = arr.get(0); // sets first element as max subsequence sum
    int max = arr.get(0); // sets first element as max

    for (int i = 1; i < arr.size(); i++) { // iterates to last element
      max = Math.max(max + arr.get(i), arr.get(i)); // sets max to be the bigger of:
      //              1. current element
      //              2. max + current element

      maxSubArraySum = Math.max(maxSubArraySum, max); // sets max to be the bigger of:
      //            1. current maximum subarray sum
      //            2. max

      maxSubsequenceSum = Math.max(                                       // sets max subsequence sum to be the bigger of:
          Math.max(maxSubsequenceSum, arr.get(i)),  //              1. The bigger of:
          maxSubsequenceSum + arr.get(i));          //                      1.1. maximum subsequence sum
    }                                               //                      1.2. current element
                                                    //              2. Maximum subsequence sum + current element
    return List.of(maxSubArraySum, maxSubsequenceSum);
  }

  public static List<Integer> maxSubarray2(List<Integer> arr) { // -2, -3, -1, -4, -6
    int currentSubarraySum = 0;
    int maxSubarraySum = Integer.MIN_VALUE;
    int maxSubSequencesSum = 0;

    for (int element : arr) {
      currentSubarraySum += element;

      if (currentSubarraySum > maxSubarraySum) {
        maxSubarraySum = currentSubarraySum;
      }

      if (currentSubarraySum < 0) {
        currentSubarraySum = 0;
      }
      if (element > 0) {
        maxSubSequencesSum += element;
      }
    }

    if (maxSubSequencesSum == 0) {
      maxSubSequencesSum = arr.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    List<Integer> sums = new ArrayList<>();
    sums.add(maxSubarraySum);
    sums.add(maxSubSequencesSum);
    return sums;
  }
}

public class MaximumSubarray {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = MaximumSubarrayResult.maxSubarray2(arr);

        System.out.println(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
                + "\n"
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
