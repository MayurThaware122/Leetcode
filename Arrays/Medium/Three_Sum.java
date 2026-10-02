package Arrays.Medium;
import java.util.*;
//15
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
//Example 1:
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
public class Three_Sum {
    public static void main(String [] args){
        List<List<Integer>> demo = new ArrayList<List<Integer>>();
        int [] a = {0,0,0};
        demo = threeSum(a);
        for(List<Integer> l : demo){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //two pointer approach with one fixed number
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < nums.length - 2; i++){
            // if fixed number becomes positive, sum cannot become 0 as we have like sorted array
            // and left and right are bigger then i so there value will also be bigger only
            if (nums[i] > 0) {
                break;
            }
            if(i > 0 && (nums[i] == nums[i - 1])){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<Integer> ();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    left++;
                    right--;
                    // for input it was not working [1,2,0,1,0,0,0,0]
                    // hence we use this approach now
                    // skip duplicate left values
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // skip duplicate right values
                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}
