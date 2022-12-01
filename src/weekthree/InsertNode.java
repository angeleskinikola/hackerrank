package weekthree;

import java.io.*;
import java.util.stream.IntStream;

class SinglyLinkedListNode {
  public int data;
  public SinglyLinkedListNode1 next;

  public SinglyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
  }
}

class SinglyLinkedList {
  public SinglyLinkedListNode1 head;
  public SinglyLinkedListNode1 tail;

  public SinglyLinkedList() {
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

class SinglyLinkedListPrintHelper {
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

class InsertNodeResult {

  /*
   * Complete the 'insertNodeAtPosition' function below.
   *
   * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
   * The function accepts following parameters:
   *  1. INTEGER_SINGLY_LINKED_LIST llist
   *  2. INTEGER data
   *  3. INTEGER position
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

  public static SinglyLinkedListNode1 insertNodeAtPosition(SinglyLinkedListNode1 llist, int data, int position) {
    // Write your code here
    // 1 -> 2 -> 3 -> null
    SinglyLinkedListNode1 nodeToInsert = new SinglyLinkedListNode1(data);
    if (position == 0) {
      nodeToInsert.next = llist;
      return nodeToInsert;
    }
    SinglyLinkedListNode1 current = llist;
    while (position-- > 1) {
      current = current.next;
    }
    nodeToInsert.next = current.next;
    current.next = nodeToInsert;
    return llist;
  }

}

public class InsertNode {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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

    int data = Integer.parseInt(bufferedReader.readLine().trim());

    int position = Integer.parseInt(bufferedReader.readLine().trim());

    SinglyLinkedListNode1 llist_head = InsertNodeResult.insertNodeAtPosition(llist.head, data, position);

    bufferedReader.close();
  }
}
