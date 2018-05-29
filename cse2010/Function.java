import java.util.ArrayList;
import java.util.Stack;

public class Function {
	private String stringExpression; // string representation of the function 
	private boolean notation; // if true - infix, postfix otherwise. 
	ArrayList<String> variables;
	// list of variables the function depends on 
	// For example: if stringExpression = "2 * x ^ y" 
	// then variables =["x","y"]
	private double precision = 0.00001; // precision when finding root of the equation
	// Since there may be 0 or more variables in the expression 
	// we use syntax ’String... vars’ 
	// See more: 
	//http://stackoverflow.com/questions/2330942/java-variable-number-or-arguments-for-a-method 
	public Function(String inputExpression, String... vars) {
		this.stringExpression = inputExpression; 
		this.notation = true;
		variables = new ArrayList<String>(vars.length); 
		for (String var : vars) {
			variables.add(var);
		}
	}
	public void setExpression(String expression) { 
		this.stringExpression = expression; 
	}
	public void setNotation(boolean notation) {
		this.notation = notation;
	}
	public String getExpression() { 
		return stringExpression; 
	}
	public boolean getNotation() {
		return notation; 
	}
	public void infixToPostfix() {
		// convert from infix to postfix notation
		StringBuilder sb = new StringBuilder();
		int index = 0;
		Stack<E> o = new Stack();
		char k;
		if (notation) {
			while (index < stringExpression.length()) {
				k = stringExpression.charAt(index);
				if ((k.matches("[(^*/+-)]")) {
					if (o.isEmpty() || ((o.peek()).compareTo("(")) 
							|| k.matches("[(]")) {
						o.push(k);
					}
					if (k.matches("[)]")) {
						while (!(o.peek().matches("[(]"))) {
							sb.append(o.pop());
						}
						o.pop();
					}
					else {
						int e1 = checkPrecedence(variables.get(index));
						int e2 = checkPrecedence(o.peek());
						if (e1 < e2) {
							o.push(k);
						} else {
							sb.append(o.pop());
							o.push(k);
						}
					}
					index++;
				} else { 
					sb.append(variables.get(index));
					index++;
				}
			}
			setExpression(sb.toString());
			setNotation(false);
		}
	}

	public double evaluate(Double... vars_values) {
		// Substitute each variables in the expression with values from 
		// vars_values and evaluate it. 
	}
 
	public void postfixToInfix() {
		// convert back from postfix to infix, if the expression is already in 
		// infix do nothing
		if (!notation) { // all functions happen in here
			StringBuilder sb = new StringBuilder;
			int index = 0;
			Stack<E> o = new Stack();
			char k;
			while (index < stringExpression.length()) {
				k = stringExpression.charAt(index);
				if (!k.matches("[(^*/+-)]")) {
					o.push(k);
				}
			}
		}
	} 
	public String toString(){
		String notation ="infix"; 
		if (!this.getNotation()) { 
			notation="postfix"; 
		}
		String res="[ Notation: "+notation+" ] Expression: " +
				""+this.stringExpression; return res;
	}
	public double partialDerivative(int location, double... args){ 
		// Calculate partial derivative for variable
		// variable.get(location) around the 
		// point given by vector args. 
		// More on derivatives:  
		// https://en.wikipedia.org/wiki/Derivative 
		// You may set h = 0.000001
	}
	public double findRoot(double x0){	
		// find root using Newton’s method.
		// https://en.wikipedia.org/wiki/Newton%27s_method 
		// You can assume that if this function 
		// is called variables array list has only 1 element.	
	}



	public double[] gradient(double... args){
		// calculate gradient, i.e. calculate vector 
		// of partial derivatives for 
		// all variables
	}
// taken from http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places 
	public static double round(double value, int places) { 
		if (places < 0) throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(value); 
		bd = bd.setScale(places, RoundingMode.HALF_UP); 
		return bd.doubleValue(); 
	}
	public int checkPrecedence (E c) {
		char[] pemdas = new char['^', '*', '/', '+', '-'];
		int x = 5;
		for (int i = 0; i < pemdas.length(); i++) {
			if (c.compareTo(pemdas[i])) {
				x = i;
			}
		}
		return i;
	}
	public static boolean isNumeric (char c)  {  
		try  {  
			double d = Double.parseDouble(c);  
		}  
		catch (NumberFormatException nfe)  {  
			return false;  
		}  
		return true;  
	}


}

