package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * author : quantin
 * date   : 15/7/20
 */
public class ThreeSumCloset_16 {
	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3)
			return -1;

		int min = Integer.MAX_VALUE;
		int result = -1;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i-1]) {
				int start = i + 1;
				int end = nums.length - 1;

				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];

					if (sum == target)
						return target;
					else if (sum < target) {
						if (target - sum < min) {
							result = sum;
							min = target - sum;
						}
						start++;
					}
					else {
						if (sum - target < min) {
							result = sum;
							min = sum - target;
						}
						end--;
					}
				}
			}
		}

		return result;
	}

	@Test
	public void test() {
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
	}
}
