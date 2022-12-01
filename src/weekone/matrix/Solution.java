package weekone.matrix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'flippingMatrix' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
   */

  public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
    // loop from 0 to matrix.size / 2
    int sum = 0;
    int current, right, down, diagonal, maximal;
    int matrixSize = matrix.size();
    int rowSize = matrix.get(0).size();
    for (int i = 0; i < matrix.size() / 2; i++) {
      for (int j = 0; j < matrix.get(i).size() / 2; j++) {
        current = matrix.get(i).get(j);
        right = matrix.get(i).get(rowSize - j -1);
        down = matrix.get(rowSize - i - 1).get(j);
        diagonal = matrix.get(matrixSize - i - 1).get(rowSize - j - 1);
        maximal = Stream.of(current, right, down, diagonal).max((a, b) -> {
          if (a > b) {
            return 1;
          } else if (a == b) {
            return 0;
          }
          return -1;
        }).get();
        sum += maximal;
      }
    }
    return sum;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, 2 * n).forEach(i -> {
          try {
            matrix.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        int result = Result.flippingMatrix(matrix);

        System.out.println(String.valueOf(result));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
