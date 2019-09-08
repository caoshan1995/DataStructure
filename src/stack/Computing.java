package stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * <P>
 * Title: 计算器
 * </P>
 * 
 * @Description (1)构造一个计算器,给定一个正确的中缀表达式,计算出它的值.<br/>
 *              (2)在构造一个计算器的过程中,可以将其转换为后缀表达式.
 * @author caoshan
 *
 */
public class Computing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S1 = sc.nextLine();
		char[] S = new char[S1.length() + 1];

		System.arraycopy(S1.toCharArray(), 0, S, 0, S1.length());

		S[S1.length()] = '\0';
		String RPN = "";
		System.out.println(evaluate(S, RPN));
	}

	/**
	 * 
	 * @param S   中缀表达式
	 * @param RPN 将会生成后缀表达式
	 * @return 返回中缀表达式的计算结果
	 */
	public static float evaluate(char S[], String RPN) {
		// 使用两个栈分别存储数字和字符
		Stack<Float> opnd = new Stack<>();// 运算数栈
		Stack<Character> optr = new Stack<>();// 运算符栈
		optr.push('\0');// 先压入一个哨兵
		int i = 0;
		while (!optr.empty()) {
			if (Character.isDigit(S[i])) {
				i = readNumber(S, i, opnd);// 有可能该数字不是个位数,而是两位数,三位数什么的
				RPN += opnd.peek().toString();
			} else
				switch (orderBetween(optr.peek(), S[i])) {// 比较操作符的优先级,栈顶优先级小于当前的,则压入栈,否则弹出栈顶元素开始计算。
				case '<':
					optr.push(S[i]);
					i++;
					break;
				case '=':
					optr.pop();
					i++;
					break;
				case '>': {
					char op = optr.pop();
					RPN += op;
					if ('!' == op)
						opnd.push(calcu(op, opnd.pop()));
					else {
						float pOpnd2 = opnd.pop();
						float pOpnd1 = opnd.pop();
						opnd.push(calcu(pOpnd1, op, pOpnd2));
					}
				}
					break;
				}

		}
		System.out.println(RPN);
		return opnd.pop();
	}

	private static Float calcu(float pOpnd1, char op, float pOpnd2) {
		switch (op) {
		case '+':
			return pOpnd1 + pOpnd2;
		case '-':
			return pOpnd1 - pOpnd2;
		case '*':
			return pOpnd1 * pOpnd2;
		case '/':
			if (pOpnd2 == 0)
				return (float) 0;
			else
				return pOpnd1 / pOpnd2;
		default:
			break;

		}
		return (float) 0;
	}

	private static Float calcu(char op, Float pop) {
		Float result = (float) 1;
		if (pop < 0) {
			return (float) -1;// 返回-1，说明传入数据不合法
		}
		if (pop == 0) {
			return (float) 1;
		}
		for (int i = 1; i <= pop; i++) {
			result *= i;
		}
		return result;
	}

	private static int orderBetween(Character peek, char c) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('+', 0);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 3);
		map.put('^', 4);
		map.put('!', 5);
		map.put('(', 6);
		map.put(')', 7);
		map.put('\0', 8);

		char pri[][] = { { '>', '>', '<', '<', '<', '<', '<', '>', '>' },
				{ '>', '>', '<', '<', '<', '<', '<', '>', '>' }, { '>', '>', '>', '>', '<', '<', '<', '>', '>' },
				{ '>', '>', '>', '>', '<', '<', '<', '>', '>' }, { '>', '>', '>', '>', '>', '<', '<', '>', '>' },
				{ '>', '>', '>', '>', '>', '>', ' ', '>', '>' }, { '<', '<', '<', '<', '<', '<', '<', '=', ' ' },
				{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { '<', '<', '<', '<', '<', '<', '<', ' ', '=' } };
		int h = map.get(peek);
		int l = map.get(c);
		return pri[h][l];
	}

	private static int readNumber(char[] s, int i, Stack<Float> opnd) {
		int temp = 0;
		while (Character.isDigit(s[i])) {
			temp *= 10;
			temp += (int) (s[i] - '0');
			++i;
		}
		opnd.push((float) temp);
		return i;
	}

}
