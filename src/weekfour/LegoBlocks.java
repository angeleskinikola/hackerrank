package weekfour;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class LegoBlocksResult {

  /*
   * Complete the 'legoBlocks' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   */

  public static int legoBlocks(int n, int m) {
    // Write your code here
    // needed to avoid int overflow
    int modulo = 1000000007;

    // max height and width of the wall
    int maxn = 1000;

    // initialize a matrix and two vectors of the max dimension
    List<List<Long>> t = new ArrayList<>();
    List<Long> b = new ArrayList<>();
    List<Long> g = new ArrayList<>();
    return 0;
  }

}

public class LegoBlocks {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = LegoBlocksResult.legoBlocks(n, m);

        System.out.println(String.valueOf(result));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
