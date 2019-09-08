package array;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		switch (new Random().nextInt(5)) {
		case 1:
			BubbleSort(array, 0, N);
			break;
		case 2:
			selectSort(array, 0, N);
			break;
		case 3:
			mergeSort(array, 0, N);
			break;
		case 4:
			heapSort(array, 0, N);
			break;
		default:
			quickSort(array, 0, N);
			break;
		}
		for (int i = 0; i < N; i++) {
			System.out.print(array[i] + " ");
		}
	}


	/**
	 * 
	 * @param array 待排序数组
	 * @param lo    待排序数组下界
	 * @param hi    待排序数组上界
	 * @return sorted判断是否整体有序
	 */
	public static boolean bubble(int array[], int lo, int hi) {
		boolean sorted = true;
		while (++lo < hi) {
			if (array[lo - 1] > array[lo]) {
				sorted = false;
				int temp = array[lo - 1];
				array[lo - 1] = array[lo];
				array[lo] = temp;
			}
		}
		return sorted;// 返回有序标志
	}

	public static void BubbleSort(int array[], int lo, int hi) {
		// 传统的冒泡排序
		// while (!bubble(array, lo, hi--))
		;
		// 改进后的冒泡排序
		while (lo < (hi = bubbleImp(array, lo, hi)))
			;
	}

	/**
	 * @Description 改进后的冒泡排序
	 * @param array 待排序数组
	 * @param lo    待排序数组下界
	 * @param hi    待排序数组上界
	 * @return last 返回最右侧逆序对位置
	 */
	public static int bubbleImp(int array[], int lo, int hi) {
		int last = lo;
		while (++lo < hi) {
			if (array[lo - 1] > array[lo]) {
				last = lo;
				int temp = array[lo - 1];
				array[lo - 1] = array[lo];
				array[lo] = temp;
			}
		}
		return last;// 返回最右侧逆序对位置
	}
	/**
	 * @Description 选择排序
	 * @param array 待排序数组
	 * @param lo	待排序下界
	 * @param hi	待排序上界
	 */
	public static void selectSort(int array[], int lo, int hi) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}
	private static void quickSort(int[] array, int i, int n) {
		// TODO Auto-generated method stub

	}

	private static void heapSort(int[] array, int i, int n) {
		// TODO Auto-generated method stub

	}

	private static void mergeSort(int[] array, int i, int n) {
		// TODO Auto-generated method stub

	}

}
