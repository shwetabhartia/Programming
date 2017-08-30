package StackCTC;

import java.util.Stack;

public class SortStack {

	public Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> helperStack = new Stack<Integer>();
		while(!s.isEmpty()) {
			int curr = s.pop();
			while(!helperStack.isEmpty() && helperStack.peek() > curr) {
				s.push(helperStack.pop());
			}
			helperStack.push(curr);
		}
		return helperStack;
	}
	
	public static void main(String arg[]) {
		
	}
}
