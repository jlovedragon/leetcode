package com.medium;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * author : quantin
 * date   : 15/7/20
 */
public class ThreeSum_15 {


	// 会出现Time Limit Exceeded问题，原因是map.containsKey也是线性的
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3)
			return null;

		List<List<Integer>> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i-1]) {
				for (int j = i + 1; j < nums.length; j++) {
					if (map.containsKey(nums[j])) {
						List<Integer> item = new ArrayList<Integer>();
						item.add(nums[i]);
						item.add(Math.min(nums[j], -nums[i] - nums[j]));
						item.add(Math.max(nums[j], -nums[i] - nums[j]));
						result.add(item);
					} else
						map.put(-nums[i] - nums[j], i);
				}
				map.clear();
			}
		}

		return result;
	}

	// 采用头尾指针的方式
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i-1]) {
				int start = i + 1;
				int end = nums.length - 1;
				int target = -nums[i];

				while (start < end) {
					if (nums[start] + nums[end] > target)
						end--;
					else if (nums[start] + nums[end] < target)
						start++;
					else {
						ArrayList<Integer> item = new ArrayList<>();
						item.add(nums[i]);
						item.add(nums[start]);
						item.add(nums[end]);
						result.add(item);
						start++;
						end--;
						while (start < end && nums[end] == nums[end + 1])
							end--;

						while (start < end && nums[start] == nums[start - 1])
							start++;
					}
				}
			}
		}

		return result;
	}

	@Test
	public void test() {
		System.out.println(threeSum1(new int[]{-1,0,1,2,-1,-4}));
	}
}
