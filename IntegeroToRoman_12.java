package com.medium;

import org.junit.Test;

import java.util.ArrayList;

/**
 * author : quantin
 * date   : 15/7/20
 */
public class IntegeroToRoman_12 {
	public String intToRoman(int num) {

		if (num <= 0)
			return null;

		StringBuffer sb = new StringBuffer();
		String[] one = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String[] ten = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] hundred = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] thousand = {"M", "MM", "MMM"};

		int div = 1;
		while (num / div >= 10) {
			div *= 10;
		}

		while (num != 0) {
			int index = num / div;

			if (index == 0) {
				div /= 10;
				continue;
			}

			// 位数不同，表示方法就不同
			if (div == 1000) {
				sb.append(thousand[index-1]);
			} else if (div == 100) {
				sb.append(hundred[index-1]);
			} else if (div == 10) {
				sb.append(ten[index-1]);
			} else {
				sb.append(one[index-1]);
			}

			num %= div;
			div /= 10;
		}

		return sb.toString();
	}

	@Test
	public void test() {
		System.out.println(intToRoman(2309));
	}
}
