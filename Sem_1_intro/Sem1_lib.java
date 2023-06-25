package Sem_1_intro;

import java.util.Scanner;

public class Sem1_lib {
  public static int inputIntFromConsole() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите число: ");
    int number = scanner.nextInt();
    scanner.close();
    return number;
  }

  public static int getSum(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n + getSum(n - 1);
    }
  }

  public static int getFact(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * getFact(n - 1);
    }
  }

  public static void getSimpleNum(int n) {
    String res = "";
    for (int i = 2; i <= n; i++) {
      if (isSimple(i)) {
        res+=i+" ";
      }
    }
    System.out.println("Простые числа: " + res);
  }

  public static boolean isSimple(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
