package weektwo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {

  public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
    int pairs = 0;
    Map<Integer, Integer> colorToNumberOfSocks = new HashMap<>();
    for (int color : ar) {
      if (colorToNumberOfSocks.containsKey(color)) {
        if (colorToNumberOfSocks.get(color) % 2 == 1) {
          pairs++;
        }
        int numberOfSocks = colorToNumberOfSocks.get(color) + 1;
        colorToNumberOfSocks.put(color, numberOfSocks);
      } else {
        colorToNumberOfSocks.put(color, 1);
      }
    }
    return pairs;
  }
}

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> ar = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arTemp[i]);
      ar.add(arItem);
    }

    int result = SalesByMatch.sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}

