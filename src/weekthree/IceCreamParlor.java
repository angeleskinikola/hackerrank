package weekthree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class IceCreamParlorResult {

  /*
   * Complete the 'icecreamParlor' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER m
   *  2. INTEGER_ARRAY arr
   */

  public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    // Write your code here
    for (int i = 0; i < arr.size() - 1; i++) {
      for (int j = i + 1; j < arr.size(); j++) {
        if (arr.get(i) + arr.get(j) == m) {
          return List.of(i + 1, j + 1);
        }
      }
    }
    return new ArrayList<>();
  }

}

public class IceCreamParlor {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = IceCreamParlorResult.icecreamParlor(m, arr);

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

