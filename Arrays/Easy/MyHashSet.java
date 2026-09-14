package Arrays.Easy;
//design a HashSet without using any built-in hash table libraries.
//Implement MyHashSet class:
//void add(key) Inserts the value key into the HashSet.
//bool contains(key) Returns whether the value key exists in the HashSet or not.
//void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
//Example 1:
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
public class MyHashSet {
        public static void main(String [] args){
                MyHashSet2 obj = new MyHashSet2();
                obj.add(1);
                System.out.println(obj.contains(1));
        }
        public boolean [] hash ;

        public MyHashSet() {
                hash = new boolean[1000001];
        }

        public void add(int key) {
                if(hash[key] == false){
                        hash[key] = true;
                }
        }

        public void remove(int key) {
                if(hash[key]){
                        hash[key] = false;
                }
        }

        public boolean contains(int key) {
                if(hash[key] == true){
                        return true;
                }
                else{
                        return false;
                }

        }
}
// O(N) solution like using int  [] array but like you can also solve using the upper solution
// boolean data type where intially value are the false using that and key constrains

class MyHashSet2{
        public int [] hash ;
        public static void main(String[] args) {

        }
        public MyHashSet2 (){
                hash = new int[1000001];
                for (int i = 0; i < hash.length; i++) {
                        hash[i] = -1;
                }
        }
        public void add(int key) {
                if(hash[key] == -1){
                        hash[key] = key;
                }
        }

        public void remove(int key) {
                if(hash[key] == key){
                        hash[key] = -1;
                }
        }

        public boolean contains(int key) {
                if(hash[key] == key){
                        return true;
                }
                else{
                        return false;
                }

        }
}
