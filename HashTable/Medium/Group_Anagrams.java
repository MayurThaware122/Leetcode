package HashTable.Medium;

import java.util.*;

//49. Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//Example 1:
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//Explanation:
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

public class Group_Anagrams {
    public static void main(String[] args){
        String [] s = {"h","h","h","h"};
        List<List<String >> lt = groupAnagrams2(s);
        for(List<String> a : lt){
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i) + " ");
            }
            System.out.println();
        }
    }
// one of the good solution but still not god for all the test cases
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<List<String>>();
        }
        List<List<String>> ans = new ArrayList<List<String>> ();
        HashSet <String> set = new HashSet<String>();

        for (int i = 0; i < strs.length; i++) {
            if(set.contains(strs[i])){
                continue;
            }
            List<String> lst = new ArrayList<String>();
            boolean found = false;
            for (int j = i + 1; j < strs.length; j++) {
                // if this line is there it fail for the input strs =
                //["","",""]
                // so simple fix for it is use &&
                // but after it fail for the input ["h","h","h"]
                // so remove this if rest code work for all only Time limit exceds problem occur
                if(set.contains(strs[j]) && !strs[j].isEmpty()){
                    continue;
                }
                if(isAnagrams(strs[i], strs[j])){
                    lst.add(strs[j]);
                    set.add(strs[j]);
                    found = true;
                }
            }
            if(found){
                lst.add(strs[i]);
                set.add(strs[i]);
            }
            if(lst.isEmpty()){
                lst.add(strs[i]);
                set.add(strs[i]);
                ans.add(lst);

            }
            else {
                ans.add(lst);
            }

        }
        return ans;
    }
    // optimum solution for completing all the test case real use of now hashmap
    // keep practice keep thinking
    public static List<List<String>> groupAnagrams2(String[] strs){
        HashMap <String,List<String>> map = new HashMap <String,List<String>> ();
        for(int i = 0 ; i < strs.length ; i++){
            char [] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);
            // more fast solution and good
//            char[] ch = strs[i].toCharArray();
//            Arrays.sort(ch);
//            String key = new String(ch);


            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<List<String>>(map.values());
    }
    public static boolean isAnagrams(String s,String t){
            int [] a = new int[26];
            int [] b = new int[26];

        for(int i = 0; i <s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            a[temp]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int temp = t.charAt(i) - 'a';
            b[temp]++;
        }
        for (int i = 0; i < 26; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
