package fibonacci;

import java.util.Scanner;

/**
 * <P>
 * Title: 쳲���������
 * </P>
 * 
 * @param N �����ģ
 * @author caoshan
 * @ApplyDescription (1)��̨�׵�����,��������:һ�ο�����һ��̨�׻�һ�ο���������̨��,���ϵ�N��̨�׵ķ�����.<br/>
 *                   (2)�����ӵ�����,��������:��һֻ����,�����º��������һֻС����,�Ժ��ÿһ���¶���������һֻ,�ʵ�N����һ���м�ֻ����?
 * 
 */

public class Fib {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fib(N));
	}

	/*
	 * �÷������õĶ�̬�滮���ߵ����㷽�����Զ����µݹ�ĳ��Ե����ϵ�����
	 */
	public static int fib(int N) {
		int f = 0;// fib(0)
		int g = 1;// fib(1)
		if (N == 0) {
			return f;
		}

		while (0 < --N) {
			g = f + g;
			f = g - f;
		}
		return g;
	}

}
