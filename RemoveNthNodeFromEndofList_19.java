package com.easy;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * author : quantin
 * date   : 15/7/19
 */
public class RemoveNthNodeFromEndofList_19 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		if (head.next == null && n >= 1)
			return null;

		LinkedList<ListNode> list = new LinkedList<>();
		ListNode p = head;

		while (p != null) {
			list.add(p);
			p = p.next;
		}

		int len = list.size();

		if (n == 1) {
			list.get(len-2).next = null;
		} else if (n == len) {
			head = head.next;
		} else {
			list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
		}
		return head;
	}

	public ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		if (fast.next == null)
			return head.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;
	}
}
