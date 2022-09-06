import java.rmi.Remote;
import java.util.NoSuchElementException;

public class SortedLinkedList {
  private Node head = null;
  private Node tail = null;
  private int numNode = 0;

  public SortedLinkedList() {
    this.head = this.tail = null;
  }

  public SortedLinkedList(Integer i) {
    this.head = new Node(i, null, null);
    this.tail = head;
    numNode++;
  }

  public Node getHead() {
    return this.head;
  }

  public Node getTail() {
    return this.tail;
  }

  public SortedLinkedList(Integer i, Node next, Node prve) {
    Node newNode = new Node(i);
    newNode.setNext(next);
    newNode.setPrve(prve);
    numNode++;
  }

  public void addLast(Integer item) {
    if (head != null) {
      // tail = new Node(item, null, tail);
      Node tmpNode = tail;
      Node newNode = new Node(item);
      tail.setNext(newNode);
      tail = newNode;
      tail.setPrve(tmpNode);
      numNode++;
    } else {
      head = new Node(item, null, null);
      tail = head;
      numNode++;
    }
  }

  public void addFirst(Integer item) {
    if (head != null) {
      Node newNode = new Node(item, head, null);
      head.setPrve(newNode);
      head = newNode;
      numNode++;
    } else {
      head = new Node(item, null, null);
      tail = head;
      numNode++;
    }
  }

  public void sorted() {
    Node countNode = head;
    Node nextNode = head.getNext();
    Node minNode = head;
    if (head != null) {
      for (int i = 0; i < numNode - 1; i++) {
        for (int j = i + 1; j < numNode; j++) {
          if (minNode.getElement() > nextNode.getElement()) {
            minNode = nextNode;
          }
          nextNode = nextNode.getNext();
        }
        Integer temp = countNode.getElement();
        countNode.setData(minNode.getElement());
        minNode.setData(temp);
        countNode = countNode.getNext();
        nextNode = countNode.getNext();
        minNode = countNode;

      }
    }
  }

  public void add(Integer item) {
    if (head == null) {
      addFirst(item);
    } else {
      if (numNode == 1) {
        if (head.getElement() >= item) {
          addFirst(item);
        } else if (head.getElement() < item) {
          addLast(item);
        }
      } else {
        Node tmp = head;
        while (tmp != null) {

          if (tmp.getElement() <= item) {
            System.out.println(item);
            Node tmpNew = new Node(item, tmp.getNext(), tmp);
            // tmp.setNext(tmpNew);
            // tmp.getNext().setPrve(tmpNew);
            numNode++;
          } else {
            System.out.println(tmp.getNext().getElement());
          }
          tmp = tmp.getNext();
        }
      }
    }
  }

  public void removeLast() {
    // Node newNode = new Node(tail.getPrev().getElement(), null, tail.getPrev());
    // tail = newNode;
    tail = new Node(tail.getPrev().getElement(), null, tail.getPrev().getPrev());
    numNode--;
  }

  public void removeFirst() {
    head = new Node(head.getNext().getElement(), head.getNext().getNext(), null);
    numNode--;
  }

  public Integer remove(Integer item) {
    Node nodeTemp = head;
    Integer afterRemove = -1;
    if (head != null) {
      for (int i = 0; i < numNode; i++) {
        if (nodeTemp.getElement() == item) {
          if (nodeTemp.getPrev() == null) {
            removeFirst();
          } else if (nodeTemp.getNext() == null) {
            removeLast();
          } else {
            Node newNode = nodeTemp.getPrev();
            newNode.setNext(nodeTemp.getNext());
            nodeTemp.getNext().setPrve(newNode);
            numNode--;
            return afterRemove;
          }
        }
        nodeTemp = nodeTemp.getNext();
      }
    } else {
      throw new NoSuchElementException("Can't remove element ..");
    }
    return afterRemove;
  }

  public void print() {
    Node temp = head;
    for (int i = 0; i < numNode; i++) {
      System.out.println("item : " + temp.getElement());
      temp = temp.getNext();
    }
  }

}