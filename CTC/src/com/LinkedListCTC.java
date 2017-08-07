package com;
import java.util.HashSet;
import java.util.Stack;

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
	
	/*2.4 Partition: Given a number, partition the list around that number.*/
	public Node partitionList (Node n, int num) {
		if(n == null) return null;
		
		Node beforeStart = null;
		Node afterStart = null;
		Node beforeEnd = null;
		Node afterEnd = null;
		
		while (n != null) {
			Node next = n.next;
			n.next = null;
			
			if (n.data < num) {
				if (beforeStart == null) {
					beforeStart = n;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = n;
					beforeEnd = n;
				}
			} else {
				if (afterStart == null) {
					afterStart = n;
					afterEnd = afterStart;
				} else {
					afterEnd.next = n;
					afterEnd = n;
				}
			}
			n = next;
		}
		
		if (beforeStart == null) return afterStart;
		else {
			beforeEnd.next = afterStart;
			return beforeStart;
		}
	}
	
	/*2.5 Sum Lists : Sum the two linked lists, first node have the least significant bit(unit digit)*/
	public Node sumLists (Node n1, Node n2) {
		int carry = 0;
		Node dummyHead = new Node(0);
		Node p = n1, q = n2, curr = dummyHead;
		
		while (p != null || q != null) {
			int x = p != null ? p.data : 0;
			int y = q != null ? q.data : 0;
			int sum = x+y+carry;
			carry = sum/10;
			
			curr.next = new Node(sum%10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		
		if (carry > 0) curr.next = new Node(carry);
		return dummyHead.next;
		
	}
	
	/*2.6 Palindrome : Implement an algorithm to check if linked list is a palindrome.*/
	public boolean isPalindrome (Node n) {
		Node slow = head;
		Node fast = head;
		
		Stack<Integer> s = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			s.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) slow = slow.next;
		
		while (slow != null) {
			if (s.pop() != slow.data) return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	/*2.7 Intersection: Given two linked lists, find a intersection point and return it.*/
	
	public Node findIntersection (Node n1, Node n2) {
		if (n1 == null || n2 == null) return null;
		
		Helper r1 = Helper.getTailandSize(n1);
		Helper r2 = Helper.getTailandSize(n2);
		
		if (r1.tail != r2.tail) return null;
		
		Node shorter = r1.size < r2.size ? n1 : n2;
		Node longer = r1.size < r2.size ? n2 : n1;
		
		longer = moveKthNode(longer, Math.abs(r1.size - r2.size));
		
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return shorter;//longer;
	}
	
	/*2.8 Given a circular list, detect the beginning of loop and return that node.*/
	public Node detectLoop(Node head) {
		if (head == null) return null;
		
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}
		
		if (fast == null || fast.next == null) return null;
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;//slow;
	}
	
	/*Helper function for LinkedList - START */
	
	public Node moveKthNode(Node head, int k) {
		Node n = head;
		while (k>0) {
			n = n.next;
			k--;
		}
		return n;
	}
	
	/*Helper function for LinkedList - END*/
	
	
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
		LinkedListCTC llPalin = new LinkedListCTC();
		llPalin.insert(1);llPalin.insert(2);llPalin.insert(1);//llPalin.insert(3);
		System.out.println(llPalin.isPalindrome(llPalin.head));
	}
}
