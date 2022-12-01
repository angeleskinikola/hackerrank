package weektwo;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result1 {

  /*
   * Complete the 'maxMin' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY arr
   */

  public static int maxMin(int k, List<Integer> arr) {
    // Write your code here
    arr = arr.stream().sorted().collect(toList());
    Map<Integer, Integer> subArrStartIndexToDiff = new HashMap<>();
    for (int i = 0; i <= arr.size() - k; i++) {
      subArrStartIndexToDiff.put(i, arr.get(i + k - 1) - arr.get(i));
    }
    int min = subArrStartIndexToDiff.get(0);
    for (int i : subArrStartIndexToDiff.keySet()) {
      if (subArrStartIndexToDiff.get(i) < min) {
        min = subArrStartIndexToDiff.get(i);
      }
    }
    return min;
  }

}

public class MaxMin {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result1.maxMin(k, arr);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
    System.out.println(result);

    bufferedReader.close();
  }
}
