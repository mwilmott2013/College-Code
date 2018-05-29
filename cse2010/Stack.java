import java.util.LinkedList;

public class Stack<Key> { 
	private LinkedList<Key> list; // the stack itself
	private int pointer = 0; // size of the stack.

	public Stack(){
		list=new LinkedList<Key>();
	}
	public void push(Key key) { 
		// add to the stack 
		list.addLast(key);
		pointer++;
	}
	public Key peek() {
		// return without removing
		Key item = list.getLast();
		return item;
	} 
	public Key pop() {
		// pop the element from the stack
		Key item = list.removeLast();
		pointer--;
		return item;		
	} 
	public boolean isempty() {
		// check if the stack has no elemens in it
		return pointer == 0;
	}
}