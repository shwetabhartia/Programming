package StackCTC;

import java.util.Stack;

public class MinStackCTC {

	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public void push(int x) {
		if (x <= min()) {
			s2.push(x);
		}
		s1.push(x);
	}
	
	public int pop() {
		if (s1.peek() == min()) s2.pop();
		return s1.pop();
	}
	
	public int min() {
		if (s2.isEmpty()) return Integer.MAX_VALUE;
		else return s2.peek();
	}
	
	
	public static void main(String[] args) {
		MinStackCTC ms = new MinStackCTC();
		ms.push(5); ms.push(1); ms.push(2);
	}

}
