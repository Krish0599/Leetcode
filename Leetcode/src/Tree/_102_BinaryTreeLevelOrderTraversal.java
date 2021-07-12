package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Solution-1 - DFS
/*
 * 1) In this approach we are going to use recursion to go to every level i.e. from a particular node we will keep on going to 
 * every node and we will be storing the level of every node in a list at a particular index (i.e. every index is going to store 
 * the nodes at that particular level). after that we can iterate over the list and find the elements in level order.
 */

//Solution-2 - BFS
/*
 * In this solution (which is a iterative one) we are going to use queue and in each iteration over the queue we are going to 
 * pop out all the elements inside it and find their children and push those children in the node. so whatever are the popped 
 * out elements in one go are going to be the elements at a particular level.
 */
public class _102_BinaryTreeLevelOrderTraversal {
	
	/*
	 List<List<Integer>> result; // global list result
	   public List<List<Integer>> levelOrder(TreeNode root) {
	      result = new ArrayList<>(); // initializing result
	
	       if(root == null) // if no root
	           return result;
	
	       dfs(root, 0); // calling dfs function on root for level 0
	   return result;
	   }

	   private void dfs(TreeNode root, int level){
	       //base
	       if(root == null)
	           return;
	       //logic
	       if(result.size() == level) // if there is no list in result for current level
	           result.add(new ArrayList<>()); // add an empty list
	       result.get(level).add(root.val); // add current root value to result at that level
	
	       dfs(root.left,level+1); // calling dfs for left child
	       dfs(root.right,level+1);// calling dfs for right child
	   }
    */
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

        if(root == null) // no root
            return result;

        Queue<TreeNode> queue = new LinkedList<>(); // to process nodes in FIFO manner
        queue.add(root); // adding root to queue

        while(!queue.isEmpty()) // till queue is not empty
        {
            List<Integer> list = new ArrayList<>(); // create a list at each level
            int size = queue.size(); // calculating the size of the queue at that level
            for(int i = 0; i<size; i++) // processing the elements only of current level
            {
                TreeNode curr = queue.poll(); // polling front node out of queue
                list.add(curr.val); // adding value to temp list
                if(curr.left!=null) // checking if it has a left child
                    queue.add(curr.left); // adding it to queue
                if(curr.right!=null) // checking if it has a right child
                    queue.add(curr.right); // adding it to queue
            }
            result.add(list); // adding the resultant list to the final result list
        }

        return result; // returning result
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
