//📌 Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
//их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию 
//числа телефонов.

package Sem_5_hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tel_book_hashMap {

  public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addContact("Igor Gogin", "+798765001");
    phoneBook.addContact("Olga Tabor", "+798743002");
    phoneBook.addContact("Alex", "+7937434005");
    phoneBook.addContact("Zina", "+79043503602");
    phoneBook.addContact("Zina", "+79043503603");
    phoneBook.addContact("Zina", "+79043503604");
    phoneBook.removeContact("Olga Tabor");
    phoneBook.addContact("Igor Gogin", "+798765011");
    phoneBook.addContact("Alex", "+7937434055");
    phoneBook.addContact("Max", "+79044703707");

     
    // phoneBook.printAllContacts(); // выводит в неотсортированном виде
     phoneBook.printAllsortedContacts(); // выводит в отсортированном виде
    // phoneBook.printPhoneNumber(phoneBook.getPhones("Igor Gogin"), "Igor Gogin"); //выдает номер человека
    // phoneBook.createSortedList();
  }
}

// Не совсем понятно с этими класами, но так отдельно вынесенный класс работает
// в принципе
class PhoneBook {
  
  public HashMap<String, List<String>> phoneBook;

  public PhoneBook() {
    phoneBook = new HashMap<>();
  }

  public void addContact(String name, String phoneNumber) {
    if (phoneBook.containsKey(name)) {
      List<String> phoneNumbers = phoneBook.get(name);
      phoneNumbers.add(phoneNumber);
    } else {
      List<String> phoneNumbers = new ArrayList<>();
      phoneNumbers.add(phoneNumber);
      phoneBook.put(name, phoneNumbers);
    }
  }

  public void removeContact(String name) {
    phoneBook.remove(name);
  }

  // По имени будет выводить телефоны, список телефонов
  public List<String> getPhones(String name) {
    return phoneBook.get(name);
  }

  public void printPhoneNumber(List<String> phoneNumber, String name) {
    String res_print = "";
    for (String pn : phoneNumber) {
      res_print += pn + " ";
    }
    System.out.println("Phone numbers of " + name + " " + res_print);

  }

  public void printAllContacts() {
    for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
      String name = entry.getKey();
      List<String> phoneNumbers = entry.getValue();
      String res_phone = "";

      for (String phoneNumber : phoneNumbers) {
        res_phone += phoneNumber + ", ";
      }
      // нужно удалить запятую, которая получается в конце строки res_phone
      if (!res_phone.isEmpty()) {
        res_phone = res_phone.substring(0, res_phone.length() - 2); // Удаление последней запятой и пробела
      }

      System.out.println("Name: " + name + ", Phone Number: " + res_phone);
    }
  }

  public void printAllsortedContacts() {
    // ArrayList<Integer> Lst = new ArrayList<>(phoneBook.size());
    String res_phone = "";

    List<Integer> Lst_sorted = createSortedList();

    for (Integer itm : Lst_sorted) {
      for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {

        // Lst.add(phoneNumbers.size());

        if (itm == entry.getValue().size()) {
          res_phone = "";
          List<String> phone = entry.getValue();
          String name = entry.getKey();
          for (String phoneNum : phone) {
            res_phone += phoneNum + ", ";
          }
          // нужно удалить запятую, которая получается в конце строки res_phone
          if (!res_phone.isEmpty()) {
            res_phone = res_phone.substring(0, res_phone.length() - 2); // Удаление последней запятой и пробела
          }
          System.out.println("Name: " + name + ", Phone Number: " + res_phone);
        }

      }

    }

  }

  
  public List<Integer> createSortedList() {
    ArrayList<Integer> Lst = new ArrayList<>(phoneBook.size());
    for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
      List<String> phoneNumbers1 = entry.getValue();
      String name1 = entry.getKey();

      Lst.add(phoneNumbers1.size());
    }
    Collections.sort(Lst, Collections.reverseOrder()); // отсортируем список Lst по убыванию
    // System.out.println(Lst);
    // Как оказалось для вывода в порядке по убыванию нашей HashMap нужно сделать
    // список из уникальных значений, делаем
    List<Integer> Lst2 = new ArrayList<>();
    for (Integer element : Lst) {
      if (!Lst2.contains(element)) {
        Lst2.add(element);
      }
    }
    System.out.println(Lst2);
    return Lst2;

  }
}