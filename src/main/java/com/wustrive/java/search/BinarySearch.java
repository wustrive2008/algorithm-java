package com.wustrive.java.search;

/**
 * 二分查找算法
 * 条件：数组递增 
 * 基本思想： 
 * 1.	查找区间R[low..high]，首先确定该区间的中点位置：mid = (low + high) / 2; 
 * 2.	然后将待查的K值与R[mid]比较：若相等，则查找成功并返回此位置，否则须确定新的查找区间，继续二分查找。 
 * ① 若R[mid] > K，则由数组的有序性可知R[mid..n]均大于K，因此该结点必定是在位置mid左边的R[0..mid-1]中 
 * ② 若R[mid] < K，则要查找的K必在mid的右边的R[mid+1..n]中，下一次查找是针对新的查找区间进行的。 
 * 3.	因此，从初始的查找区间R[1..n]开始，每经过一次与当前查找区间的中点位置上的结点关键字的比较，就可确定查找是否成功，不成功则当前的查找区间就缩小一半。这一过程重复直至找到关键字为K的结点，或者直至当前的查找区间为空(即查找失败)时为止。 
 * 
 * @author wustrive
 * @Email  wustrive_2008@126.com
 * @date   2016年3月6日
 *
 */
public class BinarySearch {
	
	private int rCount = 0;  //递归查找次数
	private int lCount = 0;  //循环查找次数
	public int getrCount() {
		return rCount;
	}
	public int getlCount() {
		return lCount;
	}
	
	/**
	 * 递归查找方式
	 * @param sortedData
	 * @param start
	 * @param end
	 * @param findValue
	 * @return
	 */
	public int searchRecursive(int[] sortedData,int start,int end,int findValue){
		rCount ++;
		if(start <= end){
			int middle = start + (end - start) / 2;
			int middleValue = sortedData[middle];
			if(findValue == middleValue){
				return middle;
			}else if(findValue < middleValue){
				return searchRecursive(sortedData, start, middle-1, findValue);
			}else{
				return searchRecursive(sortedData, middle+1, end, findValue);
			}
		}else{
			return -1;
		}
	}
	
	/**
	 * 循环查找方式
	 * @param sortedData
	 * @param findValue
	 * @return
	 */
	public int searchLoop(int[] sortedData,int findValue){
		int start = 0;
		int end = sortedData.length - 1;
		while(start <= end){
			lCount ++;
			int middle = start + (end - start) / 2;
			int middleValue = sortedData[middle];
			if(findValue == middleValue){
				return middle;
			}else if(findValue < middleValue){
				end = middle - 1;
			}else{
				start = middle + 1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int[] sortedData = {1,2,3,4,5,6,7,8,9,10};
		
		int findValue=9;  
		int length=sortedData.length; 
		
		int pos=binarySearch.searchRecursive(sortedData, 0, length-1, findValue);  
        System.out.println("Recursice:"+findValue+" found in pos "+pos+";count:"+binarySearch.getrCount()); 
        
        int pos2=binarySearch.searchLoop(sortedData, findValue);  
        System.out.println("Loop:"+findValue+" found in pos "+pos+";count:"+binarySearch.getlCount());  
	}
}
