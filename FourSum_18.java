package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * author : quantin
 * date   : 15/7/21
 */
public class FourSum_18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return result;
		}

		// 先排序
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			// 避免重复
			if (i == 0 || nums[i-1] < nums[i]) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					// 避免重复
					if (j == (i + 1) || nums[j-1] < nums[j]) {
						int start = j + 1;
						int end = nums.length - 1;

						while (start < end) {
							int sum = nums[i] + nums[j] + nums[start] + nums[end];
							if (sum == target) {
								ArrayList<Integer> item = new ArrayList<Integer>();
								item.add(nums[i]);
								item.add(nums[j]);
								item.add(nums[start]);
								item.add(nums[end]);
								result.add(item);
								start++;
								end--;
								// 避免重复
								while (start < end && nums[start] == nums[start-1])
									start++;
								while (start < end && nums[end] == nums[end+1])
								    end--;
							}
							else if (sum < target) {
								start++;
							}
							else {
								end--;
							}
						}
					}
				}
			}
		}

		return result;
	}

	@Test
	public void test() {
		System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
	}
}
