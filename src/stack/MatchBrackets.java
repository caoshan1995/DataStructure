package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * <P>
 * Title: 这是一个简单的括号匹配方法
 * </P>
 * 
 * @author caoshan
 *
 */
public class MatchBrackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		char[] exp = S.toCharArray();
		System.out.println(matchBrackets(exp));
	}

	public static boolean matchBrackets(char exp[]) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '(') {
				stack.push(exp[i]);
			} else if (!stack.empty()) {
				stack.pop();
			} else
				return false;
		}
		return stack.empty();
	}
}
