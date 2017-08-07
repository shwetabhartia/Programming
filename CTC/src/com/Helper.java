package com;
import com.LinkedListCTC.Node;

public class Helper {

	Node tail;
	int size;
	
	public Helper (Node tail, int size) {
		this.tail = tail;
		this.size = size;
	}
	
	static Helper getTailandSize(Node node) {
		int size = 0;
		Node n = node;
		
		while (n != null) {
			size++;
			n = n.next;
		}
		
		return new Helper(n,size);
	}
	
}
