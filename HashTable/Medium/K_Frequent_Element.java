package HashTable.Medium;
import java.util.*;
//Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.
//Example 1:
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
public class K_Frequent_Element {
    //A very good approach is HashMap + Bucket Sort, which runs in O(n) time.

    public static void main(String[] args) {

    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<Integer,Integer> ();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        //Exactly — this is the reason bucket contains a List at every index instead of just one integer.
        //i am not getting the logic like if bucket is like frequency index
        // then what to do when two element have same frequency
        List <Integer> [] bucket = new List[nums.length + 1];
        //so here key set return type is set which do not have the concept of indexing
        //hence we need to the use the enhance for loop
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        int ans [] =new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0 ; i--) {
            if(bucket[i] != null){
                for (int n : bucket[i]) {
                    ans[index] = n;
                    index++;
                    if(index == k) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
