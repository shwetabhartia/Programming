public class MinSumPathBST {
	
	TreeNode root;
	
	MinSumPathBST() {
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
	
	
	public int minSumPath(BinaryTree.TreeNode root) {
		if(root == null) return 0;
		
		int sumPath = root.data;
		int left = minSumPath(root.left);
		int right = minSumPath(root.right);
		
		if (left <= right) {
			sumPath += minSumPath(root.left);
		} else {
			sumPath += minSumPath(root.right);
		}
		return sumPath;
	}

	
	public static void main (String args[]) {
		
		//SomeMoreTree smt = new SomeMoreTree();
		//smt.minSumPath(smt.root);
	}
	
	
}
