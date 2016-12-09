package com.gerrard.sort;

import java.util.Arrays;

// 直接插入排序
public class StraightInsertion {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 从第二项开始
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			// cur 落地标识，防止待插入的数最小
			boolean flag = false;
			// 倒序遍历，不断移位
			for (int j = i - 1; j > -1; j--) {
				if (cur < array[j]) {
					array[j + 1] = array[j];
				} else {
					array[j + 1] = cur;
					flag = true;
					break;
				}
			}
			if (!flag) {
				array[0] = cur;
			}
		}
	}

	// 根据上一次的位置，简化下一次定位
	public static void optimized_1(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 记录上一个插入值的位置和数值
		int checkN = array[0];
		int checkI = 0;
		// 循环插入
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			int start = i - 1;
			// 根据上一个值，定位开始遍历的位置
			if (cur < checkN) {
				start = checkI;
				for (int j = i - 1; j > start - 1; j--) {
					array[j + 1] = array[j];
				}
			}
			// 剩余情况是：checkI 位置的数字，和其下一个坐标位置是相同的
			// 循环判断+插入
			boolean flag = false;
			for (int j = start; j > -1; j--) {
				if (cur < array[j]) {
					array[j + 1] = array[j];
				} else {
					array[j + 1] = cur;
					checkN = cur;
					checkI = j + 1;
					flag = true;
					break;
				}
			}
			if (!flag) {
				array[0] = cur;
			}
		}
	}

	// 利用系统自带的二分查找法，定位插入位置
	// 不稳定排序
	public static void optimized_2(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			int[] sorted = Arrays.copyOf(array, i);
			int index = Arrays.binarySearch(sorted, cur);
			if (index < 0) {
				index = -(index + 1);
			}
			for (int j = i - 1; j > index - 1; j--) {
				array[j + 1] = array[j];
			}
			array[index] = cur;
		}
	}

	// 自己实现二分查找
	// 不稳定排序
	public static void optimized_3(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			// 二分查找的高位和低位
			int low = 0, high = i - 1;
			// 待插入的索引位置
			int index = binarySearch(array, low, high, cur);
			for (int j = i - 1; j > index - 1; j--) {
				array[j + 1] = array[j];
			}
			array[index] = cur;
		}
	}

	// 二分查找，返回待插入的位置
	private static int binarySearch(int[] array, int low, int high, int cur) {
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int mVal = array[mid];
			if (mVal < cur) {
				low = mid + 1;
			} else if (mVal > cur) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		// 未查到
		return low;
	}
}