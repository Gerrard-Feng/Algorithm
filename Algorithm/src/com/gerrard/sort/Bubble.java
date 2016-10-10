package com.gerrard.sort;

public class Bubble {

	// 基础冒泡排序
	public static void basal(int[] array) {
		int temp;
		// 外循环，最后一次只剩一个数字未排序，自然有序，无需再排序
		for (int i = 0; i < array.length - 1; i++) {
			// 内循环，不计已经沉底的最大数
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// 优化冒泡排序1
	public static void optimized_1(int[] array) {
		boolean hasSwaped = false;
		for (int i = 0; i < array.length - 1; i++) {
			int temp;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					hasSwaped = true;
				}
			}
			// 如果某次内循环，没有发生任何一次数据交换，表示整个数组已经完全有序，没有必要继续做外循环
			if (!hasSwaped) {
				break;
			}
		}
	}
}