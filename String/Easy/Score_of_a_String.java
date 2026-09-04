package String.Easy;
//3110 You are given a string s. The score
// of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
public class Score_of_a_String {
    public static void main(String [] args){
        String s = "zaz";
        System.out.println(scoreOfString(s));
    }
    public static int scoreOfString(String s) {
        int ans = 0;
        for(int i = 0 ; i < s.length();i++){
            if(i != s.length() - 1) {
                int temp1 = s.charAt(i);
                int temp2 = s.charAt(i + 1);
                int num = temp2 - temp1;
                if(num < 0) num = - num;
                ans += num;
            }
        }
        return ans;
    }
}
