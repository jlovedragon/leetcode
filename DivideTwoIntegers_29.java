package com.medium;

import org.junit.Test;

/**
 * Divide Two Integers
 *
 * author : quantin
 * date   : 15/7/22
 */
public class DivideTwoIntegers_29 {
	public int divide(int dividend, int divisor) {
		if(divisor==0) return Integer.MAX_VALUE;
		if(divisor==-1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;

		int flag1 = (dividend > 0) ? 1 : 0;
		int flag2 = (divisor > 0 ) ? 1 : 0;

		dividend = (dividend > 0) ? dividend : (-dividend);
		divisor = (divisor > 0) ? divisor : (-divisor);

		int result = 0;
		while(dividend>=divisor){
			//calculate number of left shifts
			int numShift = 0;
			while(dividend>=(divisor<<numShift)){
				numShift++;
			}

			//dividend minus the largest shifted divisor
			result += 1<<(numShift-1);
			dividend -= (divisor<<(numShift-1));
		}

		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		return (flag1 == flag2) ? (int)result : -(int)result;
	}

	@Test
	public void test() {
		System.out.println(divide(100, -1));
	}
}
