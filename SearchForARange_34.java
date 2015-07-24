package com.medium;

import org.junit.Test;

/**
 * Search for a Range
 *
 * author : quantin
 * date   : 15/7/24
 */
public class SearchForARange_34 {
	public int[] searchRange(int[] nums, int target) {

		if (nums == null || nums.length < 1)
			return null;

		int[] result = new int[]{-1, -1};

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

		// 没找着则直接返回
		if (nums[mid] != target) {
			return result;
		}

		int start = mid;
		int end = mid;

		result[0] = start;
		result[1] = end;

		while (start > low && nums[start] == nums[start-1]) {
			start--;
			result[0] = start;
		}

		while (end < high && nums[end] == nums[end+1]) {
			end++;
			result[1] = end;
		}

		return result;
	}

	@Test
	public void test() {
		int[] result = searchRange(new int[]{1}, 0);

		System.out.println(result[0] + " " + result[1]);
	}
}
