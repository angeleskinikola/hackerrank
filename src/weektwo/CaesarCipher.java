package weektwo;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CaesarCipher {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String s = bufferedReader.readLine();

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    String result = Cipher.caesarCipher(s, k);

    System.out.println(result);

    bufferedReader.close();
  }
}

class Cipher {

  private static List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
  public static String caesarCipher(String s, int k) {
    // Write your code here
    char[] chars = s.toCharArray();
    char[] encryptedChars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == ' ') {
        encryptedChars[i] = c;
      } else {
        encryptedChars[i] = encryptChar(c, k);
      }
    }
    StringBuilder encryptedSB = new StringBuilder();
    for (char c : encryptedChars) {
      encryptedSB.append(c);
    }
    return encryptedSB.toString();
  }

  private static char encryptChar(char c, int factor) {
    int indexOfChar = alphabet.indexOf(c);
    boolean isUpperCase = false;
    if (indexOfChar == -1) {
      indexOfChar = alphabet.indexOf(Character.toLowerCase(c));
      if (indexOfChar == -1) {
        return c;
      }
      isUpperCase = true;
    }
    if (factor == 26) {
      return c;
    }
    if (factor > 26) {
      factor = factor % 26;
    }
    int indexOfEncryptedChar = factor + indexOfChar;
    if (indexOfEncryptedChar > 25) {
      indexOfEncryptedChar = indexOfEncryptedChar - 26;
    }
    return isUpperCase ? Character.toUpperCase(alphabet.get(indexOfEncryptedChar)) : alphabet.get(indexOfEncryptedChar);
  }
}
