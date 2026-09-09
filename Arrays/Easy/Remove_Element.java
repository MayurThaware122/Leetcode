package Arrays.Easy;

import java.util.Arrays;

// 27 remove element
//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The order of the elements may be changed.
// Then return the number of elements in nums which are not equal to val.
//Consider the number of elements in nums which are not equal to val be k,
// to get accepted, you need to do the following things:
//Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
// The remaining elements of nums are not important as well as the size of nums.
public class Remove_Element {
    public static void main(String [] args){
        int [] a = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(a,2));
        System.out.println(Arrays.toString(a));
    }
    public static int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right){
            if(nums[right] == val) {
                right--;
            }
            else if(nums[left] == val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            else{
                left++;
            }
        }
        return left;
    }
}
