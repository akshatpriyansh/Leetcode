// https://leetcode.com/problems/majority-element/

package src.arrays.easy;

import java.util.HashMap;

public class MajorityElement {
	class Solution {
	    public int majorityElement(int[] nums) {
	        if(nums.length == 0 ) return 0;
	        if(nums.length == 1) return nums[0];
	        int output = -1;
	        int fix = nums.length/2;
	        HashMap<Integer, Integer> hm = new HashMap<>();
	        for(int i : nums){
	            if(!hm.containsKey(i)){
	                hm.put(i, 1);
	            } else {
	                int num = hm.get(i) + 1;
	                hm.put(i, num);
	                output = i;
	                if(num > fix) return i;
	            }
	        }
	        
	        return output == -1 ? nums[0] : output;
	    }
	}
}

/**
 * Solving it using generic HashMap way.
 * - Counting frequency of all integers until on hits the bench. Return it then and there.
 * - Fixed for corner cases
 */
