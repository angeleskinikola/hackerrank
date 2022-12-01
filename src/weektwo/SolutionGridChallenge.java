package weektwo;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class GridChallenge {

  /*
   * Complete the 'gridChallenge' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING_ARRAY grid as parameter.
   */

  public static String gridChallenge(List<String> grid) {
    // Write your code here
    sortGrid(grid);

    boolean areColumnsInAscendingOrder = checkColumnsInAscendingOrder(grid);

    return areColumnsInAscendingOrder ? "YES" : "NO";
  }

  private static void sortGrid(List<String> grid) {
    for (int i = 0; i < grid.size(); i++) {
      String row = grid.get(i);
      char[] chars = row.toCharArray();
      Arrays.sort(chars);
      StringBuilder sb = new StringBuilder();
      for (char c : chars) {
        sb.append(c);
      }
      row = sb.toString();
      grid.set(i, row);
    }
  }

  private static boolean checkColumnsInAscendingOrder(List<String> grid) {
    for (int i = 0; i < grid.get(0).length(); i++) {
      StringBuilder column = new StringBuilder();
      for (int j = 0; j < grid.size(); j++) {
        column.append(grid.get(j).charAt(i));
      }
      char[] columnChars = column.toString().toCharArray();
      Arrays.sort(columnChars);
      StringBuilder sortedColumn = new StringBuilder();
      for (char c: columnChars) {
        sortedColumn.append(c);
      }
      if (!column.toString().equals(sortedColumn.toString())) {
        return false;
      }
    }
    return true;
  }
}

public class SolutionGridChallenge {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
              try {
                return bufferedReader.readLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .collect(toList());

        String result = GridChallenge.gridChallenge(grid);

        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
