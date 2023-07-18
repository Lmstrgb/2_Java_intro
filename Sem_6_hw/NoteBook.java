// Формат сдачи: ссылка на подписанный git-проект.
// Задание
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:

// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package Sem_6_hw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NoteBook {
  public static void main(String[] args) {
    HashSet<Note> notebooks = new LinkedHashSet<>();

    Note notebook1 = new Note(1, "Omen laptop", "HP", "Intel(R) Core(TM) i7-10750H CPU @ 2.60GHz, 2.59 GHz", 32,
        "E0B9B466-C057-4F4F-8FF5-0E041BBE1Z1E", "Windows 10", "NVIDIA GeForce RTX 2070 Super", 120, "Intel Wi-Fi A201",
        1000, 3.0, 165000.00);
    Note notebook2 = new Note(2, "Notebook 2", "Vendor 2", "Processor 2", 16, "Code 2", "OS 2", "Video Adapter 2", 75,
        "Net Adapter 2", 1000, 3.1, 94000.00);
    Note notebook3 = new Note(3, "Notebook 3", "Vendor 3", "Processor 3", 8, "Code 3", "OS 3", "Video Adapter 3", 120,
        "Net Adapter 3", 2000, 3.2, 56400.00);

    notebooks.add(notebook1);
    notebooks.add(notebook2);
    notebooks.add(notebook3);

    // System.out.println("Множество ноутбуков: ");
    // for (Note notebook : notebooks) {
    // System.out.println(notebook);
    // }

    // System.out.println("Ноут 3: " + notebook3);
    // // boolean re;
    // // re=notebook3.supportsUSB3();
    // System.out.println(notebook1.getName());
    // System.out.println(notebook1.getProc());
    Note.filterNotebooks(notebooks);
  }
}

class Note {
  Integer ID;
  String nameDevice;
  String vendor;
  String processor;
  Integer ram;
  String deviceCode;
  String os;
  String videoAdapter;
  Integer screenRefreshRate;
  String netAdapter;
  Integer volumeHDD;
  Double usbVer;
  Double price;

  public Note(Integer ID, String nameDevice, String vendor, String processor, Integer ram, String deviceCode, String os,
      String videoAdapter, Integer screenRefreshRate, String netAdapter, Integer volumeHDD, Double usbVer,
      Double price) {
    this.ID = ID;
    this.nameDevice = nameDevice;
    this.vendor = vendor;
    this.processor = processor;
    this.ram = ram;
    this.deviceCode = deviceCode;
    this.os = os;
    this.videoAdapter = videoAdapter;
    this.screenRefreshRate = screenRefreshRate;
    this.netAdapter = netAdapter;
    this.volumeHDD = volumeHDD;
    this.usbVer = usbVer;
    this.price = price;
  }

  public int getId() {
    return ID;
  }

  public String getName() {
    return nameDevice;
  }

  public String getVendor() {
    return vendor;
  }

  public String getProc() {
    return processor;
  }

  public int getRam() {
    return ram;
  }

  public String getdeviceCode() {
    return deviceCode;
  }

  public String getOs() {
    return os;
  }

  public String getVideoAdapter() {
    return videoAdapter;
  }

  public int getscreenRefreshRate() {
    return screenRefreshRate;
  }

  public String getNetAdapter() {
    return netAdapter;
  }

  public int getVolumeHDD() {
    return volumeHDD;
  }

  public Double getUsbVer() {
    return usbVer;
  }

  public Double getPrice() {
    return price;
  }

  // Методы определяющие тип USB
  public boolean supportsUSB3() {
    return usbVer >= 3.0;
  }

  public boolean supportsUSB2() {
    return (usbVer >= 2) && (usbVer < 3.0);
  }

  public static void filterNotebooks(HashSet<Note> notebooks) {
    // Запрос критериев фильтрации у пользователя
    Scanner scanner = new Scanner(System.in);

    Map<String, Object> filter = new LinkedHashMap<>();
    // HashSet<Note> filtered = new LinkedHashSet<>();
    Integer lastKey = 0;
    Integer firstKey = 0;
    System.out.println("Введите номера критериев фильтрации через запятую:");
    System.out.print("1 - ID\t");
    System.out.print("2 - название\t");
    System.out.print("3 - производитель\t");
    System.out.print("4 - процессор\t");
    System.out.print("5 - ОЗУ\t");
    System.out.print("6 - код устройства\t");
    System.out.println("7 - операционная система\t");
    System.out.print("8 - видео адаптер\t");
    System.out.print("9 - частота обновления экрана\t");
    System.out.print("10 - сетевой адаптер\t");
    System.out.print("11 - объем HDD\t");
    System.out.print("12 - версия USB\t");
    System.out.println();
    System.out.println("13 - цена ноутбука в рублях\t");
    // System.out.println("Введите номера критериев фильтрации через запятую:");
    // System.out.println("1 - ID\t\t\t2 - название");
    // System.out.println("3 - производитель\t4 - процессор");
    // System.out.println("5 - ОЗУ\t\t\t6 - код устройства");
    System.out.println();
    String input = scanner.nextLine();
    String[] filter_str = input.split(",");
    int[] filter_int = new int[filter_str.length];
    for (int i = 0; i < filter_str.length; i++) {
      filter_int[i] = Integer.parseInt(filter_str[i]);
    }

    // Пойдем по нашим ноутбукам и массиву из чисел, введенных с клавиатуры
    for (Note nt : notebooks) {
      // Как то наверное, можно автоматически сделать карту такую, но пока приходится
      // делать вручную через switch
      // нужно получать последний ключ в filter
      lastKey++;
      // for (Map.Entry<String, Object> entry : filter.entrySet()) {
      // lastKey = entry.getKey();
      // }

      // firstKey=filter.

      for (int elm : filter_int) {
        switch (elm) {
          case 1:
            filter.putIfAbsent("id" + lastKey, nt.getId());
            break;
          case 2:
            filter.putIfAbsent("name" + lastKey, nt.getName());
            break;
          case 3:
            filter.putIfAbsent("vendor" + lastKey, nt.getVendor());
            break;
          case 4:
            filter.putIfAbsent("proc" + lastKey, nt.getProc());
            break;
          case 5:
            filter.putIfAbsent("ram" + lastKey, nt.getRam());
            break;
          case 6:
            filter.putIfAbsent("dcode" + lastKey, nt.getdeviceCode());
            break;
          case 7:
            filter.putIfAbsent("os" + lastKey, nt.getOs());
            break;
          case 8:
            filter.putIfAbsent("vadapt" + lastKey, nt.getVideoAdapter());
            break;
          case 9:
            filter.putIfAbsent("srate" + lastKey, nt.getscreenRefreshRate());
            break;
          case 10:
            filter.putIfAbsent("nadapt" + lastKey, nt.getNetAdapter());
            break;
          case 11:
            filter.putIfAbsent("vhdd" + lastKey, nt.getVolumeHDD());
            break;
          case 12:
            filter.putIfAbsent("uver" + lastKey, nt.getUsbVer());
            break;
          case 13:
            filter.putIfAbsent("price" + lastKey, nt.getPrice());
            break;
        }
      }

    }
    if (filter.isEmpty()) {
      System.out.println("Нет ноутбуков, подходящим под условия фильтрации");
    } else {
      System.out.println("Найденные ноутбуки: " + filter);
    }
    scanner.close();
  }

  public static void filterValNotebooks(HashMap<String, Object> filt) {
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Введите значения критериев фильтра через запятую:");

    System.out.println();
    String input1 = scanner1.nextLine();
    String[] filter1_str = input1.split(",");
    int[] filter1_int = new int[filter1_str.length];
    for (int i = 0; i < filter1_str.length; i++) {
      filter1_int[i] = Integer.parseInt(filter1_str[i]);
    }
  }

  @Override
  public String toString() {
    return "Notebook{" +
        "ID=" + ID +
        ", nameDevice='" + nameDevice + '\'' +
        ", vendor='" + vendor + '\'' +
        ", processor='" + processor + '\'' +
        ", ram='" + ram + '\'' +
        ", deviceCode='" + deviceCode + '\'' +
        ", os='" + os + '\'' +
        ", videoAdapter='" + videoAdapter + '\'' +
        ", screenRefreshRate=" + screenRefreshRate +
        ", netAdapter='" + netAdapter + '\'' +
        ", volumeHDD=" + volumeHDD +
        ", usbVer=" + usbVer +
        '}';
  }

}
