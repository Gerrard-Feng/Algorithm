package com.gerrard.sort;

// 归并排序
public class Merge {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		int l = 1;
		while (l < array.length) {
			for (int i = 0; i < array.length; i += (l << 1)) {
				int start1 = i;
				int end1 = i + l - 1;
				int start2 = i + l;
				int end2;
				if (array.length - i >= l << 1) {
					// 两个数组长度都够
					end2 = i + (l << 1) - 1;
				} else if (array.length - i > l) {
					// 第二个数组长度不够
					end2 = array.length - 1;
				} else {
					// 第二个数组长度为0
					continue;
				}
				merge1(array, start1, end1, start2, end2);
			}
			l = l << 1;
		}
	}

	private static void merge1(int[] array, int start1, int end1, int start2, int end2) {
		int[] newArray = new int[end2 - start1 + 1];
		int l1 = end1 - start1 + 1;
		int l2 = end2 - start2 + 1;
		int j = 0, k = 0;
		for (int i = 0; i < newArray.length; i++) {
			if (j == l1) {
				newArray[i] = array[start2 + k];
				k++;
				continue;
			}
			if (k == l2) {
				newArray[i] = array[start1 + j];
				j++;
				continue;
			}
			if (array[start2 + k] > array[start1 + j]) {
				newArray[i] = array[start1 + j];
				j++;
			} else {
				newArray[i] = array[start2 + k];
				k++;
			}
		}
		System.arraycopy(newArray, 0, array, start1, newArray.length);
	}

	// 用直接插入排序的思想归并，不消耗额外的空间
	private static void merge2(int[] array, int start1, int end1, int start2, int end2) {
		int l1 = end1 - start1 + 1;
		int l2 = end2 - start2 + 1;
		// 记录上一个插入的索引，初始化为 start2
		int checkIndex = start2;
		for (int i = 0; i < l2; i++) {
			// 从最后一个开始插入
			int cur = array[end2];
			// 第二个数组中循环移动（最后一位不移动）
			for (int j = 0; j < l2 - 1 - i; j++) {
				array[end2 - j] = array[end2 - j - 1];
			}
			// 先将一定会后挪动的执行
			for (int j = end1 + i; j > checkIndex - 1; j--) {
				array[j + 1] = array[j];
			}
			// 开始直接插入排序
			boolean flag = false;
			for (int j = checkIndex - 1; j > start1 - 1; j--) {
				if (cur < array[j]) {
					array[j + 1] = array[j];
				} else {
					array[j + 1] = cur;
					checkIndex = j + 1;
					flag = true;
					break;
				}
			}
			if (!flag) {
				array[start1] = cur;
			}
		}
	}
}