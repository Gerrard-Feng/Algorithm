package com.gerrard.sort;

import java.util.Random;

public class Test {

	public static void main(String[] args) {

		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(100) + 1;
		}
		MergeSort.basal(array);

		for (int a : array) {
			System.out.print(a + " ");
		}
	}
}