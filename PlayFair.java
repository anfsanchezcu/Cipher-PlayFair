import java.util.Random;

public class PlayFair {
  public static void main(String[] args) {
    int[] key = GenerateSquare();
    String plainText = "It was in military use from the Boer War through World War two";

    plainText.split("");


    String cipherText = Cipher(plainText, key);
    String plainTextByDecription = Decipher(cipherText, key);

    System.out.println(plainText);
    System.out.println(cipherText);
    System.out.println(plainTextByDecription);
  }

  static int[] GenerateSquare() {
    Random rn = new Random();

    int[] square = new int[25];
    int base = 97;
    int position;
    for (int j = 0; j <= square.length; j++) {
      position = rn.nextInt(25);
      while (square[position] != 0)
        position = rn.nextInt(25);
      square[position] = j + base;
      if (j == 8)
        j++;
    }

    for (int i = 0; i < square.length; i++) {
      if (i % 5 == 0 && i > 0)
        System.out.println();
      System.out.print((char) (square[i]));
      System.out.print(" ");
    }

    System.out.println();
    return square;
  }

  static String Cipher(String text, int[] key) {
    text = text.toLowerCase();

    String r = "";
    int a, b;
    for (int i = 0; i < text.length(); i += 2) {
      // System.out.println("here");
      a = text.charAt(i);
      b = i + 1;
      if (b >= text.length())
        b = 120;
      else {
        b = text.charAt(b) == 32 ? 120 : text.charAt(b);
      }

      if (a == 32) {
        i -= 1;
        continue;
      }

      boolean fA = false;
      boolean fB = false;
      for (int j = 0; j < key.length; j++) {
        if (a == key[j] && !fA)
          a = j;
        if (b == key[j] && !fB)
          b = j;
      }
      int rowA = (a / 5);
      int rowB = (b / 5);
      int colA = (a % 5);
      int colB = (b % 5);
      if (rowA == rowB) {
        a = rowA * 5 + ((a + 1) % 5);
        b = rowB * 5 + ((b + 1) % 5);
      } else if (colA == colB) {

        a = (a + 5) % 25;
        b = (b + 5) % 25;
      } else {
        int dif = (colA - colB);
        a = a - dif;
        b = b + dif;
      }
      r += (char) key[a] + "" + (char) key[b] + " ";
    }
    return r;
  }

  static String Decipher(String text, int[] key) {
    text = text.toLowerCase();

    String r = "";
    int a, b;
    for (int i = 0; i < text.length(); i += 2) {
      // System.out.println("here");
      a = text.charAt(i);
      b = i + 1;
      if (b >= text.length())
        b = 120;
      else {
        b = text.charAt(b) == 32 ? 120 : text.charAt(b);
      }

      if (a == 32) {
        i -= 1;
        continue;
      }

      boolean fA = false;
      boolean fB = false;
      for (int j = 0; j < key.length; j++) {
        if (a == key[j] && !fA)
          a = j;
        if (b == key[j] && !fB)
          b = j;
      }
      int rowA = (a / 5);
      int rowB = (b / 5);
      int colA = (a % 5);
      int colB = (b % 5);
      if (rowA == rowB) {
        a = rowA * 5 + ((a + 4) % 5);
        b = rowB * 5 + ((b + 4) % 5);
      } else if (colA == colB) {
        a = (a + 20) % 25;
        b = (b + 20) % 25;
      } else {
        int dif = (colA - colB);
        a = a - dif;
        b = b + dif;
      }
      r += (char) key[a] + "" + (char) key[b] + " ";
    }
    return r;
  }

  static char toChart(int ascci) {
    return (char) (ascci + 97);
  }
}