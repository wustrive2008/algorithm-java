package com.wustrive.java.sort;

/**
 * 直接插入排序
 * 
 * 
 * 基本原理
 * 将数据分为两部分，有序部分与无序部分，
 * 一开始有序部分包含第1个元素，依次将无序的元素插入到有序部分，直到所有元素有序。
 * 插入排序又分为直接插入排序、二分插入排序、链表插入等，
 * 它是稳定的排序算法，时间复杂度为O(n^2)
 * 
 * @author wustrive
 * @Email  wustrive_2008@126.com
 * @date   2016年3月6日
 *
 */
public class InsertSort {
	public void insert_sort(int[] data, int len) {
		for (int i = 1; i < len; i++) {
			int j = i - 1; 
			int k = data[i]; //待插入的数

			//查找目标位置
			while (j > -1 && k < data[j]) {
				data[j + 1] = data[j];
				j--;
			}
			//插入目标位置
			data[j + 1] = k;
		}
	}

	public static void main(String[] args) {
		InsertSort insertSort = new InsertSort();
		int[] data = { 4, 5, 7, 3, 2, 9, 2, 3, 0, 9, 8 };
		insertSort.insert_sort(data, data.length);
		for (int i : data) {
			System.out.print(i + " ");
		}
	}
}
