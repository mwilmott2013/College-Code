
import java.lang.reflect.Array; 
import java.util.Iterator;
public class LinkedList<E> implements Iterable<E> {

  
  
  private class Node { 
    E data;
    Integer index_next; // pointer to the next element in the array elements 
    Integer index_array; // pointer to the current element in the array elements 
    Integer index_previous; // pointer to the previous element in the array elements
  
    public Node(E data_) {
      data = data_;
    } 

    public String toString() {

      StringBuilder sb = new StringBuilder(); 
      sb.append(data.toString() + " (" + index_previous + ", " 
          + index_array + ", " + index_next + ")"); 
      return new String(sb);
    }


  }
// hold all elements in this array 
  Node[] elements;

// Initial size of the array. 

private final int INITIAL_SIZE = 8;
  private Integer tail; // pointer to the tail 
  
  private Integer head; 
  
  // these variable are optional
  private int current_index = 0; // index in the array to use 
    // when adding element 
  private int size = 0;
  
  @SuppressWarnings("unchecked") 
  
  public LinkedList() {
    // ugly cast is necessary as Java doesn�t 
    // allow creating generic arrays using 
    // E[] e = new E[10]; <- Does not work 
    elements = (Node[]) Array.newInstance(Node.class, INITIAL_SIZE); 
    tail = null; 
    head = null;
  }
  
  public boolean isEmpty() { 
    return size == 0;
  }
  public void addLast(E t) { 
    Node n = new Node(t);
    elements[size-1] = n;
    n.index_array = size - 1;
    n.index_previous = elements[tail];
    elements[tail].index_next = n.index_array;
    tail = n.index_array;
    size++;
  }
  private void resizeBidirectional(boolean direction) { 
    // function to dynamically resize array,
    // if direction == true -> elements.length -> 2 x elements.length 
    // if false true -> elements.length -> 1/2 x elements.length
    Node[] newNode;
    if (direction) {
      newNode = (Node[]) Array.newInstance(Node.class, (elements.length * 2));
      for (int i = 0; i < elements.length; i++) {
        newNode[i] = elements[i]
      }
      elements = newNode;
    }
    else {
      newNode = (Node[]) Array.newInstance(Node.class, (elements.length / 2));
      for (int i = 0; i < elements.length; i++) {
        if 
        newNode[i] = elements[i]
      }
      elements = newNode;
    }
  }
  public void addFirst(E t) { 
    Node n = new Node(t);
    elements[size-1] = n;
    n.index_array = size - 1;
    n.index_next = elements[head];
    elements[head].index_previous = n.index_array;
    head = n.index_array;
    size++;
  }
  public void add(int index, E t) {
    Node n = new Node(t);
    Node m = elements[head];
    
    for (int i = 0; i < index; i++) {
      m = elements[m.index_next];
    }
    elements[size-1] = n;
    n.index_array = size - 1;
    n.index_previous = m.index_previous;
    elements[n.index_previous].index_next = n.index_array;
    n.index_next = m.index_array;
    m.index_previous = n.index_array;
    size++;
  } 
  public Integer size() {
    return size;
  } 
  public E get(int index) {
    // return element at index in the list
    Node n = elements[head];
    for (int i = 0; i < index; i++) {
      n = elements[n.index_next];
    }
  } 
  public E getFirst() {
    // return first element
    return head.data;
  } 
  public E getLast() {
    // return last element
    return last.data;
  } 
  public E removeLast() {
    // return last and remove it from the list
    Node n = elements[tail];
    elements[tail] = null;
    elements[n.index_previous].index_next = null;
    tail = elements[index_previous].index_array;
    size--;
  } 
  public E removeFirst() {
    // return first and remove it from the list
    Node n = elements[head];
    elements[head] = null;
    elements[n.index_next].index_previous = null;
    head = elements[index_next].index_array;
    size--;
  } 
  public E remove(int index) {
    // remove at index in the linked list
    Node n = elements[head];
    
    for (int i = 0; i < index; i++) {
      n = elements[n.index_next];
    }
    elements[n.index_array] = null;
    elements[n.index_previous].index_next = n.index_next;
    elements[n.index_next].index_previous = n.index_previous;
    size--;
    return n.data;

  }
  @Override
  public Iterator<E> iterator() { 
  // the following is an anonymous class 
    Iterator<E> it = new Iterator<E>() {
    private Integer currentIndex = tail; // "state" of the iterator - place where we are at right now
    @Override
    public boolean hasNext() { 
     // return true if there is another element after currentIndex
    } 
    @Override
    public E next() {
     // move to the next Node.data in the linked list starting from index 'currentIndex'
    }
    @Override
    public void remove() {
     throw new UnsupportedOperationException();  // No need to implement this.
    }
   };
  return it;
  }

}