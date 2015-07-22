package com.easy;

import org.junit.Test;

/**
 * Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 * author : quantin
 * date   : 15/7/21
 */
public class RemoveDuplicatesfromSortedArray_26 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length < 1)
			return 0;

		int index = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i-1]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}

	@Test
	public void test() {
		System.out.println(removeDuplicates(new int[]{1,1,2,2,3}));
	}
}
