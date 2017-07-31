import java.util.Stack;

public class LinkedList {

	Node head;
	
	LinkedList () {
		head = null;
	}
	
	static class Node {
		int data;
		Node next;
		
		Node (int d) {
			data = d;
			next = null;
		}
	}
		
	void insert (int data) {
		Node i = new Node(data);
		Node n = head;
		if( n != null) {
			while ( n.next != null) {
				n = n.next;
			}
			n.next = i;
		} else {
			head = i;
		}
	}
	
	void insertAfter (int p, Node n) {
		Node temp = head;
		while (temp.data != p) {
			temp = temp.next;
		}
		n.next = temp.next;
		temp.next = n;
	}
	
	void noOfNodes () {
		Node n = head;
		int count=0;
		while (n != null) {
			count++;
			n = n.next;
		}
		System.out.println("No of Nodes : " + count);
	}
	
	Node reverse (Node head) {
		if(head == null) {
			return null;
		}
		Node current, p, n;
		current = head;
		p = null;
		while (current != null) {
			n = current.next;
			current.next = p;
			p = current;
			current = n;
		}
		head = p;
		return head;
	}
	
	Node halfLinkedListReverse (Node head) {
		Node pre, slow, fast;
		slow = head;
		fast = head;
		pre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast == null) pre.next = reverse(slow);
		else slow.next = reverse(slow.next);	
		return head;
	}
	
	void printLinkedList (Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public void removeDuplicates(Node head) {
		
	}
	
	public int deleteKthLast (Node head, int k) {
		if (head == null) return 0;
		int count = 0;
		count = deleteKthLast(head.next, k) +1;
		if (count == k) System.out.println(head.data);
		return count;
	}
	
	public Node deleteKthLastIterative (Node head, int k) {
		Node p1,p2;
		p1=p2=head;
		
		for (int i =0; i<k; i++) {
			p1 = p1.next;
		}
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		System.out.println(p2.data);
		return p2;
	}
	
	public Node sumLists (Node ll1, Node ll2) {
		Node head = null; Node current = null;
		int carry = 0;
		while (ll1 != null || ll2 != null) {
			int x1 = (ll1 != null) ? ll1.data : 0;
			int x2 = (ll2 != null) ? ll2.data : 0;
			int sum = x1+x2+carry;
			int nodeValue = sum%10;
			carry = sum/10;
			Node newNode = new Node(nodeValue);
			if (head == null) {
				head = newNode;
				current = newNode;
			} else {
				current.next = newNode;
				current = newNode;
			}
			
			if (ll1 != null) ll1 = ll1.next;
			if (ll2 != null) ll2 = ll2.next;
		}
		if (carry != 0) {
			Node newNode = new Node(carry);
			current.next = newNode;
		}
		return head;
	}
	
	public boolean isPalindrome (Node head) {
        Node slow = head;
        Node fast = head;
        Stack<Integer> s = new Stack<Integer>();
        
        while (fast!=null && fast.next!=null) {
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
	
	public static void main ( String args []) {
		LinkedList llist = new LinkedList();
		llist.insert(8);
		llist.insert(5);
		llist.insert(9);
		LinkedList llist1 = new LinkedList();
		llist1.insert(9);
		llist1.insert(7);
		llist1.insert(6);
		/*llist.insertAfter(16, new Node(17));
		llist.insert(19);
		llist.insertAfter(19, new Node(20));
		llist.printLinkedList(llist.head);
		Node rev = llist.halfLinkedListReverse(llist.head);
		llist.printLinkedList(rev);
		llist.noOfNodes();
		llist.deleteKthLast(llist.head, 3);
		llist.deleteKthLastIterative(llist.head, 2);*/
		
		Node result = llist.sumLists(llist.head, llist1.head);
		llist.printLinkedList(result);
	}
}
