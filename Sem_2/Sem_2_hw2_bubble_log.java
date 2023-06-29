/*2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл. */

package Sem_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sem_2_hw2_bubble_log {
  public static void main(String[] args) {
    int[] input_array = { 10, 12, 2, 30, 9 };
    sortandlogArray(input_array);
  }

  public static void sortandlogArray(int[] mass) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("log_lmstr.txt"))) {
      // Запись исходного массива в лог-файл
      writer.write("Исходный массив: ");
      for (int element : mass) {
        writer.write(element + " ");
      }
      writer.newLine();

      // Сортировка пузырьком
      for (int i = 0; i < mass.length - 1; i++) {
        for (int j = 0; j < mass.length - i - 1; j++) {
          if (mass[j] > mass[j + 1]) {
            int temp = mass[j];
            mass[j] = mass[j + 1];
            mass[j + 1] = temp;
          }
          // Запись промежуточного результата в лог-файл
          writer.write("  Итерация j " + (j + 1) + ": ");
          for (int element : mass) {
            writer.write(element + " ");
          }
          writer.newLine();
        }

        // Запись промежуточного результата в лог-файл
        writer.write("Итерация i " + (i + 1) + ": ");
        for (int element : mass) {
          writer.write(element + " ");
        }
        writer.newLine();
      }

      // Запись отсортированного массива в лог-файл
      writer.write("Отсортированный массив: ");
      for (int element : mass) {
        writer.write(element + " ");
      }
      writer.newLine();
    } catch (IOException e) {
      System.out.println("Error" + e.getMessage());
    }
  }

}
