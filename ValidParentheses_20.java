package com.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * author : quantin
 * date   : 15/7/20
 */
public class ValidParentheses_20 {
	public boolean isValid(String s) {
		if (s == null || s.length() < 2)
			return false;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(')
				stack.push(ch);
			else if (ch == '}') {
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
			}
			else if (ch == ']') {
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
			}
			else if (ch == ')') {
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
			}
		}

		return stack.isEmpty();
	}

	@Test
	public void test() {
		System.out.println(isValid(")"));
	}
}
