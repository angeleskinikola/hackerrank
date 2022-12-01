package weekthree;

import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;
class BalancedBracketsResult {

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

  public static String isBalanced(String s) {
    // Write your code here
    char[] brackets = s.toCharArray();
    Stack<Character> openBrackets = new Stack<>();
    for (char c : brackets) {
      if (c == '{' || c == '[' || c == '(') {
        openBrackets.push(c);
      } else {
        if (c == '}' && (openBrackets.isEmpty() || openBrackets.pop() != '{')) {
          return "NO";
        } else {
          if (c == ']' && (openBrackets.isEmpty() || openBrackets.pop() != '[')) {
            return "NO";
          } else {
            if (c == ')' && (openBrackets.isEmpty() || openBrackets.pop() != '(')) {
              return "NO";
            }
          }
        }
      }
    }
    if (openBrackets.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }
  }

}

public class BalancedBrackets {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        String s = bufferedReader.readLine();

        String result = BalancedBracketsResult.isBalanced(s);

        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
