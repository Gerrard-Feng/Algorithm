package com.gerrard.array;

import java.util.Arrays;
import java.util.Random;

public class Array {

	/**
	 * 随机数组，实现原理：
	 * 1.随机创建长度相等的新数组，升序排序，获得索引数组
	 * 2.根据索引值对原数组重构
	 * 
	 * @param array 待随机的数组
	 */
	public static int[] randomArray(int[] array) {
		final int LENGTH = array.length;
		// 目标排序数组
		int[] sortArray = new int[LENGTH];
		// 随机赋值
		Random random = new Random();
		for (int i = 0; i < LENGTH; i++) {
			sortArray[i] = random.nextInt(1024);
		}
		// 目标排序数组的副本
		int[] copyArray = Arrays.copyOf(sortArray, LENGTH);
		// 存放索引值的数组
		int[] indexArray = new int[LENGTH];
		// 初始化完毕，以下开始获取索引数组
		// 交换用
		int temp;
		final int MIN = Integer.MIN_VALUE;
		// 初始化最大值和其索引值
		int max = sortArray[0];
		int maxIndex = 0;
		// 类冒泡排序
		// 外循环，考虑到需要做最后一次循环
		for (int i = 0; i < LENGTH; i++) {
			// 内循环每次遍历至尾部
			for (int j = 0; j < LENGTH - 1; j++) {
				if (sortArray[j] > sortArray[j + 1]) {
					if (sortArray[j] > max) {
						max = sortArray[j];
						maxIndex = j;
					}
					// 交换
					temp = sortArray[j];
					sortArray[j] = sortArray[j + 1];
					sortArray[j + 1] = temp;
				}
			}
			// 内循环没考虑，原来数组最大数在最后一位的情况，加一次判断
			if (max < sortArray[LENGTH - 1]) {
				max = sortArray[LENGTH - 1];
				maxIndex = LENGTH - 1;
			}
			// 最后一位是最大数，索引数组从最后一位开始赋值
			indexArray[sortArray.length - i - 1] = maxIndex;
			// 找到的最大数，变为最小数，副本内容给排序数组
			copyArray[maxIndex] = MIN;
			sortArray = Arrays.copyOf(copyArray, LENGTH);
			// 重置max和maxIndex
			max = sortArray[0];
			maxIndex = 0;
		}
		// 根据索引赋值
		int[] targetArray = new int[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			targetArray[indexArray[i]] = array[i];
		}
		return targetArray;
	}
}