import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class BinaryTree {

	TreeNode root;
	
	BinaryTree () {
		root = null;
	}
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode (int d) {
			this.data = d;
			left = null;
			right = null;			
		}
	}
	
	public TreeNode insertIterative(TreeNode root, int data) {
		TreeNode tn = new TreeNode(data);
		TreeNode current, parent;
		if (root == null) return tn;
		else {
			parent = null;
			current = root;
			while (current != null) {
				parent = current;
				if (current.data <= data) 	current = current.right;
				else current = current.left;
			}
		}
		if (parent.data <= data) parent.right = tn;
		else parent.left = tn;
		return root;
	}
	
	public TreeNode serachBST (TreeNode root, int data) {
		TreeNode current;
		if (root == null) return null;
		else {
			current = root;
			while (current != null) {
				if (current.data == data) return current;
				else if (current.data < data) current = current.right;
				else current = current.left;
			}
		}
		return new TreeNode(-1);
	}
	
	public TreeNode findMinIterative (TreeNode root) {
		TreeNode current, prev;
		if (root == null) return null;
		else {
			prev = null;
			current = root;
			while(current != null) {
				prev = current;
				current = current.left;
			}
			return prev;
		}
	}
	
	public TreeNode deleteNode (TreeNode root, int data) {
		if (root == null) return root;
		else if (root.data < data) root.right = deleteNode(root.right, data);
		else if (root.data > data) root.left = deleteNode(root.left, data);
		else {
			if (root.left == null && root.right == null) return null;
			else if (root.left == null) {
				root = root.right;
				return root;
			} else if (root.right == null) {
				root = root.left;
				return root;
			} else {
				TreeNode temp = findMinIterative(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
                return root;
			}
		}
		return root;
	}
	
	public void preorderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) return;
		else {
			stack.push(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				System.out.print("\t"+root.data);
				if (root.right != null) stack.push(root.right);
				if (root.left != null) stack.push(root.left);
			}
		}
	}

	
	public void preorderRecursive(TreeNode root) {
		if (root == null) return;
		else {
			System.out.print("\t"+root.data);
			preorderRecursive(root.left);
			preorderRecursive(root.right);
		}
	}
	
	public void postorderIterative (TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = root;
		while (current != null || !s.isEmpty()) {
			if (current != null) {
				s.push(current);
				current = current.left;	
			} else {
				TreeNode temp = s.peek().right;
				if (temp == null) {
					temp = s.pop();
					System.out.print("\t"+temp.data);
					while (!s.isEmpty() && temp == s.peek().right) {
						temp = s.pop();
						System.out.print("\t"+temp.data);
					}
				} else current = temp;
			}
		}
	}
	
	public void BFS(TreeNode root) {
		if (root == null) return;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		TreeNode current;
		Q.add(root);
		while (!Q.isEmpty()) {
			current = Q.peek();
			System.out.print("\t"+current.data);
			if(current.left != null) Q.add(current.left);
			if(current.right != null) Q.add(current.right);
			Q.remove();
		}
	}
	
	public int findHeight (TreeNode root) {
		if (root == null) return -1;
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		return Integer.max(leftHeight, rightHeight) + 1;
	}
	
	public void verticalOrderTraversal (TreeNode root) {
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		int line = 0;
		verticalOrderHelper(root, line, tm);
		for (Map.Entry<Integer, ArrayList<Integer>> e : tm.entrySet()) {
			//System.out.println("Key: " + e.getKey()+ " Value: " + e.getValue());
			ret.add(e.getValue());
		}
		Iterator<ArrayList<Integer>> it = ret.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void verticalOrderHelper (TreeNode root, int line, TreeMap<Integer, ArrayList<Integer>> tm) {
		if (root == null) return;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (tm.containsKey(line)) temp = tm.get(line);
		temp.add(root.data);
		tm.put(line, temp);
		verticalOrderHelper(root.left, line - 1, tm);
		verticalOrderHelper(root.right, line + 1, tm);
	}
	
	public void levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        levelOrderHelper(root, 0, ret);
        System.out.println(ret);
        /*Iterator<List<Integer>> it = ret.iterator();
        while (it.hasNext()) {
        	System.out.println(it.next());
        }*/
        //return ret;
    }
	
	public void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> ret) {
        if (root == null) return;
        List<Integer> temp;
        if (ret.size() <= depth) {
        	temp = new ArrayList<Integer>();
            temp.add(root.data);
        	ret.add(temp);
        } else {
        	temp = ret.get(depth);
        	temp.add(root.data);
        	ret.set(depth, temp);
        }
        levelOrderHelper(root.left, depth+1, ret);
    	levelOrderHelper(root.right, depth+1, ret);
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) return ret;
        levelOrderBottomHelper(root, ret, 0);
        return ret;
    }
    
    public void levelOrderBottomHelper(TreeNode root, List<List<Integer>> ret, int level) {
        if (root == null) return;
        List<Integer> temp = new LinkedList<Integer>();
        if (ret.size() <= level) {
            ret.add(0, temp);
        }
        int lSize = ret.size()-level-1;
        temp = ret.get(lSize);
        temp.add(root.data);
        ret.set(lSize, temp);
        levelOrderBottomHelper(root.left, ret, level+1);
        levelOrderBottomHelper(root.right, ret, level+1);
    }
    
    public void BFSNewLine (TreeNode root) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	TreeNode current;
    	q.add(root);
    	q.add(null);
    	while (q.size() > 1) {
    		current = q.remove();
    		if (current == null) {
    			System.out.println();
    			q.add(null);
    		} else {
    			System.out.print(current.data);
    			if (current.left != null) q.add(current.left);
    			if (current.right != null) q.add(current.right);
    		}
    	}
    }
    
    public void leftView(TreeNode root){
    	if(root==null) return;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	
    	TreeNode current;
    	q.add(root);
    	q.add(null);
    	System.out.println(root.data);
    	while(q.size()>1){
    		current = q.remove();
    		if(current!=null){
    			if(current.left!=null) q.add(current.left);
    			if(current.right!=null) q.add(current.right);
    		}
    		else{
    			TreeNode temp = q.peek();
    			System.out.println(temp.data);
    			q.add(null);
    		}
    	}
    }
    
	public static void main (String args[]) {
		
		BinaryTree bt = new BinaryTree();
		bt.root = bt.insertIterative(bt.root, 5);
		bt.insertIterative(bt.root, 7);
		bt.insertIterative(bt.root, 3);
		bt.insertIterative(bt.root, 2);
		bt.insertIterative(bt.root, 10);
		bt.insertIterative(bt.root, 6);
		bt.insertIterative(bt.root, 8);
		/*bt.preorderRecursive(bt.root);
		bt.preorderIterative(bt.root);
		bt.postorderIterative(bt.root);
		bt.BFS(bt.root);
		TreeNode sn = bt.serachBST(bt.root, 9);
		System.out.println(sn.data);
		System.out.println(bt.findHeight(bt.root));*/
		//bt.verticalOrderTraversal(bt.root);
		bt.leftView(bt.root);
		
	}
	
}
