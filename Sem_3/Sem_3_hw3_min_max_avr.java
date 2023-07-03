//Задание 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package Sem_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Sem_3_hw3_min_max_avr {

  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 15, 3, 11, 9));
    findMinMaxAverage(numbers);
  }

  public static void findMinMaxAverage(ArrayList<Integer> list) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int num : list) {
      min = Math.min(min, num);
      max = Math.max(max, num);
      sum += num;
    }

    double average = (double) sum / list.size();

    //Попробуем вывести с определенным количеством знаков после запятой
    DecimalFormat df = new DecimalFormat(".####");


    System.out.println("Минимальное значение: " + min);
    System.out.println("Максимальное значение: " + max);
    System.out.println("Среднее значение: " + df.format(average));
  }

}
