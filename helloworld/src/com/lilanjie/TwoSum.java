package com.lilanjie;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}

    // public static void main(String[] args) {
       //  int [] arr = new int []{2,7,9,11};
        // TwoSum twoSum = new TwoSum();

         //int[] ints = twoSum.twoSum(arr, 9);


        // System.out.println(ints[0]+" "+ints[1]);
     //}
