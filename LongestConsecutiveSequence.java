import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {3,4,3,25,5,6,3,23,4,5,1,8,9,6,4,2,7};
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,1);
        }
        int ans = 0;

        for(int key : map.keySet()){
            if(!map.containsKey(key-1)){
                int num = key+1;
                int temp = 1;
                while(map.containsKey(num)){
                    temp++;
                    num++;
                }
                ans = Math.max(ans,temp);
            }
        }

//        for(int key : map){
//            int left = key-1;
//            int right = key+1;
//            while (map.contains(left)) {
////                map.remove(left);
//                left--;
//            }
//
//            while (map.contains(right)) {
////                map.remove(right);
//                right++;
//            }
//
//            ans = Math.max(ans,right-left-1);
//            if(map.isEmpty()) break;
//        }
        System.out.println("The ans is " + ans);
    }
}