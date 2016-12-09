package com.gerrard.sort.test;

import com.gerrard.sort.Merge;
import com.gerrard.sort.Shell;

public class EasyTest {

	public static void main(String[] args) {

		int[] array = { 3, 7, 5, 6, 1, 4, 9, 0, 2, 8 };
		Merge.basal(array);
		for (int a : array) {
			System.out.print(a + " ");
		}
	}
}