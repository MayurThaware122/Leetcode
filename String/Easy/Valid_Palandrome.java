package String.Easy;
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
// removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.
//Example 1:
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
public class Valid_Palandrome {
    public static void main(String [] args){
        System.out.println(isPalindrome(" "));
    }
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            else{
                char a = Character.toLowerCase(s.charAt(start));
                char b = Character.toLowerCase(s.charAt(end));

                if(a != b){
                    return false;
                }
                else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}
