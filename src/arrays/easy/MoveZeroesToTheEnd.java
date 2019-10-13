package src.arrays.easy;

// https://leetcode.com/problems/move-zeroes/

public class MoveZeroesToTheEnd {
	class Solution {
	    public void moveZeroes(int[] nums) {
	        int idx = 0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i] != 0){
	                nums[idx++] = nums[i];
	                System.out.println(idx);
	            }
	        }
	        for(int i=idx; i<nums.length;i++){
	            nums[i] = 0;
	        }
	    }
	}
}

/**
 * 
 * The question is asking to do it in place
 * 
 * T - O(N), S - O(N) 
 * One solution here can be to get all the non zero elements inside another array
 * We could create another array of the same size and input all elements from this array and then append the rest with zeroes.
 * 
 * 
 * T - O(N), S - O(1)
 * In the current solution, we are not creating an array but keep a variable to track insert. That variable starts from 0 i.e. start from array so we can be sure that
 * the elements we are going to insert are going to be insert form the start.
 * 
 * Once we have done the iteration, we need to fill the rest of the indices with zero. So we will start from wherever that insert variable ended and inserts zeroes till the end.
 */
