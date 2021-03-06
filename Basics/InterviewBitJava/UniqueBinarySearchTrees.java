package InterviewBitJava;

import java.util.ArrayList;

public class UniqueBinarySearchTrees {
	public static void main(String[] args){
		UniqueBinarySearchTrees ins = new UniqueBinarySearchTrees();
		ArrayList<TreeNode> res = ins.generateTrees(3);
		ins.printResult(res);
	}
	
	 class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	  }
	 
	 public void postOrder(TreeNode node) {
		 if(node == null) return;
		 postOrder(node.left);
		 postOrder(node.right);	 
		 System.out.print(node.val + " ");

	}
	 
	 public void printResult(ArrayList<TreeNode> roots) {
		 for(TreeNode root : roots) {
			 postOrder(root);
			 System.out.println("---------");
		 }
		 
	 }
	 
	 public ArrayList<TreeNode> generateTrees(int a) {
		    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		    int[] nums = new int[a]; for(int i = 0; i < a; i++) nums[i] = i + 1;
		    dfs(res, nums, null, 0);
		    return res;
		    
		}
		
		public void dfs(ArrayList<TreeNode> res, int[] nums, TreeNode root, int size) {
		    if(size == nums.length) {
		        res.add(root);
		        return;
		    }
		    if(root == null) {
		        for(int i = 0; i < nums.length; i++) {
	    	        root = new TreeNode(nums[i]);
	    	        nums[i] *= -1;
	    	        dfs(res, nums, root, 1);
	    	        nums[i] *= -1;
		        }
		    }
		    else {
		        for(int i = 0; i < nums.length; i++) {
		            if (nums[i] < 0) continue;
		            TreeNode node = root;
		            while(true) {
	    	            if(nums[i] < node.val) {
	    	                if (node.left == null) {
	    	                    node.left = new TreeNode(nums[i]);
	    	                    break;
	    	                }
	    	                else node = node.left;
	    	            }
	    	            else if(nums[i] > node.val){
	    	                if (node.right == null) {
	    	                    node.right = new TreeNode(nums[i]);
	    	                    break;
	    	                }
	    	                else node = node.right;
	    	           }
	    	           else break;
		            }
	    	       nums[i] *= -1;
	    	       dfs(res, nums, root, size + 1);
	    	       nums[i] *= -1;
		        }
		    }
		}
	 
}
