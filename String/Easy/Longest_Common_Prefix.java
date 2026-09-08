package String.Easy;
// 14 number question
// Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//Example 1:
//Input: strs = ["flower","flow","flight"]
//Output: "fl"

public class Longest_Common_Prefix {
    public static void main(String [] args){
        String [] a = {"ab" ,"a"};
        System.out.println(longestCommonPrefix2(a));
    }
    //brut force solution 
    public static String longestCommonPrefix(String[] strs) {
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() < min) min = strs[i].length();
        }   
        
        String ans = "";
        for (int i = 0; i < min; i++) {
            int count = 0;
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != temp)return ans;
                else count++;
            }
            if(count == strs.length - 1) {
                ans += temp;
                count = 0;
            }
        }
        return ans;
    }
    //  better approach
    public static String longestCommonPrefix2(String[] strs) {
        for(int i = 0 ; i< strs[0].length();i++){
            for(int j = 1 ; j < strs.length;j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
