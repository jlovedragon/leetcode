package com.easy;

import org.junit.Test;

/**
 * Implement strStr()
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * author : quantin
 * date   : 15/7/22
 */
public class ImplementStrstr_28 {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;


		if (needle.equals(""))
			return 0;

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			int index = i;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(index) != needle.charAt(j))
					break;
				index++;
				if (index - i == needle.length())
					return i;
			}
		}

		return -1;
	}

	@Test
	public void test() {
		System.out.println(strStr("a", ""));
	}
}
