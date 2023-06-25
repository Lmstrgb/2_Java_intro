package Sem_1_intro;

public class Sum_1_to_n {
  public static void main(String[] args) {
    int num = Sem1_lib.inputIntFromConsole();
    int Sum = Sem1_lib.getSum(num);
    int Fact = Sem1_lib.getFact(num);
    System.out.println("Сумма от " + num + " = " + Sum);
    System.out.println("Факториал " + num + " = " + Fact);
  }

}
