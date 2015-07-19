package com.easy;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Reverse Integer
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * author : quantin
 * date   : 15/7/19
 */
public class ReverseInteger_7 {
	public int reverse(int x) {
		ArrayList<Integer> arrayList = new ArrayList();

		while (x != 0) {
			arrayList.add(x % 10);
			x = x / 10;
		}

		double sum = 0L;

		for (int i = 0; i < arrayList.size(); i++) {
			sum += (arrayList.get(i) * (Math.pow(10, arrayList.size() - 1 - i)));
		}

		if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
			return 0;

		return (int)sum;
	}

	public int reverse1(int x) {
		int result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println(reverse1(1000000003) == 0);
		System.out.println(reverse1(12345) == 54321);
		System.out.println(reverse1(-12345) == -54321);
	}
}
