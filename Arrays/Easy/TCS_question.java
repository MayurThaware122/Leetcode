package Arrays.Easy;

import java.util.Arrays;

//Practice Problem: Sort Array Without Moving Prime Numbers
//Difficulty: Easy–Medium
//Topic: Arrays, Bubble Sort, Prime Numbers
//Problem Statement
//Given an integer array arr[],
// sort all the non-prime numbers in ascending order while keeping every prime number at its original index.
//A prime number must never change its position.
//Input:
//arr = [10, 7, 8, 3, 6, 4]
//Output:
//[4, 7, 6, 3, 8, 10]
public class TCS_question {
    public static void main(String[] args){
        int [] array = {10,7,8,3,6,4};
        sort(array);
        System.out.println(Arrays.toString(array));

    }
    public static void sort(int [] arr){
        for(int i =0; i < arr.length - 1;i++){
            if(isPrime(arr[i])){
                continue;
            }
            for(int j = i + 1; j < arr.length;j++){
                if(isPrime(arr[j])){
                    continue;
                }
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static boolean isPrime(int a) {
        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    return false;
                }
            }
            // more optimize way is off square root
            // for(int i = 0 ;  i <= math.sqrt(a);i++)
            // or like for(int i =0; i * i <= a;i++) squaring on the both the side basic math concept
            // ex a = 20
            //1 × 20
            //2 × 10    ← found 2
            //4 × 5
            //---------
            //5 × 4     ← repeating
            //10 × 2
            //20 × 1
            // √20 ≈ 4.47
            //So if a number has a factor other than 1 and itself, at least one of its factors must be ≤ √number.
        }
        return true;
    }
}
