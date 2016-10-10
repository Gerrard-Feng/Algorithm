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
		System.out.println("优化冒泡排序时间：" + (bEnd - bStart));
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 单位：10e-9秒
		long aStart = System.nanoTime();
		Bubble.basal(a);
		long aEnd = System.nanoTime();
		System.out.println("基础冒泡排序时间：" + (aEnd - aStart));
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		

	}
}