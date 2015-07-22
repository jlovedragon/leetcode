package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * author : quantin
 * date   : 15/7/21
 */
public class GenerateParentheses_22 {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();

		if (n < 1)
			return result;

		dfs(result, "", n, n);

		return result;
	}

	public void dfs(ArrayList<String> result, String s, int left, int right) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0)
			dfs(result, s + "(", left - 1, right);

		if (right > 0)
			dfs(result, s + ")", left, right - 1);
	}

	@Test
	public void test() {
		System.out.println(generateParenthesis(3));
	}
}
