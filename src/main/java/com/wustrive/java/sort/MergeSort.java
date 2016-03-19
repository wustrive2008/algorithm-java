package com.wustrive.java.sort;


/**
 * 基本原理：
 *
 * 归并排序具体工作原理如下（假设序列共有n个元素）：
 *
 * 将序列每相邻两个数字进行归并操作（merge)，形成floor(n/2)个序列，排序后每个序列包含两个元素
 * 将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
 *
 * 重复步骤2，直到所有元素排序完毕
 * 归并排序是稳定的排序算法，其时间复杂度为O(nlogn)，如果是使用链表的实现的话，空间复杂度可以达到O(1)，但如果是使用数组来存储数据的话，在归并的过程中，需要临时空间来存储归并好的数据，所以空间复杂度为O(n)
 * 
 * @ClassName: MergeSort 
 * @author wustrive
 * @date 2016年3月19日 下午4:54:10 
 *
 */
public class MergeSort {
	private void merge(int arr[],int temp_arr[],int start_index,int mid_index,int end_index){
		int i = start_index,j = mid_index + 1;
		int k = 0;
		while(i < mid_index + 1 && j < end_index +1){
			if(arr[i] > arr[j]){
				temp_arr[k++] = arr[j++];
			}else{
				temp_arr[k++] = arr[i++];
			}
		}
		
		while(i < mid_index + 1){
			temp_arr[k++] = arr[i++];
			
		}
		while(j < end_index + 1){
			temp_arr[k++] = arr[j++];
		}
		
		for (i = 0, j = start_index; j < end_index + 1; i++,j++) {
			arr[j] = temp_arr[i];
		}
		
	}
	
	public void mergeSort(int arr[],int temp_arr[], int start_index,int end_index){
		if(start_index < end_index){
			int mid_index = (start_index + end_index)/2;
			mergeSort(arr, temp_arr, start_index, mid_index);
			mergeSort(arr, temp_arr, mid_index + 1, end_index);
			merge(arr, temp_arr, start_index, mid_index, end_index);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,6,1,3,0,4,6,8,6,5,7};
		int[] temp_arr = new int[13];
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(arr, temp_arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.print(i+ " ");
		}
	}
}
