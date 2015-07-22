package com.medium;

import org.junit.Test;

/**
 * Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * author : quantin
 * date   : 15/7/21
 */
public class SwapNodesinPairs_24 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = new ListNode(0);
		ListNode result = p;


		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode p3 = p2;

		while (p1 != null) {
			if (p1.next.next == null) {
				p1.next = null;
				break;
			}
			p1.next = p1.next.next;
			p1 = p1.next;

			if (p2.next.next == null) {
				p2.next = null;
				break;
			}
			p2.next = p2.next.next;
			p2 = p2.next;
		}

		ListNode q1 = head;
		ListNode q2 = head.next;
		ListNode q3 = p3;
		result = q3;
		ListNode q4 = p3.next;

		while (q3 != null) {
			q3.next = q1;
			if (q4 == null)
				break;
			q1.next = q4;
			if (q2 == null)
				break;
			q1 = q2;
			q2 = q1.next;

			q3 = q4;
			q4 = q3.next;
		}

		return result;
	}

	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;

		ListNode result = swapPairs(l1);

		System.out.println();
	}
}
