package weekthree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class DoublyLinkedListNode {
  public int data;
  public DoublyLinkedListNode next;
  public DoublyLinkedListNode prev;

  public DoublyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
    this.prev = null;
  }
}

class DoublyLinkedList {
  public DoublyLinkedListNode head;
  public DoublyLinkedListNode tail;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void insertNode(int nodeData) {
    DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
    }

    this.tail = node;
  }
}

class DoublyLinkedListPrintHelper {
  public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }
}

class ReverseDoubleLinkedListResult {

  /*
   * Complete the 'reverse' function below.
   *
   * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
   * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
   */

  /*
   * For your reference:
   *
   * DoublyLinkedListNode {
   *     int data;
   *     DoublyLinkedListNode next;
   *     DoublyLinkedListNode prev;
   * }
   *
   */

  public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
    // Write your code here
    // 1. previous = null        ******* current.next = previous
    //    current = 1            ******* current.previous = next
    //    next = 2               ******* previous = current, current = next, next = next.next

    DoublyLinkedListNode previous = llist.prev;
    DoublyLinkedListNode current = llist;
    DoublyLinkedListNode next = llist.next;

    while (true) {
      current.next = previous;
      current.prev = next;

      previous = current;
      if (next != null) {
        current = next;
        next = next.next;
      } else {
        return current;
      }
    }
  }

}

public class ReverseDoubleLinkedList {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        DoublyLinkedList llist = new DoublyLinkedList();

        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
          try {
            int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

            llist.insertNode(llistItem);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        DoublyLinkedListNode llist1 = ReverseDoubleLinkedListResult.reverse(llist.head);

      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
