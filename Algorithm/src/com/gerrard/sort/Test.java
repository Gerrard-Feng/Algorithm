package com.gerrard.sort;

import java.util.Random;

public class Test {

	public static void main(String[] args) {

		int[] array1 = new int[100];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = new Random().nextInt(100) + 1;
		}
		MergeSort.basal(array1);
		for (int a : array1) {
			System.out.print(a + " ");
		}
	}
}