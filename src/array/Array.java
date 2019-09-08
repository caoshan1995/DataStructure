package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description (1)�������������ȥ��uniquify(ArrayList<Integer> array)<br/>
 *              (2)����������ֲ���binSearch(int[] array, int e, int lo, int hi)
 * @author caoshan
 *
 */
public class Array {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			array.add(sc.nextInt());
		}
		System.out.println(uniquify(array));
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
	}

	/**
	 * 
	 * @param array ��ȥ�صļ���
	 * @return result ����ɾ�����ٸ��ظ�Ԫ��
	 */
	public static int uniquify(ArrayList<Integer> array) {
		int i = 0;
		int j = 0;
		while (++j < array.size()) {
			if (array.get(i) != array.get(j))
				array.set(++i, array.get(j));
		}
		int result = j - i - 1;
		while (j != i + 1) {
			array.remove(--j);
		}
		return result;
	}

	/**
	 * 
	 * @param array �����ҵ���������
	 * @param e     ������Ԫ��
	 * @param lo    ���ҷ�Χ���½�
	 * @param hi    ���ҷ�Χ���Ͻ�
	 * @return �鵽�˷����±꣬�鲻������-1
	 */
	public static int binSearch(int[] array, int e, int lo, int hi) {

		while (lo < hi) {
			int mid = (lo + hi) >> 1;
			if (e < array[mid]) {
				hi = mid;

			} else if (e > array[mid]) {
				lo = mid + 1;
			} else
				return mid;
		}
		return -1;
	}

	// �����������Ľ������ڷ��ز�����e��Ԫ�ص�����±�
	public static int binSearchImprove(int[] array, int e, int lo, int hi) {
		while (lo < hi) {
			int mid = (lo + hi) >> 1;
			if (e < array[mid])
				hi = mid;
			else
				lo = mid + 1;
		}
		return --lo;
	}
}
