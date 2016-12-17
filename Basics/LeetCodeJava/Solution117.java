package LeetCodeJava;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution117 {
	/**
	 *Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	 public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
    public void connect(TreeLinkNode root) {
        TreeLinkNode next = null;
        while(root != null) {
            if(root.left != null) {
                getNextNode(root.left, root);
                if(next == null) next = root.left;
            }
            if(root.right != null) {
                getNextNode(root.right, root);
                if(next == null) next = root.right;
            }
            root = root.next;
            if(root == null) {
                root = next;
                next = null;
            }
        }
    }
    public void getNextNode(TreeLinkNode node, TreeLinkNode parent) {
        if(node == null) return;
        if(parent.left == node && parent.right != null) {
            node.next = parent.right;
            return;
        } 
        node.next = getNextLevel(parent.next);
    }
    
    public TreeLinkNode getNextLevel(TreeLinkNode parent) {
        while(parent != null) {
            if(parent.left != null) return parent.left;
            if(parent.right != null) return parent.right;
            parent = parent.next;
        }
        return null;
    }
}
