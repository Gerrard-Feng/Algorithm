package com.gerrard.sort;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		final int LENGTH = 10;
		int[] a = new int[LENGTH];
		int[] b = new int[LENGTH];
		Random r = new Random();
		int temp;
		for (int i = 0; i < a.length; i++) {
			temp = r.nextInt(1000) + 1;
			a[i] = temp;
			b[i] = temp;
		}

		
		
		long bStart = System.nanoTime();
		Bubble.optimized_1(b);
		long bEnd = System.nanoTime();
		System.out.println("�Ż�ð������ʱ�䣺" + (bEnd - bStart));
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// ��λ��10e-9��
		long aStart = System.nanoTime();
		Bubble.basal(a);
		long aEnd = System.nanoTime();
		System.out.println("����ð������ʱ�䣺" + (aEnd - aStart));
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		

	}
}