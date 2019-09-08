package dynamic_programming;
import java.util.Scanner;

public class dynamic_programming {
	/**
	 * <P>
	 * Title: ��̬�滮���⼯��
	 * </P>
	 * 
	 * @param str1[0,N],str2[0,M] ���������ַ����飬�ҳ����������������
	 * @author caoshan
	 * @ApplyDescription (1)�����������LCS.<br/>
	 *                   (2)쳲���������.
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
	 * @param str1 �Ӵ�1
	 * @param str2 �Ӵ�2
	 * @param N    �Ӵ�1�ĳ���
	 * @param M    �Ӵ�2�ĳ���
	 * @return ����������еĳ���(�Զ�����������������)
	 * 
	 */
	public static int getLongestCommonSubsequence(char[] str1, char[] str2, int N, int M) {
		// ��������str1[0,N]��str2[0,M]�޷��������
		// 1.��n=-1��m=-1,��ȡ��������" " ����Ϊ�ݹ����
		// 2.��str1[N]=='x'==str2[M],��ȡ��LCS(str1[0,N),str2[0,M))+'x'
		// 3.��str1[N]��=str2[M],��ȡLCS(str1[0,N],str2[0,M))��LCS(str1[0,N),str2[0,M])��ȡ������
		// �ú���Ϊ���������еĳ���,����������������ַ����أ�����Display����
		// �ȼ�¼ÿ������������еķ���
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
