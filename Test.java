import java.util.List;

public class Test {
  public static void main(String[] args) {
    SortedLinkedList listSorted = new SortedLinkedList();
    listSorted.add(2);
    listSorted.add(4);
    listSorted.add(9);
    listSorted.add(7);
    listSorted.add(1);
    listSorted.add(0);
    listSorted.add(5);
    listSorted.add(200);
    listSorted.add(200);
    listSorted.add(10);
    listSorted.add(-10);

    listSorted.print();
    listSorted.remove(10);
    System.out.println("list : ");
    listSorted.print();
  }
}
