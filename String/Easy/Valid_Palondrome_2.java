package String.Easy;
//Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//Example 1:
//Input: s = "aba"
//Output: true
//Example 2:
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.

public class Valid_Palondrome_2 {
    public static void main(String [] args){
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        int allowed  = 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return (isPalnadromme(s,start + 1,end) || isPalnadromme(s,start,end - 1));
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalnadromme(String s , int i , int j){
        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
