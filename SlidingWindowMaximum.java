//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = getSlidingWindowMaximum(arr,k);
        display(res);
    }

    public static void display(int[] arr){
        for(int i:arr){
            System.out.println(i + " ");
        }
    }

    public static int[] getSlidingWindowMaximum(int[] arr, int k){
        int n = arr.length;
        int[] res = new int[n-k+1];
        int pointer = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peek() < i-k+1){
                dq.poll();
            }

            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                res[pointer++] = arr[dq.peek()];
            }
        }
        return res;
    }

}