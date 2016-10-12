package com.gerrard.sort;

public class SelectionSort {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// ��СԪ������
		int minIndex;
		for (int i = 0; i < array.length; i++) {
			// ÿ��ѭ����ʼ����������
			minIndex = i;
			// ǰi���Ѿ�����
			// ��ѭ������������[i,array.length-1]���������ҳ���С��Ԫ�ص�λ�ã��͵�i���
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(i, minIndex, array);
		}
	}

	public static void optimized(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// һ�α������ҳ�������С����ֵ
		int minIndex;
		int maxIndex;
		// ��ѭ��������һ��ͽ���
		// �����������������������ɵ�������
		for (int i = 0; i < array.length / 2; i++) {
			minIndex = i;
			maxIndex = i;
			// ��ѭ���ʴ���������״
			for (int j = i; j < array.length - i; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			swap(i, minIndex, array);
			// ��ֹ������ڵ�һ�������Ⱥ���С�����н���
			if (i == maxIndex) {
				swap(array.length - 1 - i, minIndex, array);
			} else {
				swap(array.length - 1 - i, maxIndex, array);
			}
		}
	}

	// ����������2��ֵ��λ��
	private static void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}