package com.gerrard.sort;

// 冒泡排序
public class BubbleSort {

	// 基础冒泡排序
	public static void basal(int[] array) {
		// 外循环，最后一次只剩一个数字未排序，自然有序，无需再排序
		for (int i = 0; i < array.length - 1; i++) {
			// 内循环，不计已经沉底的最大数
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
				}
			}
		}
	}

	// 优化冒泡排序1
	public static void optimized_1(int[] array) {
		// 内循环数据交换标志
		boolean hasSwaped = false;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
					hasSwaped = true;
				}
			}
			// 如果某次内循环，没有发生任何一次数据交换，
			// 表示整个数组已经完全有序，没有必要继续做外循环，直接退出
			if (!hasSwaped) {
				break;
			}
		}
	}

	// 优化冒泡排序2
	public static void optimized_2(int[] array) {
		int lastSwapPos = 0;
		int lastSwapPosTemp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			lastSwapPos = lastSwapPosTemp;
			for (int j = array.length - 1; j > lastSwapPos; j--) {
				if (array[j - 1] > array[j]) {
					swap(j, j - 1, array);
					lastSwapPosTemp = j;
				}
			}
			if (lastSwapPos == lastSwapPosTemp) {
				break;
			}
		}
	}

	// 优化冒泡排序2
	public static void optimized_3(int[] array) {
		int lastSwapPos = array.length - 1;
		int lastSwapPosTemp = array.length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			lastSwapPos = lastSwapPosTemp;
			for (int j = 0; j < lastSwapPos; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
					lastSwapPosTemp = j + 1;
				}
			}
			if (lastSwapPos == lastSwapPosTemp) {
				break;
			}
		}
	}

	// 交换数组中2个值的位置
	private static void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}