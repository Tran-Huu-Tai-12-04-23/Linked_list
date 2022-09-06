public class Node {
  private Node next;
  private Node prev;
  private Integer e;

  public Node() {
    this(null, null, null);
  }

  public Node(Integer it) {
    this(it, null, null);
  }

  public Node(Integer it, Node next, Node prev) {
    this.e = it;
    this.next = next;
    this.prev = prev;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node nextIt) {
    this.next = nextIt;
  }

  public void setPrve(Node prevIt) {
    this.prev = prevIt;
  }

  public Node getPrev() {
    return this.prev;
  }

  public Integer getElement() {
    return this.e;
  }

  public void setData(Integer item) {
    this.e = item;
  }
}
