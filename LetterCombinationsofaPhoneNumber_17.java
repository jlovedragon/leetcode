package com.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * author : quantin
 * date   : 15/7/20
 */
public class LetterCombinationsofaPhoneNumber_17 {
	public List<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0)
			return result;

		ArrayList<String> list = new ArrayList<>();
		list.add("0");
		list.add("1");
		list.add("abc");
		list.add("def");
		list.add("ghi");
		list.add("jkl");
		list.add("mno");
		list.add("pqrs");
		list.add("tuv");
		list.add("wxyz");

		ArrayList<Character> temp = new ArrayList<Character>();
		dfs(digits, temp, result, list);

		return result;
	}

	public void dfs(String digits, ArrayList<Character> temp, ArrayList<String> result, ArrayList<String> list) {
		if (digits.length() == 0) {
			char[] arr = new char[temp.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp.get(i);
			}
			result.add(String.valueOf(arr));
			return;
		}

		Integer curr = Integer.parseInt(digits.substring(0,1));
		String letters = list.get(curr);
		for (int i = 0; i < letters.length(); i++) {
			temp.add(letters.charAt(i));
			dfs(digits.substring(1), temp, result, list);
			temp.remove(temp.size() - 1);
		}
	}
}
