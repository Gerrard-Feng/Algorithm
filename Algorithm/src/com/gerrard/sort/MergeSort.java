package com.gerrard.sort;

import java.util.Arrays;

// �鲢����
public class MergeSort {

	public static void basal(int array[]) {
		// ���ϲ����鳤��
		int length = 1;
		while (length < array.length) {
			for (int i = 0; i < array.length; i += 2 * length) {
				// array1�ĳ��Ȳ���ʱ����ʾ֮�������Ѿ�����
				if (array.length - i < length) {
					continue;
				}
				int[] array1 = Arrays.copyOfRange(array, i, i + length);
				// array2�ĳ��Ȳ���ʱ����Ҫȷ�����峤��
				int remainLength = array.length - i - length;
				if (remainLength > length) {
					remainLength = length;
				}
				int[] array2 = Arrays.copyOfRange(array, i + length, i + length + remainLength);
				int[] resultArray = merge(array1, array2);
				// ���������滻��������
				int index = 0;
				for (int j = i; j < i + resultArray.length; j++) {
					array[j] = resultArray[index++];
				}
			}
			// �´ι鲢�����鳤��
			length *= 2;
		}
	}

	// �������������飬�ϲ���һ����������
	private static int[] merge(int[] array1, int[] array2) {
		// ���ܱ�֤array1���ڣ�����array2�ĳ��ȿ���Ϊ0
		if (array2.length == 0) {
			return array1;
		}
		int length = array1.length + array2.length;
		int[] resultArray = new int[length];
		int index1 = 0;
		int index2 = 0;
		int[] tempArray = null;
		int tempIndex = -1;
		for (int i = 0; i < length; i++) {
			if (tempArray == null) {
				// �����������ʣ��
				if (array1[index1] < array2[index2]) {
					resultArray[i] = array1[index1];
					index1++;
				} else {
					resultArray[i] = array2[index2];
					index2++;
				}
				// һ�θ�ֵ֮����һ���Ƿ���������Ѿ�������ж�
				if (index1 == array1.length || index2 == array2.length) {
					if (index1 == array1.length) {
						tempArray = array2;
						tempIndex = index2;
					} else {
						tempArray = array1;
						tempIndex = index1;
					}
				}
			} else {
				// ĳ�����Ѿ����ֱ꣬�Ӳ���ʣ�µ�һ������
				resultArray[i] = tempArray[tempIndex++];
			}
		}
		return resultArray;
	}
}