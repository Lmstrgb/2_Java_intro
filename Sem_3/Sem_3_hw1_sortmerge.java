
// Задание 1. Реализовать алгоритм сортировки слиянием
package Sem_3;

import java.util.ArrayList;


public class Sem_3_hw1_sortmerge {
  public static void main(String[] args) {
    ArrayList<Integer> list_original = new ArrayList<>();
    list_original.add(7);
    list_original.add(32);
    list_original.add(5);
    list_original.add(8);
    list_original.add(7);
    list_original.add(3);
    list_original.add(12);
    // list_original.add(12);
    System.out.println("Исходный список: " + list_original);
    ArrayList<Integer> res = sortArray(list_original);
    System.out.println("Сортированный список: " + res);
  }

  public static ArrayList<Integer> sortArray(ArrayList<Integer> list) {

    // Если массив нулевой
    if (list == null) {
      System.out.println("Массив нулевой, ничего не поделать");
      return list;
    }

    // Если массив из одного элемента, то и сортировать его не стоит
    if (list.size() <= 1) {
      return list;
    }

    int center = list.size() / 2;
    // делаем массивы, разделенные пополам
    ArrayList<Integer> arrayLeft = new ArrayList<>(list.subList(0, center));
    ArrayList<Integer> arrayRight = new ArrayList<>(list.subList(center, list.size()));
    System.out.println("Пром. рез " + arrayLeft);
    System.out.println("Пром. рез " + arrayRight);

    // Её Величество Рекурсия пошла
    sortArray(arrayLeft);
    sortArray(arrayRight);
    return (mergeArray(arrayLeft, arrayRight, list));
  }

  public static ArrayList<Integer> mergeArray(ArrayList<Integer> left, ArrayList<Integer> right,
      ArrayList<Integer> mergedList) {
    int l = 0;
    int r = 0;
    while (l < left.size() && r < right.size()) {
      if (left.get(l) <= right.get(r)) {
        mergedList.set(l + r, left.get(l));
        l++;
      } else {
        mergedList.set(l + r, right.get(r));
        r++;
      }
    }

    while (l < left.size()) {
      mergedList.set(l + r, left.get(l));
      l++;
    }

    while (r < right.size()) {
      mergedList.set(l + r, right.get(r));
      r++;
    }
    return mergedList;
  }

}
