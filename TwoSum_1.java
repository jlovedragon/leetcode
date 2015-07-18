package com.medium;

/*
No.1 Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */


import java.util.Arrays;
import java.util.HashMap;

/**
 * author : quantin
 * date   : 15/7/18
 */
public class TwoSum_1 {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int value = map.get(nums[i]);
				result[0] = value + 1;
				result[1] = i + 1;
				break;
			}
			else
				map.put(target - nums[i], i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] testNums = {-1, -2, -3, -4, -5};
		int target = -8;

		int[] result = twoSum(testNums, target);

		System.out.println(result[0] + " " + result[1]);
	}
}
