package StackCTC;

import java.util.Stack;

public class QueueUsingStack<T> {

	Stack<T> stackOldest, stackNewest;
	
	public QueueUsingStack() {
		stackOldest = new Stack<T>();
		stackNewest = new Stack<T>();
	}
	
	public int size() {
		return stackOldest.size() + stackNewest.size();
	}
	
	public void add(T val) {
		stackNewest.push(val);
	}
	
	public T remove() {
		if(stackOldest.isEmpty()){
			while (!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
		}
		return stackOldest.pop();
	}
	
	public T peek() {
		if (stackOldest.isEmpty()){
			while (!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
		}
		return stackOldest.peek();
	}
	
	public static void main(String[] args) {
		QueueUsingStack<Integer> qus = new QueueUsingStack<Integer>();
		qus.size();

	}
}
