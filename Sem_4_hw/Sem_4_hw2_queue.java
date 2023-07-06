// 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, 
//dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

package Sem_4_hw;

import java.util.LinkedList;
import java.util.Queue;

public class Sem_4_hw2_queue {
  public static void main(String[] args) {
    myQueue qu1 = new myQueue();

    qu1.enqueue(1);
    qu1.enqueue(2);
    qu1.enqueue(3);
    qu1.prqueue();
    
    System.out.println("first " + qu1.first());
    System.out.println("removed " + qu1.dequeue());
    System.out.println("size " + qu1.size());
    qu1.prqueue();

    System.out.println("first " + qu1.first());
    System.out.println("removed " + qu1.dequeue());
    System.out.println("size " + qu1.size());
    qu1.prqueue();

    //Для проверки исключения
    // qu1.dequeue();
    // System.out.println("first " + qu1.first());
    

  }
}

class myQueue {
  int top = -1;
  public LinkedList<Integer> qu;

  public myQueue() {
    qu = new LinkedList<Integer>();
    top = -1;
  }

  public int size() {
    return top + 1;
  }

  public boolean empty() {
    return top == -1;
  }

  public void enqueue(int el) {
    top++;
    qu.add(el);

  }

  public int dequeue() {
    if (empty()) {
      throw new IllegalStateException("Очередь пуста!");
    }
    top--;
    return qu.remove();
  }

  public void prqueue() {
    for (int item : qu) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public int first() {
    if (empty()) {
      throw new IllegalStateException("Очередь пуста!");
    }
    return qu.getFirst();
  }

}