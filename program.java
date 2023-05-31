import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class program {

  public static void filter(Laptop[] laptops) {
    Scanner scan = new Scanner(System.in);
    Map<Integer, Object> options = new HashMap<>();

    for (int i = 1; i < 6; i++) {
      options.put(i, null);
    }

    int count = 0;

    while (count != 6) {
      count = 0;
      System.out.println("");
      System.out.println(
          "Введите критерий фильтрации (нажмите):\n 1 - производитель ноутбука\n 2 - RAM\n 3 - HDD\n 4 - OS\n 5 - цвет\n 6 - начать поиск\n");
      try {
        count = Integer.parseInt(scan.nextLine());
        if (count > 6 || count < 1)
          System.out.println("Введено неверное число\n");
      } catch (Exception ex) {
        System.out.println("Введено не число\n");
      }

      if (count == 1) {
        System.out.println("Введите производителя ноутбука:  ");
        options.put(count, scan.nextLine().toUpperCase());
      }

      else if (count == 2) {
        System.out.println("Введите цифрой минимально необходимый размер RAM:  ");
        try {
          int ramOpt = Integer.parseInt(scan.nextLine());
          options.put(count, ramOpt);
        } catch (Exception ex) {
          System.out.println("Введено не число или неправильное число\n");
        }
      }

      else if (count == 3) {
        System.out.println("Введите цифрой минимально необходимый размер HDD:  ");
        try {
          int hddOpt = Integer.parseInt(scan.nextLine());
          options.put(count, hddOpt);
        } catch (Exception ex) {
          System.out.println("Введено не число или неправильное число\n");
        }
      }

      if (count == 4) {
        System.out.println("Введите имя OS (WIN10, WIN11, LINUX, NONE):  ");
        options.put(count, scan.nextLine().toUpperCase());
      }

      if (count == 5) {
        System.out.println("Введите цвет ноутбука (BLACK, BLUE, WHITE, GREY):  ");
        options.put(count, scan.nextLine().toUpperCase());
      }
    }
    scan.close();
    System.out.println("Ваши критерии фильтрации: ");
    System.out.println(options);

    for (Laptop laptop : laptops) {
      if (options.get(1) == null || (laptop.getName()).equals(options.get(1))) {
        if (options.get(2) == null || (laptop.getRam()) >= (Integer) options.get(2)) {
          if (options.get(3) == null || (laptop.getHdd()) >= (Integer) options.get(3)) {
            if (options.get(4) == null || (laptop.getOs()).equals(options.get(4))) {
              if (options.get(5) == null || (laptop.getColor()).equals(options.get(5))) {
                System.out.println(laptop.toString());
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {

    Laptop[] laptops = new Laptop[] {
        new Laptop("SAMSUNG", 16, 500, "WIN10", "BLACK"),
        new Laptop("SAMSUNG", 8, 250, "NONE", "BLUE"),
        new Laptop("HP", 32, 1000, "WIN11", "BLACK"),
        new Laptop("HP", 8, 500, "WIN10", "WHITE"),
        new Laptop("LENOVO", 8, 250, "LINUX", "BLACK"),
        new Laptop("IBM", 16, 1000, "NONE", "GREY"),
        new Laptop("LENOVO", 16, 500, "NONE", "BLACK"),
        new Laptop("XIAOMI", 32, 2000, "WIN11", "BLACK"),
        new Laptop("SAMSUNG", 32, 1000, "WIN11", "GREY"),
        new Laptop("IBM", 16, 500, "NONE", "BLUE"),
        new Laptop("XIAOMI", 8, 125, "LINUX", "WHITE"),
        new Laptop("LENOVO", 64, 3000, "WIN11", "GREY"),
        new Laptop("HP", 32, 500, "WIN11", "BLUE"),
        new Laptop("XIAOMI", 16, 500, "WIN10", "BLACK"),
        new Laptop("LENOVO", 16, 1000, "NONE", "WHITE"),
        new Laptop("IBM", 32, 1000, "WIN10", "GREY"),
        new Laptop("HP", 8, 500, "NONE", "BLUE"),
        new Laptop("XIAOMI", 16, 500, "LINUX", "WHITE"),
        new Laptop("IBM", 16, 250, "WIN10", "BLACK") };

    System.out.println("В нашем магазине продаются следующие ноутбуки:  \n");
    for (Laptop laptop : laptops) {
      System.out.println(laptop.toString());
    }

    filter(laptops);
  }
}