package com.easy;

import org.junit.Test;

/**
 * author : quantin
 * date   : 15/7/24
 */
public class CountandSay_38 {
	public String countAndSay(int n) {

		if (n < 1)
			return null;

		String result = "1";

		for (int i = 1; i < n; i++) {
			StringBuffer sb = new StringBuffer();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j-1))
					count++;
				else {
					sb.append(count);
					sb.append(result.charAt(j-1));
					count = 1;
				}
			}

			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
		}

		return result;

	}

	@Test
	public void test() {

		for (int i = 0; i < 10; i++)
			System.out.println(countAndSay(i));

	}
}
