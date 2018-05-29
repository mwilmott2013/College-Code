import java.util.Stack;

public class SuperStack<Item extends Comparable<Item>> {
	private Stack<Item> main; // main stack.
	
	private Stack<Item> max;  // helper stack, use to implement functions
	                          // using max element
	
	public SuperStack() {
	    main = new Stack<Item>();
	    max = new Stack<Item>();
	}
	
	public final Item pop () {
	    return main.pop();
	}
	
	public final Item peek () {
	    return main.peek();
	    }
	
	public final void push (final Item i) {
	    if (main.isEmpty() || i.compareTo(main.peek()) >= 0 ) {
	    	max.push(i);
	    }
	    main.push(i);
	}
	
	public final Stack<Item> getMainStack () {
	    return main;
	}
	
	public final Item max () {
	    return max.peek();
	}
	
	public final Item popMax () {
	    int pointer = max.size() - 1;
	    Item c = max.pop();
	    return c;
    }
	
	public final boolean isEmpty () {
		return main.isEmpty();
	}
	
}