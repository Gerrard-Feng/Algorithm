package com.gerrard.array;

import java.util.Arrays;
import java.util.Random;

public class Array {

	/**
	 * ������飬ʵ��ԭ��
	 * 1.�������������ȵ������飬�������򣬻����������
	 * 2.��������ֵ��ԭ�����ع�
	 * 
	 * @param array �����������
	 */
	public static int[] randomArray(int[] array) {
		final int LENGTH = array.length;
		// Ŀ����������
		int[] sortArray = new int[LENGTH];
		// �����ֵ
		Random random = new Random();
		for (int i = 0; i < LENGTH; i++) {
			sortArray[i] = random.nextInt(1024);
		}
		// Ŀ����������ĸ���
		int[] copyArray = Arrays.copyOf(sortArray, LENGTH);
		// �������ֵ������
		int[] indexArray = new int[LENGTH];
		// ��ʼ����ϣ����¿�ʼ��ȡ��������
		// ������
		int temp;
		final int MIN = Integer.MIN_VALUE;
		// ��ʼ�����ֵ��������ֵ
		int max = sortArray[0];
		int maxIndex = 0;
		// ��ð������
		// ��ѭ�������ǵ���Ҫ�����һ��ѭ��
		for (int i = 0; i < LENGTH; i++) {
			// ��ѭ��ÿ�α�����β��
			for (int j = 0; j < LENGTH - 1; j++) {
				if (sortArray[j] > sortArray[j + 1]) {
					if (sortArray[j] > max) {
						max = sortArray[j];
						maxIndex = j;
					}
					// ����
					temp = sortArray[j];
					sortArray[j] = sortArray[j + 1];
					sortArray[j + 1] = temp;
				}
			}
			// ��ѭ��û���ǣ�ԭ����������������һλ���������һ���ж�
			if (max < sortArray[LENGTH - 1]) {
				max = sortArray[LENGTH - 1];
				maxIndex = LENGTH - 1;
			}
			// ���һλ���������������������һλ��ʼ��ֵ
			indexArray[sortArray.length - i - 1] = maxIndex;
			// �ҵ������������Ϊ��С�����������ݸ���������
			copyArray[maxIndex] = MIN;
			sortArray = Arrays.copyOf(copyArray, LENGTH);
			// ����max��maxIndex
			max = sortArray[0];
			maxIndex = 0;
		}
		// ����������ֵ
		int[] targetArray = new int[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			targetArray[indexArray[i]] = array[i];
		}
		return targetArray;
	}
}