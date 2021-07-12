package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {
	
	static List<Integer> result;
	private static List<Integer> inorderTraversal(Node root){
		result = new ArrayList<>();
		dfs(root);
		return result;
	}
	
	private static void dfs(Node root) {
		//base
		if(root == null)return;
		//logic
		dfs(root.left);
		result.add(root.val);
		dfs(root.right);
	}
	
	
	/*
	private static List<Integer> inorderTraversal(Node root){
		List<Integer> result = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		while(root != null || !st.isEmpty()) {
			while(root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			result.add(root.val);
			root = root.right;
		}
		return result;
	}
	*/

	public static void main(String[] args) {
		Node root = new Node();
		root = new Node(1);
		root.left = null;
		root.right = new Node(2);
		root.right.left = new Node(3);
		
		List<Integer> result = inorderTraversal(root);
		System.out.println(result);
	}
}

class Node {
      int val;
      Node left;
      Node right;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}