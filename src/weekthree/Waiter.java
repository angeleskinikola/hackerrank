package weekthree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class WaiterResult {

  /*
   * Complete the 'waiter' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY number
   *  2. INTEGER q
   */

  public static List<Integer> waiter(List<Integer> number, int q) {
    // Write your code here
    List<Integer> answers = new ArrayList<>();
    List<Integer> primes = generateQPrimes(q);
    Stack<Integer> plates = getPlates(number);

    Stack<Integer> restPlates = new Stack<>();
    Stack<Integer> platesEvenlyDivisible = new Stack<>();
    for (int i = 0; i < q; i++) {
      if (i % 2 == 0) {
        while (!plates.isEmpty()) {
          int plateNumber = plates.pop();
          if (plateNumber % primes.get(i) == 0) {
            platesEvenlyDivisible.push(plateNumber);
          } else {
            restPlates.push(plateNumber);
          }
        }
      } else {
        while (!restPlates.isEmpty()) {
          int plateNumber = restPlates.pop();
          if (plateNumber % primes.get(i) == 0) {
            platesEvenlyDivisible.push(plateNumber);
          } else {
            plates.push(plateNumber);
          }
        }
      }
      while (!platesEvenlyDivisible.isEmpty()) {
        answers.add(platesEvenlyDivisible.pop());
      }
      if (i == q - 1) {
        while (!restPlates.isEmpty()) {
          answers.add(restPlates.pop());
        }
        while (!plates.isEmpty()) {
          answers.add(plates.pop());
        }
      }
    }
    return answers;
  }

  private static Stack<Integer> getPlates(List<Integer> numbers) {
    Stack<Integer> numberedPlates = new Stack<>();
    for (int n : numbers) {
      numberedPlates.push(n);
    }
    return numberedPlates;
  }

  private static List<Integer> generateQPrimes(int q) {
    int number = 2;
    List<Integer> primes = new ArrayList<>();
    while (primes.size() < q) {
      if (isPrime(number)) {
        primes.add(number);
      }
      number++;
    }
    return primes;
  }

  private static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
          return false;
        }
    }
    return true;
  }

}

public class Waiter {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int q = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = WaiterResult.waiter(number, q);

    System.out.println(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
  }
}