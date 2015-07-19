package com.easy;

import org.junit.Test;

/**
 * String to Integer (atoi)
 *
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * author : quantin
 * date   : 15/7/19
 */
public class StringToInteger_8 {
	public int myAtoi(String str) {
		// 边界条件
		if (str == null || str.isEmpty())
			return 0;

		// 去掉空格
		str = str.trim();

		// 保存符号
		int flag = 0;
		int i = 0;
		if (str.charAt(i) == '+') {
			i++;
		} else if (str.charAt(i) == '-') {
			i++;
			flag = 1;
		}

		double result = 0;

		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == 1)
			result = -result;

		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int)result;
	}

	@Test
	public void test() {
		System.out.println(myAtoi("+12345"));
		System.out.println(myAtoi("-12345"));
		System.out.println(myAtoi("+-12345"));
		System.out.println(myAtoi("1000000003"));
		System.out.println(myAtoi(null));
		System.out.println(myAtoi("a111"));
	}
}
