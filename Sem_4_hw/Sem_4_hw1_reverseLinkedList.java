// 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет
// “перевернутый” список.


package Sem_4_hw;

import java.util.LinkedList;

public class Sem_4_hw1_reverseLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    LinkedList<Integer> res_reversedList = reverseLinkedList(list);

    System.out.println("Исходный список: " + list);
    System.out.println("Перевернутый список: " + res_reversedList);
  }

  public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
    LinkedList<Integer> reversedList = new LinkedList<>();

    // Начнём с конца существующего массива
    for (int i = list.size() - 1; i >= 0; i--) {
      reversedList.add(list.get(i));
    }

    // Можно while попробовать
    // int j = list.size()-1;
    // while (j >= 0) {
    // reversedList.add(list.get(j));
    // j--;
    // }

    return reversedList;
  }

}