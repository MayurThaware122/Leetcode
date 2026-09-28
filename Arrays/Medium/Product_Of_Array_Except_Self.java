package Arrays.Medium;
import java.util.*;
//238
// Given an integer array nums, return an array answer such that answer[i]
// is equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.
//Example 1:
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]

public class Product_Of_Array_Except_Self {
    public static void main(String [] args){
            int [] a = {-1,1,0,-3,3};
            System.out.println(Arrays.toString(productExceptSelf(a)));

    }
    public static int[] productExceptSelf(int[] nums) {
        //we always need to array like for solving this type of problem
        // it also says prefix sum in the topic
        // making two array
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        // assigning the 1 to 0 index of left as there is noting to left side of it
        // assigning the 1 to the last index of right as there is nothing to the right of it
        left[0] = 1;
        right[right.length - 1]= 1;
        //for Product Except Self, we store the product before the current element:
        for(int i = 1 ; i < left.length;i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        // now same for the right array also product from the back side of the array but no including it
        for(int i = right.length - 2;i >= 0;i--){
            right[i] = nums[i + 1] * right[i + 1];
        }
        // so now merging the product of left side except the self number and the product of right
        //we get the prodect of all in array except the self

        int [] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
