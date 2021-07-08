package Tree;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

//Solution
/* T-O(n) ; S-O(n) 
 * 1. The distance between nodes is equal to distance from each individual node from their LCA(least common ancestor).
 * 2. First find lca
 * 3. Then find individual node distances from that common LCA.
 * 4. return the sum of these sums.
 */
public class _1740_FindDistanceInABinaryTree {
	
	public static int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLca(root, p, q);
        int d1 = findLevel(lca, p, 0);
        int d2 = findLevel(lca, q, 0);
        return d1 + d2;
    }
	
	private static TreeNode findLca(TreeNode root, int p, int q){
        //base
        if(root==null)return null;
        //logic
        if(root.val == p || root.val == q)return root;
        TreeNode lValue = findLca(root.left,p,q);
        TreeNode rValue = findLca(root.right,p,q);
        if(lValue==null)return rValue;
        if(rValue==null)return lValue;
        return root;
	}
	
	public static int findLevel(TreeNode root, int a, int level){
        if (root == null) return -1;
        if (root.val == a) return level;
        
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
	}

}
