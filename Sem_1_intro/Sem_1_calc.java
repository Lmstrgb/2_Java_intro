package Sem_1_intro;

public class Sem_1_calc {
  public static void main(String[] args) {
    int n1 = Sem1_lib.inputIntFromConsole();
    int n2 = Sem1_lib.inputIntFromConsole();
    String action = Sem1_lib.inputStrFromConsole("Введите действие для чисел (+, -, *, /): ");
    int res = 0;
    double res_f = 0.0f;
    boolean flag = false;
    switch (action) {
      case ("+"):
        res = n1 + n2;
        break;
      case ("-"):
        res = n1 - n2;
        break;
      case ("*"):
        res = n1 * n2;
        break;
      case ("/"):
        flag = true;
        res_f = (double) n1 / n2;
        break;
      default:
        System.out.println("Ввели неправильное действие");
        System.exit(0);
        break;
    }
    if (flag) {
      System.out.println("Результат = " + res_f);
    } else {
      System.out.println("Результат = " + res);
    }
  }
}
