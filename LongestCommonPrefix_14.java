package com.easy;

/**
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * author : quantin
 * date   : 15/7/19
 */
public class LongestCommonPrefix_14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1)
			return null;

		String str1 = strs[0];
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() - 1 < i)
					return strs[j];

				if (str1.charAt(i) != (strs[j].charAt(i))) {
					if (i > 0)
						return str1.substring(0, i);
					else
						return null;
				}
			}
		}

		return str1;
	}
}
