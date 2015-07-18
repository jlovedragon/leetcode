package com.medium;

/*
Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * author : quantin
 * date   : 15/7/18
 */
public class LSWRC_3 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		boolean[] flag = new boolean[256];

		int result = 0;
		int start = 0;
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char current = arr[i];
			if (flag[current]) {
				result = Math.max(i - start, result);

				for (int k = start; k < i; k++) {
					if (arr[k] == current) {
						start = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}
			} else
				flag[current] = true;
		}

		result = Math.max(arr.length - start, result);

		return result;
	}
}
