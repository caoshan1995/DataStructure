package dynamic_programming;
import java.util.Scanner;

public class dynamic_programming {
	/**
	 * <P>
	 * Title: 动态规划问题集合
	 * </P>
	 * 
	 * @param str1[0,N],str2[0,M] 输入两个字符数组，找出两个最长公共子序列
	 * @author caoshan
	 * @ApplyDescription (1)最长公共子序列LCS.<br/>
	 *                   (2)斐波那契数列.
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		char str1[] = s1.toCharArray();
		char str2[] = s2.toCharArray();
		int N = str1.length;
		int M = str2.length;
		System.out.println(getLongestCommonSubsequence(str1, str2, N, M));
	}

	/**
	 * 
	 * @param str1 子串1
	 * @param str2 子串2
	 * @param N    子串1的长度
	 * @param M    子串2的长度
	 * @return 最长公共子序列的长度(自动输出该最长公共子序列)
	 * 
	 */
	public static int getLongestCommonSubsequence(char[] str1, char[] str2, int N, int M) {
		// 对于序列str1[0,N]和str2[0,M]无非三种情况
		// 1.若n=-1或m=-1,则取作空序列" " （作为递归基）
		// 2.若str1[N]=='x'==str2[M],则取作LCS(str1[0,N),str2[0,M))+'x'
		// 3.若str1[N]！=str2[M],则取LCS(str1[0,N],str2[0,M))和LCS(str1[0,N),str2[0,M])中取更长者
		// 该函数为输出最长子序列的长度,如果想输出最长子序列字符串呢？调用Display方法
		// 先记录每次最长公共子序列的方向
		int record[][] = new int[N + 1][M + 1];
		int direction[][] = new int[N + 1][M + 1];
		String s = "";
		if (0 >= N || 0 >= M)
			return 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					record[i][j] = record[i - 1][j - 1] + 1;
					direction[i][j] = 1;
				} else if (record[i - 1][j] >= record[i][j - 1]) {
					record[i][j] = record[i - 1][j];
					direction[i][j] = 0;
				} else {
					record[i][j] = record[i][j - 1];
					direction[i][j] = -1;
				}

			}
		}
		Display(direction, str1, N, M);
		System.out.println();
		return record[N][M];
	}

	public static void Display(int direction[][], char[] str1, int N, int M) {
		if (N == 0 || M == 0) {
			return;
		}
		if (direction[N][M] == 1) {
			Display(direction, str1, N - 1, M - 1);
			System.out.print(str1[N - 1]);
		} else if (direction[N][M] == 0)
			Display(direction, str1, N - 1, M);
		else
			Display(direction, str1, N, M - 1);
	}

}
