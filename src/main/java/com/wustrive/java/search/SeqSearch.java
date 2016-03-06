package com.wustrive.java.search;

/**
 * 顺序查找算法
 * 基本思想： 
 * 从表的一端开始，顺序扫描线性表，依次将扫描到的结点关键宇和给定值K相比较。
 * 若当前扫描到的结点关键字与K相等，则查找成功；若扫描结束后，仍未找到关键字等于K的结点，则查找失败。 
 * 优点: 不要求待查找序列有序
 * 缺点: 效率低，特别是待查找序列很大时
 * @author wustrive
 * @Email  wustrive_2008@126.com
 * @date   2016年3月6日
 *
 */
public class SeqSearch {
	
	public int seqSearch(int[] data,int k){
		
		for (int i = 0; i < data.length; i++) {
			if(data[i] == k){
				return i ;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		SeqSearch seqSearch = new SeqSearch();
		int k = 3;
		int[] data = {4,5,6,32,3,4,6,2,1,9};
		
		int index = seqSearch.seqSearch(data, k);
		
		System.out.println("目标位置:"+index);
	}
}
