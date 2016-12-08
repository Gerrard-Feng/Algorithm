package com.gerrard.sort.test;

import java.util.Arrays;
import java.util.Random;

import com.gerrard.sort.StraightInsertionSort;

public class VeracityTest {

	public static void main(String[] args) {

		// ģ������
		int[] array1 = new int[100000];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = new Random().nextInt(100000) + 1;
		}

		// ��������
		int[] array2 = Arrays.copyOf(array1, array1.length);

		// �Լ�ʵ�����򼰹ٷ�����
		StraightInsertionSort.basal(array1);
		Arrays.sort(array2);

		// �ȶԽ��
		boolean flag = true;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				flag = false;
				break;
			}
		}

		// ������
		System.out.println(flag);
	}
}