package com.easy;

/**
 * Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length
 *
 * author : quantin
 * date   : 15/7/21
 */
public class RemoveElement_27 {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length < 1)
			return 0;

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}
}
