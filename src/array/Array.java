package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description (1)有序数组大批量去重uniquify(ArrayList<Integer> array)<br/>
 *              (2)有序数组二分查找binSearch(int[] array, int e, int lo, int hi)
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
	 * @param array 待去重的集合
	 * @return result 返回删除多少个重复元素
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
	 * @param array 待查找的有序数组
	 * @param e     待查找元素
	 * @param lo    查找范围的下界
	 * @param hi    查找范围的上届
	 * @return 查到了返回下标，查不到返回-1
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

	// 二叉搜索树改进，用于返回不大于e的元素的最大下标
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
