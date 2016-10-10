package com.gerrard.sort;

public class Bubble {

	// ����ð������
	public static void basal(int[] array) {
		int temp;
		// ��ѭ�������һ��ֻʣһ������δ������Ȼ��������������
		for (int i = 0; i < array.length - 1; i++) {
			// ��ѭ���������Ѿ����׵������
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// �Ż�ð������1
	public static void optimized_1(int[] array) {
		boolean hasSwaped = false;
		for (int i = 0; i < array.length - 1; i++) {
			int temp;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					hasSwaped = true;
				}
			}
			// ���ĳ����ѭ����û�з����κ�һ�����ݽ�������ʾ���������Ѿ���ȫ����û�б�Ҫ��������ѭ��
			if (!hasSwaped) {
				break;
			}
		}
	}
}