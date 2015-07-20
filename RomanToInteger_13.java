package com.easy;

import org.junit.Test;

/**
 * Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * author : quantin
 * date   : 15/7/20
 */
public class RomanToInteger_13 {
	public int romanToInt(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && (c2n(s.charAt(i-1)) < c2n(s.charAt(i)))) {
				result += c2n(s.charAt(i)) - 2 * c2n(s.charAt(i-1));
			}
			else {
				result += c2n(s.charAt(i));
			}
		}

		return result;

	}

	public int c2n(char c) {
		switch (c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	@Test
	public void test() {
		System.out.println(romanToInt("MMMCM"));
	}
}
