package io.apicode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].

Return the array ans.

 

Example 1:

Input: nums = [1,2,3,2,2,1,3], k = 3
Output: [3,2,2,2,3]
Explanation: The number of distinct elements in each subarray goes as follows:
- nums[0:2] = [1,2,3] so ans[0] = 3
- nums[1:3] = [2,3,2] so ans[1] = 2
- nums[2:4] = [3,2,2] so ans[2] = 2
- nums[3:5] = [2,2,1] so ans[3] = 2
- nums[4:6] = [2,1,3] so ans[4] = 3
Example 2:

Input: nums = [1,1,1,1,2,3,4], k = 4
Output: [1,2,3,4]
Explanation: The number of distinct elements in each subarray goes as follows:
- nums[0:3] = [1,1,1,1] so ans[0] = 1
- nums[1:4] = [1,1,1,2] so ans[1] = 2
- nums[2:5] = [1,1,2,3] so ans[2] = 3
- nums[3:6] = [1,2,3,4] so ans[3] = 4
 * @author rajeevsingla
 *
 */

public class CountAllUnique {

	public static Integer[] distinctNumbers(int[] nums, int k) {
		Integer[] distinctNumCount = new Integer[nums.length - k + 1];
		
		Map<Integer, Integer> numToFreqMap = new HashMap<>();
		
		int start = 0, i = 0;
		
		for (int end = 0; end < nums.length; end++) {
			int rightNum = nums[end];
			
			numToFreqMap.put(rightNum, numToFreqMap.getOrDefault(rightNum, 0) + 1);
			
			if (end - start + 1 == k) {
				distinctNumCount[i++] = numToFreqMap.size();
				int leftNum = nums[start++];
				numToFreqMap.put(leftNum, numToFreqMap.get(leftNum) - 1);
				if (numToFreqMap.get(leftNum) == 0) {
					numToFreqMap.remove(leftNum);
				}
			}
		}
		return distinctNumCount;
	}

	public static void main(String[] args) {
		Integer[] result = distinctNumbers(new int[] { 2, 3, 4, 5, 6, 7, 1, 1, 1, 1, 1 }, 3);

		List<Integer> data = Arrays.asList(result);
		;

		System.out.println(data);
	}

}
