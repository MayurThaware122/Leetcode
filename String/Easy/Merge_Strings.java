package String.Easy;
//1768
//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, 
// starting with word1. If a string is longer than the other, 
// append the additional letters onto the end of the merged string.
//Return the merged string.
//Example 1:
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
//Example 2:
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//word1:  a   b 
//word2:    p   q   r   s
//merged: a p b q   r   s

public class Merge_Strings {
    public static void main(String [] args){
        System.out.println(mergeAlternately("ab","pqrs"));
        System.out.println(merge2("ab","pqrs"));
    }
    public static String mergeAlternately(String word1, String word2) {
        String ans = "";
        int len = word1.length();
        if(word2.length() > word1.length())len = word2.length();

        for(int i =0;i < len;i++){
            if(i < word1.length())ans += word1.charAt(i);
            if(i < word2.length())ans += word2.charAt(i);
        }
        return ans;
    }
    //Same logic , but with StringBuilder
    public static String merge2(String word1,String word2){
        StringBuilder ans  = new StringBuilder();
        int len = word1.length();
        if(word2.length() > word1.length())len = word2.length();

        for(int i =0;i < len;i++){
            if(i < word1.length())ans.append(word1.charAt(i));
            if(i < word2.length())ans.append(word2.charAt(i));
        }
        return ans.toString();
    }
}
