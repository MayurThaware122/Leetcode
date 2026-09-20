package Arrays.Medium;
//You are given an array nums with n objects colored red, white, or blue,
// sort them in-place so that objects of the same color are adjacent,
// with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.
//Example 1:
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Explanation:
//The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.

import java.util.Arrays;

public class Sort_Color {
    public static void main(String[] args) {
        int [] a = {2,0,1};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sortColors(int[] nums) {
            int zero = 0;
            int one = 0;
            int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zero++;
            } else if (nums[i] == 1) {
                one++;
            }
            else two++;
        }
        int start = 0 ;
        while(start < nums.length){
            if(zero > 0){
                nums[start] = 0;
                zero--;
                start++;
            }
            else if(one > 0){
                nums[start] = 1;
                one--;
                start++;
            }
            else{
                nums[start] = 2;
                start++;
            }
        }
    }
}
