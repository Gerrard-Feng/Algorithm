package com.gerrard.sort;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		final int LENGTH = 20;
		int[] a = new int[LENGTH];
		int[] b = new int[LENGTH];
		int[] c = new int[LENGTH];
		int[] d = new int[LENGTH];
		Random r = new Random();
		int temp;
		for (int i = 0; i < a.length; i++) {
			temp = r.nextInt(20) + 1;
			a[i] = temp;
			b[i] = temp;
			c[i] = temp;
			d[i] = temp;
		}

		long cStart = System.nanoTime();
		BubbleSort.optimized_1(c);
		long cEnd = System.nanoTime();
		System.out.println("Ӧ�ð��������������һ�����ʱ�䣺" + (cEnd - cStart));
//		for (int i : c) {
//			System.out.print(i + " ");
//		}
		System.out.println();
		
		
		
		// ��λ��10e-9��
		long aStart = System.nanoTime();
		BubbleSort.basal(a);
		long aEnd = System.nanoTime();
		System.out.println("����ð������ʱ�䣺" + (aEnd - aStart));
//		for (int i : a) {
//			System.out.print(i + " ");
//		}
		System.out.println();
		
		long bStart = System.nanoTime();
		BubbleSort.optimized_1(b);
		long bEnd = System.nanoTime();
		System.out.println("�Ż�ð������1ʱ�䣺" + (bEnd - bStart));
//		for (int i : b) {
//			System.out.print(i + " ");
//		}
		System.out.println();
		
		long dStart = System.nanoTime();
		BubbleSort.optimized_2(d);
		long dEnd = System.nanoTime();
		System.out.println("�Ż�ð������2ʱ�䣺" + (dEnd - dStart));
		for (int i : d) {
			System.out.print(i + " ");
		}
		System.out.println();

	}
}