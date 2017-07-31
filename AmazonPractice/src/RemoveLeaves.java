import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class RemoveLeaves {
	
	TreeNode root;
	
	RemoveLeaves () {
		root = null;
	}
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode (int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public TreeNode insertRecursive (TreeNode root, int data) {
		TreeNode newNode = new TreeNode(data);
		if (root == null) return newNode;
		else if (data <= root.data) root.left = insertRecursive(root.left, data);
		else root.right = insertRecursive(root.right, data);
		return root;
	}
	
	public void inorderRecursive (TreeNode root) {
		if (root == null) return;
		inorderRecursive(root.left);
		System.out.print("\t"+root.data);
		inorderRecursive(root.right);
	}
	
	public void reverseLevelOrder (TreeNode root) {
		if (root == null) return;
		TreeNode current;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			current = q.remove();
			if (current.right != null) q.add(current.right);
			if (current.left != null) q.add(current.left);
			s.push(current);
		}
		while (!s.isEmpty()) {
			System.out.print("\t" + s.pop().data);
		}
	}
	
	public ArrayList<ArrayList<Integer>> findLeaves(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		findLeavesHelper(root,res);
		return res;
	}
	
	public int findLeavesHelper(TreeNode root, ArrayList<ArrayList<Integer>> res) {
		if (root == null) return -1;
		int height = Integer.max(findLeavesHelper(root.left, res), findLeavesHelper(root.right, res)) +1;
		if (res.size() == height) {
			res.add(new ArrayList<Integer>());
		}
		res.get(height).add(root.data);
		return height;
	}
	
	public TreeNode lowestCommonAncestor (TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null) return null;
		if ((root == n1) || (root == n2)) return root;
		TreeNode left = lowestCommonAncestor(root.left, n1, n2);
		TreeNode right = lowestCommonAncestor(root.right, n1, n2);
		if (left != null && right != null) return root;
		if (left == null && right == null) return null;
		return left!=null ? left :right;
	}
	
	public TreeNode lowestCommonAncestorBST (TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null) return null;
		if (root.data > Integer.max(n1.data, n2.data)) return lowestCommonAncestorBST(root.left, n1, n2);
		else if (root.data < Integer.min(n1.data, n2.data)) return lowestCommonAncestorBST(root.right, n1, n2);
		else return root;
	}
	
	public static void main (String args[]) {
		
		RemoveLeaves bt = new RemoveLeaves();
		bt.root = bt.insertRecursive(bt.root, 5);
		bt.insertRecursive(bt.root, 7);
		bt.insertRecursive(bt.root, 3);
		bt.insertRecursive(bt.root, 2);
		bt.insertRecursive(bt.root, 10);
		bt.insertRecursive(bt.root, 6);
		bt.insertRecursive(bt.root, 8);
		/*bt.inorderRecursive(bt.root);
		System.out.println();
		TreeNode lca = bt.lowestCommonAncestor(bt.root, bt.root.left.left, bt.root.right.right);
		TreeNode lcabst = bt.lowestCommonAncestorBST(bt.root, bt.root.left.left, bt.root.right.right);
		System.out.println("\t"+lca.data);
		System.out.println("\t"+lcabst.data);*/
		bt.reverseLevelOrder(bt.root);
	}
}
