package HashTable.Medium;
import java.util.*;
//229
//Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.
//Example 1:
//Input: nums = [3,2,3]
//Output: [3]
//Example 2:
//Input: nums = [1]
//Output: [1]
//Example 3:
//Input: nums = [1,2]
//Output: [1,2]
//Constraints:
//1 <= nums.length <= 5 * 104
//-109 <= nums[i] <= 109
//Follow up: Could you solve the problem in linear time and in O(1) space?

public class Majority_Element_2 {
    // same solution as we solve the majority element under easy tag
    //hashtable solution
    public static void main(String [] args){
        int [] a = {3,2,3};
        List<Integer> ls = majorityElement2(a);
        for(int element : ls) {
            System.out.print(element + " ");
        }
    }
    public static List<Integer> majorityElement(int[] nums) {
        List <Integer> lst = new ArrayList<Integer>();
        //base case for like length is less that 3
        int ln = nums.length ;
        if(ln < 3){
            for(int elm : nums){
                if(!lst.contains(elm)){
                    lst.add(elm);
                }
            }
            return lst;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int element : nums){
            map.put(element,map.getOrDefault(element,0) + 1);
        }
        for(int num : nums){
            if(map.get(num) > nums.length / 3){
                if(!lst.contains(num)){
                    lst.add(num);
                }
            }

        }
        return lst;
    }
    // let's try to solve with space complexity constant
    // like we did in majority element easy question with the help of
    // the use of the algo called Boyer–Moore Voting Algorithm
 // for this specific problem, there can be at most 2 elements that appear more than n/3 times,
    // no matter how large the array is.
    //Because if there were 3 such elements, each would need frequency greater than n/3:
    //3 × (more than n/3) > n
    //That would require more than n positions total, which is impossible.

    public static List<Integer> majorityElement2(int [] nums){
        List <Integer> lst = new ArrayList<Integer>();
        //base case for like length is less that 3
        int ln = nums.length ;
        if(ln < 3){
            for(int elm : nums){
                if(!lst.contains(elm)){
                    lst.add(elm);
                }
            }
            return lst;
        }
        // now for the length greater than or equal to the 3
        int candidate1 = 0;
        int candidate2 = 1;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = num;
                count1++;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2++;
            }
            else{
                count2--;
                count1--;
            }
        }
        // now actually counting the number of time they occur
        count2 = 0;
        count1 = 0;
        for(int num : nums){
            if ( num == candidate1){
                count1++;
            }
            else if (num == candidate2){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            lst.add(candidate1);
        }
        if(count2 > nums.length / 3){
            lst.add(candidate2);
        }
        return lst;
    }
}
