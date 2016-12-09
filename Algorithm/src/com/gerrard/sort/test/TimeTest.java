package com.gerrard.sort.test;

import java.util.Random;

import com.gerrard.sort.Merge;
import com.gerrard.sort.Shell;

public class TimeTest {

	public static void main(String[] args) {

		// ģ������
		int[] array = new int[123456];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(123456) + 1;
		}
		
		// ʱ�����������
		long s1 = System.nanoTime();
		Merge.basal(array);
		long e1 = System.nanoTime();
		System.out.println(e1 - s1);
	}
}