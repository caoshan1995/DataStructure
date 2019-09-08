package stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * <P>
 * Title: ������
 * </P>
 * 
 * @Description (1)����һ��������,����һ����ȷ����׺���ʽ,���������ֵ.<br/>
 *              (2)�ڹ���һ���������Ĺ�����,���Խ���ת��Ϊ��׺���ʽ.
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
	 * @param S   ��׺���ʽ
	 * @param RPN �������ɺ�׺���ʽ
	 * @return ������׺���ʽ�ļ�����
	 */
	public static float evaluate(char S[], String RPN) {
		// ʹ������ջ�ֱ�洢���ֺ��ַ�
		Stack<Float> opnd = new Stack<>();// ������ջ
		Stack<Character> optr = new Stack<>();// �����ջ
		optr.push('\0');// ��ѹ��һ���ڱ�
		int i = 0;
		while (!optr.empty()) {
			if (Character.isDigit(S[i])) {
				i = readNumber(S, i, opnd);// �п��ܸ����ֲ��Ǹ�λ��,������λ��,��λ��ʲô��
				RPN += opnd.peek().toString();
			} else
				switch (orderBetween(optr.peek(), S[i])) {// �Ƚϲ����������ȼ�,ջ�����ȼ�С�ڵ�ǰ��,��ѹ��ջ,���򵯳�ջ��Ԫ�ؿ�ʼ���㡣
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
			return (float) -1;// ����-1��˵���������ݲ��Ϸ�
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
