package weekthree;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class SinglyLinkedListNode1 {
  public int data;
  public SinglyLinkedListNode1 next;

  public SinglyLinkedListNode1(int nodeData) {
    this.data = nodeData;
    this.next = null;
  }
}

class SinglyLinkedList1 {
  public SinglyLinkedListNode1 head;
  public SinglyLinkedListNode1 tail;

  public SinglyLinkedList1() {
    this.head = null;
    this.tail = null;
  }

  public void insertNode(int nodeData) {
    SinglyLinkedListNode1 node = new SinglyLinkedListNode1(nodeData);

    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
    }

    this.tail = node;
  }
}

class SinglyLinkedListPrintHelper1 {
  public static void printList(SinglyLinkedListNode1 node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }
}

class Result {

  /*
   * Complete the 'reverse' function below.
   *
   * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
   * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
   */

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */

  public static SinglyLinkedListNode1 reverse(SinglyLinkedListNode1 llist) {
    // Write your code here
    SinglyLinkedListNode1 previous = null;
    SinglyLinkedListNode1 current = llist;
    SinglyLinkedListNode1 next = llist.next;
    SinglyLinkedListNode1 rest = next.next;
    while (next != null) {
      current.next = previous;
      previous = current;
      next.next = current;
      current = next;
      next = rest;
      if (rest != null) {
        rest = rest.next;
      }

    }
    return current;
  }

}

public class ReverseALinkedList {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int tests = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, tests).forEach(testsItr -> {
      try {
        SinglyLinkedList1 llist = new SinglyLinkedList1();

        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
          try {
            int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

            llist.insertNode(llistItem);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        SinglyLinkedListNode1 llist1 = Result.reverse(llist.head);

        System.out.println(llist1);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
