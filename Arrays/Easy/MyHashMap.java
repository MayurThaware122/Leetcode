package Arrays.Easy;
//Design a HashMap without using any built-in hash table libraries.
//Implement the MyHashMap class:
//MyHashMap() initializes the object with an empty map.
//void put(int key, int value) inserts a (key, value) pair into the HashMap.
// If the key already exists in the map, update the corresponding value.
//int get(int key) returns the value to which the specified key is mapped,
// or -1 if this map contains no mapping for the key.
//void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
//Example 1:
//Input
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//Output
//[null, null, null, 1, -1, null, 1, null, -1]
public class MyHashMap {
    //so one approch is to  solve with like the array and initiallize all to -1 wich we did in hashsset also
    //but time complexity is like more not less as we also exeperience in the MyHashSet problem
    // now then lets solve it  with less time complexity
    // Approach: Direct Addressing
// Use key as the array index and store value at that index.
// Since Java initializes int[] with 0 and 0 is a valid value,
// store value + 1. Here, 0 represents that the key does not exist.
// put, get, remove: O(1)
// Space: O(10^6)
// Note: Creating the array still requires O(10^6) initialization.
    public int [] hm ;
    public static void main(String []args){

    }
    public MyHashMap() {
        hm = new int [10000001];
    }

    public void put(int key, int value) {
        hm[key] = value + 1;
    }

    public int get(int key) {
        if(hm[key]== 0)return -1;
        return hm[key] - 1;
    }

    public void remove(int key) {
        hm[key] = 0;
    }
}
