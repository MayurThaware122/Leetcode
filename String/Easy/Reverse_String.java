package String.Easy;
//Write a function that reverses a string. The input string is given as an array of characters s.
//You must do this by modifying the input array in-place with O(1) extra memory.
//Example 1:
//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]

import java.util.Arrays;

public class Reverse_String {
    public static void main(String[] args) {
            char [] s = {'h','e','l','l','o'};
            reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        for(int i = 0 ; i < s.length/2;i++){
            char temp = s[i];
            s[i] =  s[s.length - 1 -  i] ;
            s[s.length - 1- i] = temp;
        }
    }
}
