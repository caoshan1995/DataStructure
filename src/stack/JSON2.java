package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * ������Ҫ�����ڼ��򵥵�JSON�﷨
 * 
 * @author caoshan
 *
 */
public class JSON2 {

	static int error[] = new int[5];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();// ����һ��JSON��

		Stack<Character> stack = new Stack<>(); // ��ջ��ɨ��S���洢������ż�����
		Stack<Character> temp = new Stack<>(); // ��ջ�����ڴ洢��ʱ�޷�����ջƥ�������

		// ��ʼ��Ȼ��"{"��ͷ
		if (S.charAt(0) != '{') {
			error[2] = 1;
		}

		// forѭ��������ɨ��һ��S��
		for (int i = 0; i < S.length(); i++) {
			// ɨ�赽�����ţ�����ջ
			if (S.charAt(i) == '{' || S.charAt(i) == '[') {
				stack.push(S.charAt(i));
			} else if (S.charAt(i) == '"') {
				// ɨ�赽�ڶ�������,Ӧ���жϺ��Ƿ��ж���,Ȼ�󵯳��������š�
				if (stack.peek() == '"') {
					if (i + 1 < S.length() && S.charAt(i + 1) == '"') {
						error[4] = 1;// error[4]��ʾ��ʧ����
					}
					stack.pop();
				} else
					stack.push(S.charAt(i));
			} else if (S.charAt(i) == '}') {
				// ɨ�赽�Ҵ����ţ����жϺ�һ�������Ƿ�Ϊ������ţ�����ǣ�����ʧ���ţ������жϵ�ǰջ��Ԫ���Ƿ�Ϊ�������
				// ������ǣ�����temp����������ƥ�䣬����
				if (i + 1 < S.length() && S.charAt(i + 1) == '{') {
					error[4] = 1;
				}
				if (stack.peek() == '{')
					stack.pop();
				else
					temp.push(S.charAt(i));
			} else if (S.charAt(i) == ']') {
				// ɨ�赽�������ţ����жϺ�һ�������Ƿ�Ϊ���ţ�����ǣ�����ʧ���ţ������жϵ�ǰջ��Ԫ���Ƿ�Ϊ�������
				// ������ǣ�����temp����������ƥ�䣬����
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
		// �жϣ���ջ�Ƿ���Ԫ���ܹ�����ջƥ��
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
