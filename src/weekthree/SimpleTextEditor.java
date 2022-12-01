package weekthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class SimpleTextEditor {

  private static String text = "";
  private static Stack<String> previousOperations = new Stack<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int numberOfQueries = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, numberOfQueries).forEach(tItr -> {
      try {
        String operation = bufferedReader.readLine();

        switch (operation.charAt(0)) {
          case '1':
            append(operation.substring(2), false);
            break;
          case '2':
            delete(Integer.parseInt(operation.substring(2)), false);
            break;
          case '3':
            printCharacter(Integer.parseInt(operation.substring(2)));
            break;
          case '4':
            undo();
            break;
        }
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    bufferedReader.close();
  }

  private static void append(String textToAppend, boolean isUndoOperation) {
    if (!isUndoOperation) {
      previousOperations.push("1" + textToAppend);
    }
    text += textToAppend;
  }

  private static void delete(int length, boolean isUndoOperation) {
    if (!isUndoOperation) {
      previousOperations.push("2" + text.substring(text.length() - length));
    }
    text = text.substring(0, text.length() - length);
  }

  private static void printCharacter(int position) {
    System.out.println(text.charAt(position - 1));
  }

  private static void undo() {
    String undo = previousOperations.pop();

    if (undo.charAt(0) == '1') {
      delete(undo.substring(1).length(), true);
    } else if (undo.charAt(0) == '2') {
      append(undo.substring(1), true);
    }
  }
}