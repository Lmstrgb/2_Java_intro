//Задание 2. Пусть дан произвольный список целых чисел, удалить из него четные числа

package Sem_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Sem_3_hw2_evenRemove {

  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(11, 2, 31, 4, 5, 6));
    removeEvenNum(numbers);
    System.out.println(numbers);
  }

  public static void removeEvenNum(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) % 2 == 0) {
        list.remove(i);
        i--;
      }
    }
  }

}
