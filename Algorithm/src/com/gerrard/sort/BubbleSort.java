package com.gerrard.sort;

// ð������
public class BubbleSort {

	// ����ð������
	public static void basal(int[] array) {
		// ��ѭ�������һ��ֻʣһ������δ������Ȼ��������������
		for (int i = 0; i < array.length - 1; i++) {
			// ��ѭ���������Ѿ����׵������
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
				}
			}
		}
	}

	// �Ż�ð������1
	public static void optimized_1(int[] array) {
		// ��ѭ�����ݽ�����־
		boolean hasSwaped = false;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
					hasSwaped = true;
				}
			}
			// ���ĳ����ѭ����û�з����κ�һ�����ݽ�����
			// ��ʾ���������Ѿ���ȫ����û�б�Ҫ��������ѭ����ֱ���˳�
			if (!hasSwaped) {
				break;
			}
		}
	}

	// �Ż�ð������2
	public static void optimized_2(int[] array) {
		int lastSwapPos = 0;
		int lastSwapPosTemp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			lastSwapPos = lastSwapPosTemp;
			for (int j = array.length - 1; j > lastSwapPos; j--) {
				if (array[j - 1] > array[j]) {
					swap(j, j - 1, array);
					lastSwapPosTemp = j;
				}
			}
			if (lastSwapPos == lastSwapPosTemp) {
				break;
			}
		}
	}

	// �Ż�ð������2
	public static void optimized_3(int[] array) {
		int lastSwapPos = array.length - 1;
		int lastSwapPosTemp = array.length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			lastSwapPos = lastSwapPosTemp;
			for (int j = 0; j < lastSwapPos; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
					lastSwapPosTemp = j + 1;
				}
			}
			if (lastSwapPos == lastSwapPosTemp) {
				break;
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