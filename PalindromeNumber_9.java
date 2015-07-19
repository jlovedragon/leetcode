package com.easy;

import org.junit.Test;

/**
 * Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * author : quantin
 * date   : 15/7/19
 */
public class PalindromeNumber_9 {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		// 拿到最高位数
		int div = 1;
		while (x / div >= 10)
			div *= 10;

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div /= 100;
		}

		return true;
	}

	@Test
	public void test() {
		System.out.println(isPalindrome(-112223));
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(1000000001));
		System.out.println(isPalindrome(-2147447412));
		System.out.println(Integer.MIN_VALUE);

	}
}
