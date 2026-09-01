import java.util.*;
import java.util.Arrays;


class Two_sum {
    public static void main (String [] args){
        int a [] = {2,7,11,15} ;
        int t = 9 ;
        System.out.println(Arrays.toString(twoSum(a,t)) );
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> map = new HashMap<Integer,Integer> ();
        for(int i = 0 ; i < nums.length - 1;i++){
            int find = target - nums[i];
            if(map.containsKey(find)){
                return new int [] {map.get(find) , i};
            }
            else {
                map.put(nums[i], i);
            }
        }

        return new int [] {};
    }
}