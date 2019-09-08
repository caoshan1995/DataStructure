package fibonacci;

import java.util.Scanner;

/**
 * <P>
 * Title: 斐波那契数列
 * </P>
 * 
 * @param N 输入规模
 * @author caoshan
 * @ApplyDescription (1)上台阶的问题,问题描述:一次可以上一阶台阶或一次可以上两阶台阶,问上第N阶台阶的方法数.<br/>
 *                   (2)生兔子的问题,问题描述:有一只兔子,三个月后可以生第一只小兔子,以后的每一个月都可以生下一只,问第N个月一共有几只兔子?
 * 
 */

public class Fib {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fib(N));
	}

	/*
	 * 该方法采用的动态规划，颠倒计算方向，由自顶而下递归改成自底向上迭代！
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
