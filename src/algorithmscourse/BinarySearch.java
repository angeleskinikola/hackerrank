package algorithmscourse;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

public class BinarySearch {
  static int count = 0;
  public static void main(String[] args) {
    int[] intArray = { -32, -6, -3, 3, 4, 25, 67, 88, 754, 1000 };
    System.out.println(recursiveBinarySearch(intArray, 67));
    
  }

  public static int iterativeBinarySearch(int[] input, int value) {
    int start = 0;
    int end = input.length;

    while (start < end) {
      int midpoint = (start + end) / 2;
      System.out.println(midpoint);
      if (input[midpoint] == value) {
        return midpoint;
      } else if (input[midpoint] < value) {
        start = midpoint + 1;
      } else {
        end = midpoint;
      }
    }
    return -1;
  }

  public static int recursiveBinarySearch(int[] input, int value) {
    return recursiveBinarySearch(input, 0, input.length, value);
  }

  public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
    if (start >= end) {
      return -1;
    }
    int midpoint = (start + end) / 2;

    if (input[midpoint] == value) {
      return midpoint;
    } else if (input[midpoint] < value) {
      return recursiveBinarySearch(input, midpoint + 1, end, value);
    } else  {
      return recursiveBinarySearch(input, start, midpoint, value);
    }
  }
}
