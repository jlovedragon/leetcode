package com.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 *
 * author : quantin
 * date   : 15/7/19
 */
public class ContainerWithMostWater_11 {
	public int maxArea(int[] height) {

		if (height == null || height.length < 1)
			return 0;

		int maxArea = 0;
		int currentArea = 0;
		int begin = 0;
		int end = height.length - 1;
		int maxBegin = 0;
		int maxEnd = 0;

		while (begin < end) {
			if (height[begin] > maxBegin || height[end] > maxEnd) {
				currentArea = Math.min(height[begin], height[end]) * (end - begin);
				maxArea = Math.max(currentArea, maxArea);
				maxBegin = Math.max(height[begin], maxBegin);
				maxEnd = Math.max(height[end], maxEnd);
			}
			if (height[begin] < height[end]) {
//				maxBegin = Math.max(height[begin], maxBegin);
				begin++;
			} else {
//				maxEnd = Math.max(height[end], maxEnd);
				end--;
			}
		}

		return maxArea;
	}

	@Test
	public void test() {
		System.out.println(maxArea(new int[]{3,4,2,3,6,7,8,4}));
	}
}
