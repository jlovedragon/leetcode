package com.easy;

import org.junit.Test;

/**
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p/>
 * author : quantin
 * date   : 15/7/21
 */
public class MergeTwoSortedLists_21 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode p = new ListNode(0);
		ListNode result = p;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
			return result.next;
		} else {
			p.next = p2;
			return result.next;

		}
	}

	@Test
	public void test() {
		ListNode m1 = new ListNode(1);
//		ListNode m2 = new ListNode(3);
//		ListNode m3 = new ListNode(5);
//		ListNode m4 = new ListNode(7);
//		m1.next = m2;
//		m2.next = m3;
//		m3.next = m4;
//		m4.next = null;

		ListNode l1 = new ListNode(2);
//		ListNode l2 = new ListNode(4);
//		ListNode l3 = new ListNode(6);
//		ListNode l4 = new ListNode(8);
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = null;

		ListNode result = mergeTwoLists(m1, l1);

		System.out.println();
	}
}
