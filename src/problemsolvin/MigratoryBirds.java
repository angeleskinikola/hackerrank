package problemsolvin;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MigratoryBirdsResult {

  /*
   * Complete the 'migratoryBirds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    int[] birdsFrequencies = new int[6];

    for (int birdId : arr) {
      birdsFrequencies[birdId] = birdsFrequencies[birdId] + 1;
    }
    int maxFrequencyBirdId = 5;
    int maxFrequency = birdsFrequencies[maxFrequencyBirdId];
    for (int birdId = 4; birdId > 0; birdId--) {
      if (birdsFrequencies[birdId] >= maxFrequency) {
        maxFrequency = birdsFrequencies[birdId];
        maxFrequencyBirdId = birdId;
      }
    }
    return maxFrequencyBirdId;
  }

}

public class MigratoryBirds {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = MigratoryBirdsResult.migratoryBirds(arr);

    System.out.println(result);

    bufferedReader.close();
  }
}

