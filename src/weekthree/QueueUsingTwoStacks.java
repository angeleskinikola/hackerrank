package weekthree;

import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueUsingTwoStacks {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfQueries = scanner.nextInt();
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    while (numberOfQueries-- > 0) {
      int query = scanner.nextInt();
      switch (query) {
        case 1:
          // enqueue
          int element = scanner.nextInt();
          input.push(element);
          break;
        case 2:
          // dequeue front element
          if (output.isEmpty()) {
            while (!input.isEmpty()) {
              output.push(input.pop());
            }
          }
          output.pop();
          break;
        case 3:
          // print front element
          if (output.isEmpty()) {
            while (!input.isEmpty()) {
              output.push(input.pop());
            }
          }
          System.out.println(output.peek());
          break;
      }
    }
    scanner.close();
  }
}
