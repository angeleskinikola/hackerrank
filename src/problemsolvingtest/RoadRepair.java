package problemsolvingtest;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class RoadRepairResult {

  /*
   * Complete the 'getMinCost' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY crew_id
   *  2. INTEGER_ARRAY job_id
   */

  public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
    // Write your code here
    crew_id = crew_id.stream().sorted().collect(toList());
    job_id = job_id.stream().sorted().collect(toList());
    long sum = 0;
    for (int i = 0; i < crew_id.size(); i ++) {
      sum += Math.abs(crew_id.get(i) - job_id.get(i));
    }
    return sum;
  }

}

public class RoadRepair {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int crew_idCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> crew_id = IntStream.range(0, crew_idCount).mapToObj(i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> job_id = IntStream.range(0, job_idCount).mapToObj(i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    long result = RoadRepairResult.getMinCost(crew_id, job_id);
    System.out.println(result);

    bufferedReader.close();
  }
}
