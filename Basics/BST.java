import java.util.Stack;


public class BST {
	BST left;
	BST right;
	int val;
	
	public BST(){
		left = null;
		right = null;
		val = Integer.MIN_VALUE;
	}
	
	public BST(int val){
		left = null;
		right = null;
		this.val = val;
	}
	
	public void inOrder(BST node) {
		if (node == null) return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}
	
	public void preOrder(BST node){
		if(node == null) return;
		System.out.println(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(BST node){
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.val + " ");
	}
	
	public BST constructBST(int preorder[]) {
		if(preorder == null || preorder.length == 0) return null;
		return constructBST(preorder, 0, preorder.length);
	}
	//recursive, worst case o(n^2) (linked list), if balanced, o(nlog(n))
	//for every partition, do linear search through the partition to get new partition,
	public BST constructBST(int preorder[], int start ,int end) {
		if (start > end - 1) return null;
		if (start == end - 1) return new BST(preorder[start]);
		BST root = new BST(preorder[start]);
		int leftEnd = start + 1;
		while(leftEnd < end && preorder[leftEnd] < preorder[start]) leftEnd++;
		root.left = constructBST(preorder,start+1, leftEnd);
		//assuming always valid sequence
		root.right = constructBST(preorder,leftEnd, end);
		return root;
	}
	
	public BST construct(int preorder[]) {
		if(preorder == null || preorder.length == 0) return null;
		BST pre = null;
		BST preRoot = null;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(preorder[0]);
		for(int i = 1; i < preorder.length; i++){
			if(preorder[i] < stack.peek()) stack.push(preorder[i]);
			else{
				BST node = null;
				while(!stack.isEmpty() && preorder[i] > stack.peek()){
					node = new BST(stack.peek());
					stack.pop();
					node.left = pre;
					pre = node;
				}
				preRoot = pre;
				pre = null;
				stack.push(preorder[i]);
			}
		}
	}
	
	
	public static void main(String[] args){
		
	}
}
