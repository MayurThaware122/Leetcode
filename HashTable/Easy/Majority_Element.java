package HashTable.Easy;
import java.util.*;
//196 . Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
//Example 1:
//Input: nums = [3,2,3]
//Output: 3
public class Majority_Element {
    public static void main(String [] args){
        int [] a = {6,5,5};
        System.out.println(majorityElement(a));
        System.out.println(majority_element2(a));
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = 0;

        for(int element : nums){
            map.put(element,map.getOrDefault(element,0) + 1);
        }
        for(int num : nums){
            if(map.get(num) > nums.length / 2){
                ans = num;
            }

        }
        return ans;
    }
    // the upper approach is optimum but space complexity for hashMap is O(N) and time complexity is O(N)

    // another approch wich is like the use of the algo called Boyer–Moore Voting Algorithm
    // (or Boyer–Moore Majority Vote Algorithm).
    // so like in it we do some thing like this

    //num    candidate    count
    //2         2           1
    //2         2           2
    //1         2           1    ← 1 cancels one 2
    //1         2           0    ← another cancellation
    //
    //1         1           1    ← count=0, choose new candidate
    //2         1           0
    //
    //2         2           1    ← choose new candidate

    // here is the code with that approch also
    public static int majority_element2(int [] arr){
        //using boyer moore algo
        int candiate = 0; //?
        int count = 0;
        for(int n : arr){
            if(count == 0) {
                candiate = n;
                count++;
            }
            else if(count > 0) {
                if (candiate != n) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return candiate;
    }
}
