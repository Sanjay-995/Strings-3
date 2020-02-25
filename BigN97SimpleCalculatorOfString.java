import java.util.Stack;

// Time complexity is O(n)
// Space complexity is O(n)
// This solution is submitted on leetcode

public class BigN97SimpleCalculatorOfString {
	class Solution {
		public int calculate(String s) {
			// edge case
			if (s == null || s.length() == 0)
				return 0;
			int lastSign = '+';
			int num = 0;
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isDigit(c)) {
					num = num * 10 + (c - '0');
				}
				if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
					if (lastSign == '+')
						stack.push(+num);
					if (lastSign == '-')
						stack.push(-num);
					if (lastSign == '*')
						stack.push(stack.pop() * num);
					if (lastSign == '/')
						stack.push(stack.pop() / num);
					// reset after pushing all in stack
					lastSign = c;
					num = 0;
				}
			}
			int sum = 0;
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			return sum;
		}
	}
}