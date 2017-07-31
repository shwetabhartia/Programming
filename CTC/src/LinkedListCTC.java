import java.util.HashSet;

public class LinkedListCTC {

	Node head = null;
	
	static class Node {
		
		Node next = null;
		int data;
		
		Node (int d) {
			data = d;
		}
	}
	
	public void insert(int data) {
		Node n = new Node(data);
		Node i = head;
		if (i != null) {
			while (i.next != null) i = i.next;
			i.next = n;
		} else {
			head = n;
		}
	}
	
	public void print(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	/*2.1 Remove Dups : Remove Duplicate element from the unsorted list*/
	public void removeDuplicates (Node n) {
		if (n == null) return;
		Node prev = null;
		HashSet<Integer> set = new HashSet<Integer>();
		
		while (n != null) {
			if(set.contains(n.data)) {
				prev.next = n.next;
			} else {
				set.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}
	
	/*2.2 Return Kth to Last : Write an algorithm to return Kth to last element*/
	public Node kthToLast (Node head, int k) {
		if (head == null) return null;
		Node follow = head;
		Node current = head;
		
		for (int i=0; i<k; i++) {
			if (current != null) current = current.next;
			else return null;
		}
		
		while (current != null) {
			follow = follow.next;
			current = current.next;
		}
		return follow;
	}
	
	/*2.3 Delete Middle Node : Delete the middle node, given access to only that node, no Head node given.*/
	public void deleteNode (Node n){
		if (n == null || n.next == null) return;
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
	}
	
	/*2.4 Partition: */
	
	
	public void sumLists (Node n1, Node n2) {
		
	}
	
	public static void main (String args[]) {
		LinkedListCTC ll = new LinkedListCTC();
		ll.insert(1);ll.insert(3);ll.insert(5);ll.insert(4);ll.insert(1);ll.insert(7);
		ll.print(ll.head);
		ll.removeDuplicates(ll.head);
		ll.print(ll.head);
		Node n = ll.kthToLast(ll.head, 2);
		System.out.println(n.data);
		ll.deleteNode(ll.head.next.next);
		ll.print(ll.head);
	}
}
