package weekthree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Bomb {
  private int count = 3;


  public int getCount() {
    return count;
  }

  public void decreaseCount() {
    if (count > 0) {
      count--;
    } else {
      throw new RuntimeException("Count can not be less than 0");
    }
  }

  public boolean isDetonated() {
    return count == 0;
  }
}

class Grid {
  private List<List<Bomb>> grid;

  public void decreaseBombSeconds() {
    for (List<Bomb> row : grid) {
      for (Bomb b : row) {
        if (b != null) {
          b.decreaseCount();
        }
      }
    }
  }

  public void detonateBombs() {
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid.get(i).size(); j++) {

      }
    }
  }
}
class BombermanGameResult {

  /*
   * Complete the 'bomberMan' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. STRING_ARRAY grid
   */

  public static List<String> bomberMan(int n, List<String> grid) {
    // Write your code here
    if (n % 2 == 0) {
      int size = grid.get(0).length();
      StringBuilder s = new StringBuilder();
      for (int i = 0; i < size; i++) {
        s.append("O");
      }
      List<String> res = new ArrayList<>();
      for (int i = 0; i < grid.size(); i++) {
        res.add(s.toString());
      }
      return res;
    }
    List<String> secondGridState = getNextGrid(grid);
    List<String> thirdGridState = getNextGrid(secondGridState);

    if ((n - 3) % 4 == 0) {
      return secondGridState;
    } else {
      if ((n - 1) % 4 == 0) {
        return thirdGridState;
      }
    }

    return grid;
  }

  private static List<String> getNextGrid(List<String> grid) {
    List<String> nextGridState = new ArrayList<>();
    for (int i = 0; i < grid.size(); i++) {
      StringBuilder nextRow = new StringBuilder();
      for (int j = 0; j < grid.get(i).length(); j++) {
        if (grid.get(i).charAt(j) == 'O') {
          nextRow.append(".");
        } else {
          if (j - 1 >= 0 && grid.get(i).charAt(j - 1) == 'O') {
            nextRow.append(".");
          } else {
            if (j + 1 < grid.get(i).length() && grid.get(i).charAt(j + 1) == 'O') {
              nextRow.append(".");
            } else {
              if (i + 1 < grid.size() && grid.get(i + 1).charAt(j) == 'O') {
                nextRow.append(".");
              } else {
                if (i - 1 >= 0 && grid.get(i - 1).charAt(j) == 'O') {
                  nextRow.append(".");
                } else {
                  nextRow.append("O");
                }
              }
            }
          }
        }
      }
      nextGridState.add(nextRow.toString());
    }
    return nextGridState;
  }
}

class BombIndex {
  private int i;
  private int j;

  public BombIndex(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public int getJ() {
    return j;
  }

  public void setJ(int j) {
    this.j = j;
  }
}

public class BombermanGame {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int r = Integer.parseInt(firstMultipleInput[0]);

    int c = Integer.parseInt(firstMultipleInput[1]);

    int n = Integer.parseInt(firstMultipleInput[2]);

    List<String> grid = IntStream.range(0, r).mapToObj(i -> {
          try {
            return bufferedReader.readLine();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .collect(toList());

    List<String> result = BombermanGameResult.bomberMan(n, grid);

    for (String res : result) {
      System.out.println(res);
    }

    bufferedReader.close();
  }
}
