package com.wustrive.java.search;

/**
 * 基本思想： 
 * 1. 首先将查找表分成若干块，在每一块中数据元素的存放是任意的，但块与块之间必须是有序的（假设这种排序是按关键字值递增的，也就是说在第一块中任意一个数据元素的关键字都小于第二块中所有数据元素的关键字，第二块中任意一个数据元素的关键字都小于第三块中所有数据元素的关键字，依次类推）； 
 * 2. 建立一个索引表，把每块中最大的关键字值按块的顺序存放在一个辅助数组中，这个索引表也按升序排列； 
 * 3. 查找时先用给定的关键字值在索引表中查找，确定满足条件的数据元素存放在哪个块中，查找方法既可以是折半方法，也可以是顺序查找。 
 * 4. 再到相应的块中顺序查找，便可以得到查找的结果。 
 * 优点： 
 * ①在表中插入或删除一个记录时，只要找到该记录所属的块，就在该块内进行插入和删除运算。 
 * ②因块内记录的存放是任意的，所以插入或删除比较容易，无须移动大量记录。 
 * 分块查找的主要代价是增加一个辅助数组的存储空间和将初始表分块排序的运算。 
 * 分块查找算法的效率介于顺序查找和二分查找之间。
 * 
 * 
 * @author wustrive
 * @Email  wustrive_2008@126.com
 * @date   2016年3月6日
 *
 */
public class BlockSearch {
	
	/**
	 * 
	 * @param index  索引表
	 * @param data   顺序表
	 * @param key    目标值
	 * @param m      块长度
	 * @return       目标位置
	 */
	public int searchByBlock(int[] index,int[] data,int key,int m){
		int i = partSearchs(index, key);  
		System.out.println(i);
		if(i >= 0){
			int j = i > 0 ? i * m : i;
			int len = (i + 1) * m;

			for (int k = j; k < len; k++) {
				if(key == data[k]){
					return k;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找所属块
	 * @param data
	 * @param tmpData
	 * @return
	 */
	private int partSearchs(int[] data, int tmpData) {
		int mid; 
        int low = 0; 
        int high = data.length - 1; 
        while(low <= high) 
        { 
            mid = (low + high) / 2;     
            if(tmpData == data[mid]) 
            { 
                return mid;             
            } 
            else if(tmpData < data[mid])     
            { 
                high = mid - 1; 
            } 
            else 
            { 
                low = mid + 1; 
                return low; 
            } 
        } 
        return -1;               
	}

	
	public static void main(String[] args) {
		int[] data = {1,3,2,4,6,5,7,9,8};
		int[] index = {3,6,9};
		BlockSearch bs = new BlockSearch();
		int value = bs.searchByBlock(index, data, 9, 3);
		System.out.println("目标位置:"+value);
	}
	
}
