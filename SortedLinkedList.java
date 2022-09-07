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
      head = newNode;
      newNode.getNext().setPrve(newNode);
      numNode++;
    } else {
      head = new Node(item, null, null);
      tail = head;
      numNode++;
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
        Node tmp = tail;
        while (tmp != null) {
          if (tmp.getElement() <= item) {
            Node isTailNext = tmp.getNext();
            Node tmpNew = new Node(item, tmp.getNext(), tmp);
            tmp.setNext(tmpNew);
            if( isTailNext != null ) {
              tmp.getNext().setPrve(tmpNew); 
            } else {
              tail = tmpNew ; 
            }
            numNode++;
            if( tmp.equals(tail) ) {
              System.out.print(tmp.getElement());
            }
            break ;
          } else if(tmp.equals(head)){
            if( tmp.getElement() >= item){
              addFirst(item); 
              break;
            }
          } 
          tmp = tmp.getPrev();
        }
      }
    }
    System.out.println(tail.getElement());
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
    Integer afterRemove = -1;
    if (head != null) {
      Node nodeTemp = head;
      while( nodeTemp !=  null ) {
        if( nodeTemp.getElement() == item ) {
           
        }
        nodeTemp = nodeTemp.getNext() ; 
      }
    } else {
      throw new NoSuchElementException("Can't remove element ..");
    }
    return afterRemove;
  }

  public void print() {
    Node temp = tail;
    for (int i = 0; temp.getNext() != null ; i++) {
      System.out.println("item : " + temp.getElement());
      temp = temp.getPrev();
    }
  }

}