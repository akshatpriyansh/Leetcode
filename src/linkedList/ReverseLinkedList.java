package linkedList;

public class ReverseLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode prev = head;
		ListNode curr = head.next;
		prev.next = null;
		
		while(curr.next != null) {
			ListNode n = curr.next;
			curr.next = prev;
			prev = curr;
			curr = n;
		}
	
		curr.next = prev;
		return curr;
		
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next =  new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode reversed = reverseList(head);
		while(reversed != null) {
			System.out.print(reversed.val + "->");
			reversed = reversed.next;
		}
	}
}


/**
 *  Do not make the mistake of setting a next node as null.
 *  For example, I was trying to first set the next pointer as null thinking it was the link that was getting destroyed.
 *  But actually it was the actual next node getting destroyed.
 *  
 *  Also make sure the first node is set to null. If it isn't set to null it will create a cycle from first to second node.
 */

