package com.gerrard.array;

public class Test {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 5, 7554, 53, 22, 90, 53, 543, 1, 0, 4, 53, 1 };
		array = Array.randomArray(array);
		for (int a : array) {
			System.out.print(a + ",");
		}
	}
}