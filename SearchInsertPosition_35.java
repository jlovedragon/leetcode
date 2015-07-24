package com.medium;

import org.junit.Test;

/**
 * Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * author : quantin
 * date   : 15/7/24
 */
public class SearchInsertPosition_35 {
	public int searchInsert(int[] nums, int target) {

		if (nums == null || nums.length < 1)
			return 0;

		int low = 0;
		int high = nums.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (target < nums[mid])
				high = mid - 1;
			else if (target > nums[mid])
				low = mid + 1;
			else
				break;
		}

		if (nums[mid] >= target || high < 0)
			return mid;
		else
			return mid + 1;

	}

	@Test
	public void test() {
		int[] nums = new int[]{1,3,5,6};
		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 7));
		System.out.println(searchInsert(nums, 0));

	}
}
