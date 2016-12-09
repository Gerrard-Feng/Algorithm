package com.gerrard.sort;

/**
 * ϣ������
 * 
 * @author kevin_gerrard@sina.com
 *
 */
public class Shell {

	public static void basal(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// ��ʼ����
		int d = array.length >>> 1;
		while (d > 0) {
			// d ��ֱ�Ӳ�������
			for (int i = 0; i < d; i++) {
				// ���ڽ��У�������� d ���ֱ�Ӳ�������
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
			// ÿ����������
			d >>>= 1;
		}
	}

	// �Ż�����¼��һ�β����λ��
	public static void optimized_1(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// ��ʼ����
		int d = array.length >>> 1;
		while (d > 0) {
			for (int i = 0; i < d; i++) {
				int checkN = array[i];
				int checkI = i;
				// ���ڽ��У�������� d ���ֱ�Ӳ�������
				for (int j = i + d; j < array.length; j += d) {
					int cur = array[j];
					int start = j - d;
					// ������һ��ֵ����λ��ʼ������λ��
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
			// ÿ����������
			d >>>= 1;
		}
	}

	// �Ż������ֲ��Ҷ�λ
	public static void optimized_2(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		// ��ʼ����
		int d = array.length >>> 1;
		while (d > 0) {
			for (int i = 0; i < d; i++) {
				// ���ֲ��Ҷ�λ
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
			// ÿ����������
			d >>>= 1;
		}
	}

	// ���ֲ��ң����ش������λ��
	private static int binarySearch(int[] array, int low, int high, int cur, int d) {
		while (low <= high) {
			// ������ d ���м������ǲ�һ����
			// ע����λ����������ȼ�
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
		// δ�鵽
		return low;
	}
}