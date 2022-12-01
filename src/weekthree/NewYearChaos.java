package weekthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class NewYearChaosResult {

  /*
   * Complete the 'minimumBribes' function below.
   *
   * The function accepts INTEGER_ARRAY q as parameter.
   */

  public static void minimumBribes(List<Integer> q) {
    // Write your code here
    int minBribes = 0;
    for (int i = 0; i < q.size(); i++) {
      if (q.get(i) - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
    }
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int j = 0; j < q.size() - 1; j++) {
        if (q.get(j) > q.get(j + 1)) {
          sorted = false;
          int temp = q.get(j);
          q.set(j, q.get(j + 1));
          q.set(j + 1, temp);
          minBribes++;
        }
      }
    }
    System.out.println(minBribes);
  }

}

public class NewYearChaos {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        NewYearChaosResult.minimumBribes(q);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
