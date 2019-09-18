package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * <P>
 * Title: ����ת��
 * </P>
 * 
 * 
 * @Description (1)ָ��ĳʮ���Ƶ���ת��Ϊbase����.<br/>
 * @author caoshan
 * 
 */
public class Convert {

	public static void main(String args[]) {
		ArrayList<Integer> array = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int base = sc.nextInt();
		Stack<Character> stack = new Stack<>();
		cov(stack, N, base);
		while (!stack.empty()) {
			System.out.print(stack.pop());
		}
	}

	/**
	 * 
	 * @param stack ������
	 * @param n     ��ת������
	 * @param base  ת��Ϊ�Ľ�����
	 */
	public static void cov(Stack<Character> stack, int n, int base) {
		char digit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (n > 0) {
			stack.push(digit[n % base]);
			n = n / base;
		}

	}
}
