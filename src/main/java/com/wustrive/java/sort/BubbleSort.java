package com.wustrive.java.sort;

/**
 * 冒泡排序
 * 
 * 基本原理：
 * 相邻的数据进行两两比较，小数放在前面，大数放在后面，
 * 这样一趟下来，最小的数就被排在了第一位，第二趟也是如此，
 * 如此类推，直到所有的数据排序完成
 * 
 * @author wustrive
 * @Email  wustrive_2008@126.com
 * @date   2016年3月6日
 *
 */
public class BubbleSort {
	/**
	 * 
	 * @param data
	 *            待排序列
	 */
	public void bubble_sort(int[] data,int len) {
		boolean change = false;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = temp;

					change = true;
				}
			}
			// 如果冒泡过程中没有发生交换，则视序列已经排好序，减少无谓的比较
			if (!change) {
				return;
			}
			change = false;
		}
	}

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] data = { 3, 4, 9, 0, 1, 5, 2, 5, 3, 7, 6 };
		bubbleSort.bubble_sort(data, data.length);
		for (int i : data) {
			System.out.print(i + " ");
		}
	}
}
