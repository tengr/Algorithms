package InsertInCycledLinkedList;

public class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(val);
			sb.append(" ");
			ListNode curr = this;
			while(curr.next != this && curr.next != null) {
				curr = curr.next;
				sb.append(curr.val);
				sb.append(" ");
			}
			return sb.toString();
		}
	}

