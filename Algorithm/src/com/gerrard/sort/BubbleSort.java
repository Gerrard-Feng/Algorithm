package com.gerrard.sort;

// 冒泡排序
public class BubbleSort {

	// 基础冒泡排序
	public static void basal(int[] array) {
		// 外循环，最后一次只剩一个数字未排序，自然有序，无需再排序
		for (int i = 0; i < array.length - 1; i++) {
			// 内循环，不计已经沉底的最大数
			// 即[array.length-i-1,array.length-1]区间已经有序
			for (int j = 0; j < array.length - 1 - i; j++) {
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
		int lastSwapPos = array.length - 1;
		int lastSwapPosTemp = array.length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			lastSwapPos = lastSwapPosTemp;
			// 因为大数一定是不断下沉的，所以只要最大数不在遍历的终点上，最后一次一定会执行交换、
			// 换言之，若是最后一次交换未执行，而是在倒数第二次处执行了交换，一定可以保证倒数第二个数是次大数
			// 因此可以将倒数第三个数作为下一次交换的终点
			// 依次类推，可以保证[lastSwapPos,array.length-1-i]是有序的，且其中任意一个数都比前面的数字大
			// 所以内循环的退出条件，可以由j<array.length-1-i转变为j<lastSwapPos
			for (int j = 0; j < lastSwapPos; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1, array);
					lastSwapPosTemp = j;
				}
			}
			// 一次都未交换的情况
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