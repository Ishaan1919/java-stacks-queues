import java.util.ArrayList;
import java.util.HashMap;

class Pair{
    int first;
    int second;
    Pair(int a, int b){
        this.first = a;
        this.second = b;
    }
}

public class ZeroSumSubarrays {
    public static void main(String[] args) {

        int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        ArrayList<Pair> res = getZeroSumSubarrays(arr);
        display(res);
    }

    public static void display(ArrayList<Pair> res){
        for(Pair i:res){
            System.out.println(i.first + " " + i.second);
        }
    }

    public static ArrayList<Pair> getZeroSumSubarrays(int[] arr){
        int n = arr.length;
        int sum = 0;
        ArrayList<Pair> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum==0){
                ans.add(new Pair(0,i));
            }
            ArrayList<Integer> temp = new ArrayList<>();
            if(map.containsKey(sum)){
                temp = map.get(sum);
                for(Integer a:temp){
                    ans.add(new Pair(a+1,i));
                }
            }
            temp.add(i);
            map.put(sum,temp);
        }
        return ans;
    }

}