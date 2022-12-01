package weektwo;

import java.io.*;

public class DrawingBook {
  /*
   * Complete the 'pageCount' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER p
   */

  public static int pageCount(int n, int p) {
    // Write your code here
    if (n == p || p == 1) {
      return 0;
    }
    if (n - p == 1 && n % 2 == 0) {
      return 1;
    }
    int frontTurns = p / 2;
    int backTurns = (n - p) / 2;

    return Math.min(frontTurns, backTurns);
  }
}

class Solution1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int p = Integer.parseInt(bufferedReader.readLine().trim());

    int result = DrawingBook.pageCount(n, p);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
    System.out.println(result);

    bufferedReader.close();
  }
}
