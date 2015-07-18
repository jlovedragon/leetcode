package com.easy;

import org.junit.Test;

/**
 * ZigZag Conversion
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * <p/>
 * author : quantin
 * date   : 15/7/18
 */
public class ZigZag_Conversion_6 {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		StringBuffer sb = new StringBuffer();
		int unit = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j += unit)
					sb.append(s.charAt(j));
			} else {
				for (int j = i; j < s.length(); j += unit) {
					sb.append(s.charAt(j));
					int next = j + unit - 2 * i;
					if (next < s.length())
						sb.append(s.charAt(next));
				}
			}
		}

		return sb.toString();
	}

	@Test
	public void test() {
		System.out.println(convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
	}
}
