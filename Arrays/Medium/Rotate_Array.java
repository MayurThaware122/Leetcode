package Arrays.Medium;

import java.util.Arrays;

//189
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//Example 1:
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
public class Rotate_Array {
    public static void main (String [] args){
        int [] a  = {-1,-100,3,99};
        rotate(a,2);
        System.out.println(Arrays.toString(a));
    }
    public static void rotate(int[] nums, int k) {
        int r = k % nums.length;
        if(r == 0) return;
        // reverse the array
        for(int i = 0; i < nums.length / 2 ;i++){
            int temp = nums[i];
            nums[i] =  nums[nums.length - 1 - i];
            nums[nums.length - 1- i] = temp;
        }
        // reversing till the k th position
        for(int i = 0 ; i < r / 2 ; i++){
            int temp = nums[i];
            nums [i] = nums[r - 1 - i] ;
            nums[r - 1 - i] = temp;
        }
        // reversing form k th position to the length
        // big improvement brother user r + nums.length not k + nums.length you did that why there was error
        // with following test case
        // Input
        //nums =
        //[-2147483648,0,2147483647]
        //k =
        //100000
        //Use Testcase
        //Output
        //[2147483647,0,-2147483648]
        //Expected
        //[2147483647,-2147483648,0]
        for(int i = r ; i < (r + nums.length) / 2 ; i ++){
            int temp =  nums[i];
            nums[i] = nums[nums.length - 1 - (i - r)];
            nums[nums.length - 1 - (i - r)] = temp;
        }

    }

    // alternative solution
    public static void rotate1(int[] nums, int k) {
        int len = nums.length - 1;
        int index = k % nums.length;
        reverse(nums,0,len);
        reverse(nums,index,len);
        reverse(nums,0,index - 1);
    }
    public static int [] reverse(int [] nums, int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
