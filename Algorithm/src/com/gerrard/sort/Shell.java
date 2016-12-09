package com.gerrard.sort;

/**
 * 希尔排序
 * 
 * @author kevin_gerrard@sina.com
 *
 */
public class Shell {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 初始增量
		int d = array.length >>> 1;
		while (d > 0) {
			// d 次直接插入排序
			for (int i = 0; i < d; i++) {
				// 组内进行，相隔增量 d 项的直接插入排序
				for (int j = i + d; j < array.length; j += d) {
					int cur = array[j];
					boolean flag = false;
					for (int k = j - d; k > -1; k -= d) {
						if (cur < array[k]) {
							array[k + d] = array[k];
						} else {
							array[k + d] = cur;
							flag = true;
							break;
						}
					}
					if (!flag) {
						array[i] = cur;
					}
				}
			}
			// 每次增量减半
			d >>>= 1;
		}
	}

	// 优化：记录上一次插入的位置
	public static void optimized_1(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 初始增量
		int d = array.length >>> 1;
		while (d > 0) {
			for (int i = 0; i < d; i++) {
				int checkN = array[i];
				int checkI = i;
				// 组内进行，相隔增量 d 项的直接插入排序
				for (int j = i + d; j < array.length; j += d) {
					int cur = array[j];
					int start = j - d;
					// 根据上一个值，定位开始遍历的位置
					if (cur < checkN) {
						start = checkI;
						for (int k = j - d; k > start - d; k -= d) {
							array[k + d] = array[k];
						}
					}
					boolean flag = false;
					for (int k = start; k > -1; k -= d) {
						if (cur < array[k]) {
							array[k + d] = array[k];
						} else {
							array[k + d] = cur;
							checkN = cur;
							checkI = k + d;
							flag = true;
							break;
						}
					}
					if (!flag) {
						array[i] = cur;
					}
				}
			}
			// 每次增量减半
			d >>>= 1;
		}
	}

	// 优化：二分查找定位
	public static void optimized_2(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// 初始增量
		int d = array.length >>> 1;
		while (d > 0) {
			for (int i = 0; i < d; i++) {
				// 二分查找定位
				for (int j = i + d; j < array.length; j += d) {
					int cur = array[j];
					int low = i, high = j - d;
					int index = binarySearch(array, low, high, cur, d);
					for (int k = j - d; k > index - d; k -= d) {
						array[k + d] = array[k];
					}
					array[index] = cur;
				}
			}
			// 每次增量减半
			d >>>= 1;
		}
	}

	// 二分查找，返回待插入的位置
	private static int binarySearch(int[] array, int low, int high, int cur, int d) {
		while (low <= high) {
			// 带增量 d 的中间数，是不一样的
			// 注意移位运算符的优先级
			int mid = ((low / d + high / d) >>> 1) * d + low % d;
			int mVal = array[mid];
			if (mVal < cur) {
				low = mid + d;
			} else if (mVal > cur) {
				high = mid - d;
			} else {
				return mid;
			}
		}
		// 未查到
		return low;
	}
}