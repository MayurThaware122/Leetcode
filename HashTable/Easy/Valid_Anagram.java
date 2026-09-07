package HashTable.Easy;
import java.util.*;
//242 .Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true

public class Valid_Anagram {
    public static void main(String [] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int temp = map.get(s.charAt(i));
                temp++;
                map.put(s.charAt(i),temp);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i = 0 ; i < t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }
            else{
                int temp = map.get(t.charAt(i));
                if(temp == 0){
                    return false;
                }
                else{
                    temp--;
                    map.put(t.charAt(i),temp);
                }
            }
        }
        return true;
    }
// second approach using only array faster than hashmap

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())return false;
        int [] a = new int [26];
        int [] b = new int [26];
        for (int i = 0; i < s.length(); i++) {
            int tmep = s.charAt(i) - 'a';
            a[tmep]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int temp = t.charAt(i) - 'a';
            b[temp]++;
        }
        for (int i = 0; i < 26; i++) {
            if(a[i] != b[i])return false;
        }
        return true;
    }

}
