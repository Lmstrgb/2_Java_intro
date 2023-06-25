/*
//4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например,
//2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
*/

//Попытка решить
/*
 1. Сначала вводим первое слагаемое вида 2? как строку
 2. Ищем в этой строке ? и число
 3. То же самое делаем со вторым слагаемым
 4. Вводимправую часть уравнения
 5. Считаем количество ? и в зависимости от их количества перебором решаем. Если один знак ? то решение будет проще, если два, то
 сложнее, если три то третье решение.
 */
package Sem_1_intro;

import java.util.Scanner;

public class Sem_1_equation {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите первое слагаемое: ");
    String num1 = scanner.nextLine();

    System.out.print("Введите правую часть: ");
    String right_part = scanner.nextLine();

    int questionMarksCount = 0;
    int digitsCount = 0;
    int posMark = 0;
    int Decision = 0;
    String res = "";
    String num1_buf = "";

    for (int i = 0; i < num1.length(); i++) {
      char c = num1.charAt(i);
      if (c == '?') {
        questionMarksCount++;
        posMark = i; // нашли позицию вопросика
      } else if (Character.isDigit(c)) {
        digitsCount++;
        res += c; // на всякий случай лепим строку из цифр
      }
    }

    switch (questionMarksCount) {
      case 1: // Один ? в уравнении, если было бы два, то нужно как-то по-другому решать
        for (int i = 0; i < num1.length(); i++) {
          char c = num1.charAt(i);
          if (c == '?') {
            for (int j = 0; j <= 9; j++) {
              num1 = num1.substring(0, posMark) + j + num1.substring(posMark + 1);
              if (!num1.equals(right_part)) {
              } else {
                System.out.println("Уравнение решено, ? = " + j);
                Decision++;
                break;
              }
            }
          }
        }
        if (Decision <= 0) {
          System.out.println("Уравнение решений не имеет");
        }
        break;
      default:
        System.out.println("Уравнение знаков \"?\" не имеет");
        break;
    }

    // if(str1.equals(str2)){
    System.out.println("Количество знаков \"?\": " + questionMarksCount);
    // System.out.println("Количество целых цифр: " + digitsCount);
    // System.out.println("Строка из цифр " + res);

  }
}