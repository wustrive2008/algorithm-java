package com.wustrive.java.sort;

/**
 * 
 * 
 * 算法原理（以最大堆为例）
 * 
 * 先将初始数据R[1..n]建成一个最大堆，此堆为初始的无序区
 * 再将关键字最大的记录R[1]（即堆顶）和无序区的最后一个记录R[n]交换，由此得到新的无序区R[1..n-1]和有序区R[n]，且满足R[1..n-1].keys≤R[n].key
 * 由于交换后新的根R[1]可能违反堆性质，故应将当前无序区R[1..n-1]调整为堆。
 * 重复2、3步骤，直到无序区只有一个元素为止。
 * 
 * 
 * @ClassName: HeapSort 
 * @author wustrive
 * @date 2016年3月19日 下午4:42:07 
 *
 */
public class HeapSort {
	private void heapAdjust(int arr[],int i, int len){
		int child = -1 ,temp = -1;
		for(; i * 2 + 1 < len; i = child){
			child = 2 * i + 1;
			if(child < len - 1 && arr[child + 1] > arr[child]){
				child ++;
			}
			if(arr[i] < arr[child]){
				temp = arr[i];
				arr[i] = arr[child];
				arr[child] = temp;
			}else{
				break;
			}
		}
	}
	
	public void heapSort(int arr[], int len){
		for (int i = len/2 - 1; i >= 0; i--) {
			heapAdjust(arr, i, len);
		}
		for(int j = len - 1; j > 0; j--){
			int temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
			
			heapAdjust(arr, 0, j);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,5,7,4,2,8,2,9,3,1,0};
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(arr, arr.length);
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}
