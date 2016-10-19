package com.gerrard.sort;

import java.util.Arrays;

// 归并排序
public class MergeSort {

	public static void basal(int array[]) {
		// 待合并数组长度
		int length = 1;
		while (length < array.length) {
			for (int i = 0; i < array.length; i += 2 * length) {
				// array1的长度不足时，表示之后数组已经有序
				if (array.length - i < length) {
					continue;
				}
				int[] array1 = Arrays.copyOfRange(array, i, i + length);
				// array2的长度不足时，需要确定具体长度
				int remainLength = array.length - i - length;
				if (remainLength > length) {
					remainLength = length;
				}
				int[] array2 = Arrays.copyOfRange(array, i + length, i + length + remainLength);
				int[] resultArray = merge(array1, array2);
				// 有序数组替换无序数组
				int index = 0;
				for (int j = i; j < i + resultArray.length; j++) {
					array[j] = resultArray[index++];
				}
			}
			// 下次归并的数组长度
			length *= 2;
		}
	}

	// 将两个有序数组，合并成一个有序数组
	private static int[] merge(int[] array1, int[] array2) {
		// 总能保证array1存在，但是array2的长度可能为0
		if (array2.length == 0) {
			return array1;
		}
		int length = array1.length + array2.length;
		int[] resultArray = new int[length];
		int index1 = 0;
		int index2 = 0;
		int[] tempArray = null;
		int tempIndex = -1;
		for (int i = 0; i < length; i++) {
			if (tempArray == null) {
				// 两个数组均有剩余
				if (array1[index1] < array2[index2]) {
					resultArray[i] = array1[index1];
					index1++;
				} else {
					resultArray[i] = array2[index2];
					index2++;
				}
				// 一次赋值之后，做一次是否存在数组已经读完的判断
				if (index1 == array1.length || index2 == array2.length) {
					if (index1 == array1.length) {
						tempArray = array2;
						tempIndex = index2;
					} else {
						tempArray = array1;
						tempIndex = index1;
					}
				}
			} else {
				// 某数组已经读完，直接操作剩下的一个数组
				resultArray[i] = tempArray[tempIndex++];
			}
		}
		return resultArray;
	}
}