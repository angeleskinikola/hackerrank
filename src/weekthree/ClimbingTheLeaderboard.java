package weekthree;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class ClimbingTheLeaderboardResult {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
    List<Integer> playerRanks = new ArrayList<>(player.size());

    ranked = ranked.stream().distinct().collect(toList());

    int i = ranked.size() - 1;
    for (int p : player) {

      while (i >= 0) {
        if (p < ranked.get(i)) {
          playerRanks.add(i + 2);
          break;
        }
        i--;
      }
      if (i < 0) {
        playerRanks.add(1);
      }
    }
    return playerRanks;
  }


}

public class ClimbingTheLeaderboard {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = ClimbingTheLeaderboardResult.climbingLeaderboard(ranked, player);

    System.out.println(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
  }
}
