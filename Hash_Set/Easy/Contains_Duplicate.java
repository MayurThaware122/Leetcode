package Hash_Set.Easy;
import java.util.*;
// 217 Given an integer array nums,
// return true if any value appears at least twice in the array, and return false if every element is distinct.
public class Contains_Duplicate {
    public static void main(String [] args){
        int [] a = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(a));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer> ();
        for(int i = 0 ; i < nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
