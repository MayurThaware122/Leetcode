package Arrays.Easy;//1929. Concatenation of Array
//Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i]
//and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//Specifically, ans is the concatenation of two nums arrays.

import java.util.Arrays;

public class Concatenation_of_Array {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n * 2];
        for(int i = 0 ; i < n;i++){
            ans[i] = nums[i];
            ans[i+ n] = nums[i];
        }
        return ans;
    }
}