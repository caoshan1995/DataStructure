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
	 * @param array ����������
	 * @param lo    �����������½�
	 * @param hi    �����������Ͻ�
	 * @return sorted�ж��Ƿ���������
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
		return sorted;// ���������־
	}

	public static void BubbleSort(int array[], int lo, int hi) {
		// ��ͳ��ð������
		// while (!bubble(array, lo, hi--))
		;
		// �Ľ����ð������
		while (lo < (hi = bubbleImp(array, lo, hi)))
			;
	}

	/**
	 * @Description �Ľ����ð������
	 * @param array ����������
	 * @param lo    �����������½�
	 * @param hi    �����������Ͻ�
	 * @return last �������Ҳ������λ��
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
		return last;// �������Ҳ������λ��
	}
	/**
	 * @Description ѡ������
	 * @param array ����������
	 * @param lo	�������½�
	 * @param hi	�������Ͻ�
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
