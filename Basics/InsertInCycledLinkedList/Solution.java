package InsertInCycledLinkedList;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.testCase1();
		solution.testCase2();
		solution.testCase3();
		solution.testCase4();
		solution.testCase5();
		solution.testCase6();
		solution.testCase7();
		solution.testCase8();
		solution.testCase9();
		solution.testCase10();
	}
	
	public void testCase1() {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		node1.next = node3;
		node3.next = node1;
		insert(node1, 2);
		System.out.println(node1);
	}
	
	public void testCase2() {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		node1.next = node3;
		node3.next = node1;
		insert(node1, 4);
		System.out.println(node1);
	}
	
	public void testCase3() {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		node1.next = node3;
		node3.next = node1;
		insert(node1, 3);
		System.out.println(node1);
	}
	
	public void testCase4() {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		node1.next = node3;
		node3.next = node1;
		insert(node1, 1);
		System.out.println(node1);
	}
	
	public void testCase5() {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		node1.next = node3;
		node3.next = node1;
		insert(node1, -1);
		System.out.println(node1);
	}
	
	
	public void testCase6() {
		ListNode node_1 = new ListNode(-1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node_1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node_1;
	
		insert(node1, -1);
		System.out.println(node1);
	}
	
	public void testCase7() {
		ListNode node1 = new ListNode(1);
		node1.next = node1;
		insert(node1, 1);
		System.out.println(node1);
	}
	
	public void testCase8() {
		ListNode node1 = new ListNode(1);
		node1.next = node1;
		insert(node1, -1);
		System.out.println(node1);
	}
	
	public void testCase9() {
		ListNode node1 = new ListNode(1);
		ListNode node11 = new ListNode(1);
		ListNode node111 = new ListNode(1);
		node1.next = node11;
		node11.next = node111;
		node111.next = node1;
		insert(node1, 1);
		System.out.println(node1);
	}
	
	public void testCase10() {
		ListNode node1 = new ListNode(1);
		ListNode node11 = new ListNode(1);
		ListNode node111 = new ListNode(1);
		node1.next = node11;
		node11.next = node111;
		node111.next = node1;
		insert(node1, 3);
		System.out.println(node1);
	}
	
	public void insert(ListNode node, int val) {
		ListNode curr = node;
		ListNode next = node.next;
		while(next != node) {
			if(curr.val <= val && val <= next.val) { //middle
				ListNode newNode = new ListNode(val);
				curr.next = newNode;
				newNode.next = next;
				return;
			}
			else if(curr.val <= val && curr.val > next.val) { //larger than max and max > smallest
				ListNode newNode = new ListNode(val);
				curr.next = newNode;
				newNode.next = next;
				return;
			}
			else if (val <= next.val && curr.val > next.val) { //smaller than min and min < largest
				ListNode newNode = new ListNode(val);
				curr.next = newNode;
				newNode.next = next;
				return;
			}
			curr = next;
			next = next.next;
		}
		ListNode nextNode = new ListNode(val);
		curr.next = nextNode;
		nextNode.next = next;
	}
}
