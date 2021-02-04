package com.code.lint.y2020.m01.d25;

/**
 * 描述
 *
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 */
public class TwoSum{
	public static void main(String[] args){
		int[] numbers = {2, 7, 11, 15};
		int[] result = twoSum(numbers,9);
		System.out.print("["+result[0]+","+result[1]+"]");
	}
	/**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
		/**
		 * @param numbers: An array of Integer
		 * @param target: target = numbers[index1] + numbers[index2]
		 * @return: [index1, index2] (index1 < index2)
		 */
		int[] index = new int[2];
		for(int i = 0; i < numbers.length; i++){
			for(int j=i+1;j<numbers.length;j++){
				if(numbers[i]+numbers[j]==target){
					index[0]=i;
					index[1]=j;
					return index;
				}
			}
		}
		return index;
    }
}