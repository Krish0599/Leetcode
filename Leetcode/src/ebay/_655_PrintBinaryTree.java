package ebay;

import java.util.ArrayList;
import java.util.List;

/*
Since building the resultant list while recursing through the tree is complicated and very time intensive, I approached this problem by breaking it into two parts:

Create the resultant list with empty strings
Traverse the tree while keeping track of the position and simply update the resultant list
*/
public class _655_PrintBinaryTree {
	
	static int maxheight = 0;
	public static List<List<String>> printTree(TreeNode root) {
		//step1: Calculate the odd width and height simply using bottom-up approach : width = 2*height+1;
		int m = calWidth(root,1);
	    int n = maxheight;
	    
	  //Step 2: Initialize the ArrayList have desired rows and columns;
        List<List<String>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String> l=new ArrayList<>();
            for(int j=0;j<m;j++){
                l.add("");
            }
            list.add(l);
        }
        
        helper(root,list,0,m-1,0);
        return list;
	}
	
	public static void helper(TreeNode root,List<List<String>> list,int start, int end,int curHeight){
        if(curHeight>=maxheight) return;
        if(root==null) return;
        int mid = start+ (end-start)/2;
        // System.out.println("start: "+start+" end: "+end+" mid: "+mid);
        // System.out.println("curHeight"+curHeight+" mid: "+mid+" root.val:"+root.val);
        list.get(curHeight).set(mid,root.val+"");
        helper(root.left,list,start,mid-1,curHeight+1);
        helper(root.right,list,mid+1,end,curHeight+1);
    }
	
	public static int calWidth(TreeNode root, int height){
        if(root==null)return 0;
        if(maxheight<height)maxheight = height;
        if(root.left==null && root.right==null)return 1;
        int leftHeight = calWidth(root.left,height+1);
        int rightHeight = calWidth(root.right,height+1);
        return 2*(Math.max(leftHeight,rightHeight))+1;
    }
	
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    System.out.println(printTree(root));
	}

}
