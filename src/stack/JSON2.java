package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * 该类主要是用于检测简单的JSON语法
 * 
 * @author caoshan
 *
 */
public class JSON2 {

	static int error[] = new int[5];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();// 输入一个JSON串

		Stack<Character> stack = new Stack<>(); // 主栈，扫描S，存储左边括号及引号
		Stack<Character> temp = new Stack<>(); // 副栈，用于存储暂时无法与主栈匹配的括号

		// 开始必然是"{"开头
		if (S.charAt(0) != '{') {
			error[2] = 1;
		}

		// for循环是用于扫描一次S串
		for (int i = 0; i < S.length(); i++) {
			// 扫描到左括号，入主栈
			if (S.charAt(i) == '{' || S.charAt(i) == '[') {
				stack.push(S.charAt(i));
			} else if (S.charAt(i) == '"') {
				// 扫描到第二个引号,应该判断后方是否有逗号,然后弹出两个引号。
				if (stack.peek() == '"') {
					if (i + 1 < S.length() && S.charAt(i + 1) == '"') {
						error[4] = 1;// error[4]表示遗失逗号
					}
					stack.pop();
				} else
					stack.push(S.charAt(i));
			} else if (S.charAt(i) == '}') {
				// 扫描到右大括号，先判断后一个符合是否为左大括号，如果是，则遗失逗号，否则，判断当前栈顶元素是否为左大括号
				// 如果不是，则入temp，是则括号匹配，弹出
				if (i + 1 < S.length() && S.charAt(i + 1) == '{') {
					error[4] = 1;
				}
				if (stack.peek() == '{')
					stack.pop();
				else
					temp.push(S.charAt(i));
			} else if (S.charAt(i) == ']') {
				// 扫描到右中括号，先判断后一个符合是否为引号，如果是，则遗失逗号，否则，判断当前栈顶元素是否为左大括号
				// 如果不是，则入temp，是则括号匹配，弹出
				if (i + 1 < S.length() && S.charAt(i + 1) == '"') {
					error[4] = 1;
				}
				if (stack.peek() == '[')
					stack.pop();
				else
					temp.push(S.charAt(i));
			}
		}

		System.out.println(stack);
		System.out.println(temp);
		Object[] ch = stack.toArray();
		// while (!temp.empty()) {
		// 判断，副栈是否还有元素能够和主栈匹配
		for (int i = 0; !temp.empty()&&i < ch.length; i++) {
			if (isMatch(temp.peek(), (char) ch[i])) {
				temp.pop();
				stack.removeElementAt(i);
			}
		}
		// temp.pop();
		// }
		while (!stack.empty()) {
			switch (stack.pop()) {
			case '[':
			case ']':
				error[1] = 1;
				break;
			case '{':
			case '}':
				error[2] = 1;
				break;
			case '"':
				error[3] = 1;
				break;
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(error[i]);
		}
	}

	private static boolean isMatch(Character a, Character b) {
		if (a == '[' && b == ']')
			return true;
		if (a == '{' && b == '}')
			return true;
		if (a == ']' && b == '[')
			return true;
		if (a == '}' && b == '{')
			return true;
		return false;
	}

}
