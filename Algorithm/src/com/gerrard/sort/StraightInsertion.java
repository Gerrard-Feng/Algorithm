package com.gerrard.sort;

import java.util.Arrays;

// ֱ�Ӳ�������
public class StraightInsertion {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// �ӵڶ��ʼ
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			// cur ��ر�ʶ����ֹ�����������С
			boolean flag = false;
			// ���������������λ
			for (int j = i - 1; j > -1; j--) {
				if (cur < array[j]) {
					array[j + 1] = array[j];
				} else {
					array[j + 1] = cur;
					flag = true;
					break;
				}
			}
			if (!flag) {
				array[0] = cur;
			}
		}
	}

	// ������һ�ε�λ�ã�����һ�ζ�λ
	public static void optimized_1(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// ��¼��һ������ֵ��λ�ú���ֵ
		int checkN = array[0];
		int checkI = 0;
		// ѭ������
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			int start = i - 1;
			// ������һ��ֵ����λ��ʼ������λ��
			if (cur < checkN) {
				start = checkI;
				for (int j = i - 1; j > start - 1; j--) {
					array[j + 1] = array[j];
				}
			}
			// ʣ������ǣ�checkI λ�õ����֣�������һ������λ������ͬ��
			// ѭ���ж�+����
			boolean flag = false;
			for (int j = start; j > -1; j--) {
				if (cur < array[j]) {
					array[j + 1] = array[j];
				} else {
					array[j + 1] = cur;
					checkN = cur;
					checkI = j + 1;
					flag = true;
					break;
				}
			}
			if (!flag) {
				array[0] = cur;
			}
		}
	}

	// ����ϵͳ�Դ��Ķ��ֲ��ҷ�����λ����λ��
	// ���ȶ�����
	public static void optimized_2(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			int[] sorted = Arrays.copyOf(array, i);
			int index = Arrays.binarySearch(sorted, cur);
			if (index < 0) {
				index = -(index + 1);
			}
			for (int j = i - 1; j > index - 1; j--) {
				array[j + 1] = array[j];
			}
			array[index] = cur;
		}
	}

	// �Լ�ʵ�ֶ��ֲ���
	// ���ȶ�����
	public static void optimized_3(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			// ���ֲ��ҵĸ�λ�͵�λ
			int low = 0, high = i - 1;
			// �����������λ��
			int index = binarySearch(array, low, high, cur);
			for (int j = i - 1; j > index - 1; j--) {
				array[j + 1] = array[j];
			}
			array[index] = cur;
		}
	}

	// ���ֲ��ң����ش������λ��
	private static int binarySearch(int[] array, int low, int high, int cur) {
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int mVal = array[mid];
			if (mVal < cur) {
				low = mid + 1;
			} else if (mVal > cur) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		// δ�鵽
		return low;
	}
}