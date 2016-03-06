package com.wustrive.java.sort;

/**
 * 快速排序
 * 
 * 基本原理：
 * 快速排序是目前在实践中非常高效的一种排序算法，它不是稳定的排序算法，平均时间复杂度为O(nlogn)，最差情况下复杂度为O(n^2)。
 * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 
 * @author wustrive
 * @Email wustrive_2008@126.com
 * @date 2016年3月6日
 *
 */
public class QuickSort {

	public void quick_sort(int[] data, int left, int right) {
		if (left < right){
			int i = left, j = right, target = data[left];
			while(i < j){
				//从后向前
				while (i < j && data[j] > target) 
					j--;
				if (i < j) 
					data[i++] = data[j];
				
				//从前向后
				while (i < j && data[i] < target)
					i++;
				if (i < j)
					data[j] = data[i];
			}
			
			data[i] = target; 
			quick_sort(data, left, i - 1); 
			quick_sort(data, i + 1, right);
		}
	}

	
	
	public static void main(String[] args) {
		int[] list = { 5, 3, 4, 7, 3, 7, 9, 8, 0 };
		QuickSort qs = new QuickSort();
		qs.quick_sort(list, 0,list.length-1);
		for (int i : list) {
			System.out.print(i + " ");
		}
	}

}
