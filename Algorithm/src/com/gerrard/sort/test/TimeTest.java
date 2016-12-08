package com.gerrard.sort.test;

import java.util.Random;

import com.gerrard.sort.StraightInsertionSort;

public class TimeTest {

	public static void main(String[] args) {

		// 模拟数组
		int[] array = new int[123456];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(123456) + 1;
		}
		
		// 时间输出：纳秒
		long s1 = System.nanoTime();
		StraightInsertionSort.optimized_3(array);
		long e1 = System.nanoTime();
		System.out.println(e1 - s1);
	}
}