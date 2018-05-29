
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
			sb.append(data.toString() + " (" + index_previous + ", " + index_array + ", " + index_next + ")"); 
			return new String(sb);
		}

	}
	// hold all elements in this array 
	Node[] elements;
	// Initial size of the array. 
	private final int INITIAL_SIZE = 8;


	private Integer tail; // pointer to the tail 
	private Integer head; // these variable are optional
	private int current_index = 0; // index in the array to use when adding element 
	private int size = 0;
	@SuppressWarnings("unchecked") 
	public LinkedList() {
		// ugly cast is necessary as Java doesn’t 
		// allow creating generic arrays using 
		// E[] e = new E[10]; <- Does not work 
		elements =(Node[]) Array.newInstance(Node.class, INITIAL_SIZE); 
		tail = null; 
		head = null;
	}

	public boolean isEmpty() { 
		return size == 0;
	}

	public void addLast (E t) { 
		// add in the end 
	}

	private void resizeBidirectional (boolean direction) { 
		// function to dynamically resize array,
		// if direction == true -> elements.length -> 2 x elements.length 
		// if false true -> elements.length -> 1/2 x elements.length
	} 

	public void addFirst (E t) { 	
		// add in the beginning 	
	}
	
	public void add (int index, E t) {
		// add at index. 
		// Note that this is not an index in the array ’elements’, 
		// but rather in the linked list itself.
	}

	public Integer size () {
		// return size
	} 

	public E get (int index) {
		// return element at index in the list
	}

	public E getFirst () {
		// return first element
	}

	public E getLast () {
		// return last element
	}

	public E removeLast () {
		// return last and remove it from the list
	} 

	public E removeFirst () {
		// return first and remove it from the list
	}

	public E remove (int index) {
		// remove at index in the linked list
	}

	@Override 
	public Iterator<E> iterator () {
		// return iterator so that it was possible to iterate over elements // of the list
	}


}