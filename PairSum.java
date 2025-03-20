//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]


import java.util.ArrayList;
import java.util.HashMap;

public class PairSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15,3,5,4,5,4,7,3};
        int target = 9;

//        ArrayList<Pair> pairSum = getPairSumElements(nums,target);
        ArrayList<Pair> pairSum = getPairSumIndexes(nums,target);
        ZeroSumSubarrays.display(pairSum);
    }

    public static ArrayList<Pair> getPairSumIndexes(int[] arr, int target){
        ArrayList<Pair> ans = new ArrayList<>();

        int sum = 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(target-arr[i])){
                    ans.add(new Pair(i,map.get(target-arr[i])));
            }
            map.put(arr[i],i);
        }

        return ans;
    }

    public static ArrayList<Pair> getPairSumElements(int[] arr, int target){
        ArrayList<Pair> ans = new ArrayList<>();

        int sum = 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int num = 0;
            if(map.containsKey(target-arr[i])){
                if(map.get(target-arr[i])==1 && map.get(arr[i])==null)
                    ans.add(new Pair(arr[i],target-arr[i]));
            }
            map.put(arr[i],map.getOrDefault(arr[i]+1,1));
        }

        return ans;
    }
}