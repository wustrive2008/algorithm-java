package com.wustrive.java.sort;

/**
 * 选择排序
 * 
 * 
 * 基本原理：先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * 
 * @author wustrive
 * @Email  wustrive_2008@126.com
 * @date   2016年3月6日
 *
 */
public class SelectSort {
	
	public void select_sort(int[] data, int len) {
		for (int i = 0; i < len; i++) {
			// 已排序末尾索引
			int index = i;

			// 找出下一个目录元素
			for (int j = i + 1; j < len; j++) {
				if (data[j] < data[index]) {
					index = j;
				}
			}

			// 目标位置插入已排序序列末尾
			if (index != i) {
				int temp = data[i];
				data[i] = data[index];
				data[index] = temp;
			}
		}
	}

	public static void main(String[] args) {
		SelectSort selectSort = new SelectSort();
		int[] data = { 6, 5, 7, 4, 3, 8, 9, 2, 1, 0, 4 };
		selectSort.select_sort(data, data.length);
		for (int i : data) {
			System.out.print(i + " ");
		}
	}
}
