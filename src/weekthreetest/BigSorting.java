package weekthreetest;

import java.io.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BigSortingResult {

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here
    return unsorted.stream().sorted((s1, s2) -> {
      if (s1.length() > s2.length()) {
        return 1;
      } else {
        if (s1.length() < s2.length()) {
          return -1;
        } else {
          for (int i = 0; i < s1.length(); i++) {
            if ((int) s1.charAt(i) > (int) s2.charAt(i)) {
              return 1;
            } else {
              if ((int) s1.charAt(i) < (int) s2.charAt(i)) {
                return -1;
              }
            }
          }
        }
      }
      return 0;
    }).collect(toList());
  }

//  public static List<String> bigSorting(List<String> unsorted) {
//    // Write your code here
//    boolean sorted = false;
//    while (!sorted) {
//      sorted = true;
//      for (int i = 0; i < unsorted.size() - 1; i++) {
//        if (unsorted.get(i).length() > unsorted.get(i + 1).length()) {
//          swap(i, unsorted);
//          sorted = false;
//        } else {
//          if (unsorted.get(i).length() == unsorted.get(i + 1).length()) {
//            try {
//              if (Long.parseLong(unsorted.get(i)) > Long.parseLong(unsorted.get(i + 1))) {
//                swap(i, unsorted);
//                sorted = false;
//              }
//            } catch (Exception e) {
//              if (new BigInteger(unsorted.get(i)).compareTo(new BigInteger(unsorted.get(i + 1))) > 0) {
//                swap(i, unsorted);
//                sorted = false;
//              }
//            }
//          }
//        }
////        if (new BigInteger(unsorted.get(i)).compareTo(new BigInteger(unsorted.get(i + 1))) > 0) {
////          swap(i, unsorted);
////          sorted = false;
////        }
//      }
//    }
//    return unsorted;
//  }

  private static void swap(int position, List<String> list) {
    String temp = list.get(position);
    list.set(position, list.get(position + 1));
    list.set(position + 1, temp);
  }
}

public class BigSorting {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .collect(toList());

    List<String> result = BigSortingResult.bigSorting(unsorted);

    System.out.println(
        result.stream()
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
  }
}
