package org.leetcode.twosum_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    //first solution
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i=0; i<nums.length-1;i++){
            for(int j=1; j<nums.length-i;j++){
                if(nums[i] + nums[i+j] == target){
                    indices[0] = i;
                    indices[1] = (i+j);
                }
            }
        }
        return indices;
    }
    //second solution - not very efficient
    public int[] twoSum2(int[] nums, int target) {
        int[] indices = new int[2];
        List<Integer> numsList = new ArrayList<>();
        for(int num : nums){
            numsList.add(num);
        }
        for(int i=0; i<numsList.size(); i++){
            int subtraction = target - numsList.get(i);
            if(numsList.contains(subtraction) && numsList.indexOf(subtraction)!= i){
                indices[0] = numsList.indexOf(subtraction);
                indices[1] = i;
                break;
            }
        }
        return indices;
    }
    //third solution - most efficient
    public int[] twoSum3(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> numsAsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int subtraction = target - nums[i];
            if(numsAsMap.containsKey(subtraction)){
                indices[0]=numsAsMap.get(subtraction);
                indices[1]=i;
                return indices;
            }
            numsAsMap.put(nums[i],i);
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] test1 = new TwoSum().twoSum3(new int[]{2, 7, 11, 15}, 9);
        System.out.println("test1 expected = [0, 1]" + Arrays.toString(test1));
        int[] test2 = new TwoSum().twoSum3(new int[]{3,2,3}, 6);
        System.out.println("test2 expected = [0, 2] " + Arrays.toString(test2));
        int[] test3 = new TwoSum().twoSum3(new int[]{0,4,3,0}, 0);
        System.out.println("test3 expected = [0, 3] " + Arrays.toString(test3));
        int[] test4 = new TwoSum().twoSum3(new int[]{2,4,11,3}, 6);
        System.out.println("test4 expected = [0, 1]" + Arrays.toString(test4));
    }
}
