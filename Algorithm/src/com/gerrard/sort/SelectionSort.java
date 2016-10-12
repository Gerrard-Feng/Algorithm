package com.gerrard.sort;

public class SelectionSort {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 最小元素坐标
		int minIndex;
		for (int i = 0; i < array.length; i++) {
			// 每次循环开始，重置坐标
			minIndex = i;
			// 前i个已经有序
			// 内循环的任务是在[i,array.length-1]的区间中找出最小的元素的位置，和第i项交换
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(i, minIndex, array);
		}
	}

	public static void optimized(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 一次遍历，找出最大和最小两个值
		int minIndex;
		int maxIndex;
		// 外循环遍历至一半就结束
		// 如果完整遍历，整个数组会变成倒序排列
		for (int i = 0; i < array.length / 2; i++) {
			minIndex = i;
			maxIndex = i;
			// 内循环呈从两边缩进状
			for (int j = i; j < array.length - i; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			swap(i, minIndex, array);
			// 防止最大数在第一个，优先和最小数进行交换
			if (i == maxIndex) {
				swap(array.length - 1 - i, minIndex, array);
			} else {
				swap(array.length - 1 - i, maxIndex, array);
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