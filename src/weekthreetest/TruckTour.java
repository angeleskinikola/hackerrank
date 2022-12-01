package weekthreetest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class TruckTourResult {

  /*
   * Complete the 'truckTour' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
   */
  public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
    int numberOfPetrolPumps = petrolpumps.size();

    for (int start = 0; start < numberOfPetrolPumps; start++) {
      if(petrolpumps.get(start).get(0) >= petrolpumps.get(start).get(1)) {
        long tank = 0;
        int position = start;
        int pumpsPassed = 0;

        while (true) {
          if (pumpsPassed == numberOfPetrolPumps) {
            return start;
          } else {
            if (tank < 0) {
              break;
            } else {
              tank += petrolpumps.get(position).get(0) - petrolpumps.get(position).get(1);
              if (position == numberOfPetrolPumps - 1) {
                position = 0;
              } else {
                position++;
              }
              pumpsPassed++;
            }
          }
        }
      }
    }
    return -1;
  }
}

public class TruckTour {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> petrolpumps = new ArrayList<>();

    IntStream.range(0, n).forEach(i -> {
      try {
        petrolpumps.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = TruckTourResult.truckTour(petrolpumps);

    System.out.println(String.valueOf(result));

    bufferedReader.close();
  }
}

