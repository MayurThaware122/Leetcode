package Arrays.Easy;

import java.util.HashMap;

//iven an integer array nums and an integer k,
// return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
public class Contains_Duplicate_2 {
    public static void main(String[] args){
        int [] a = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(a,2));
        System.out.println(containsduplicaate2(a,2));
    }
    // brute force
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1;
                 j < nums.length && j - i <= k;
                 j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // using hash map also
    public static boolean containsduplicaate2(int [] nums,int k){
        if(k == 0)return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer> ();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int previousindex = map.get(nums[i]);
                if(i - previousindex <= k)return true;
            }
                map.put(nums[i] , i);

        }
        return false;
    }
}
