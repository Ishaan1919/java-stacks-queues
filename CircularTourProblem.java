//Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//Output: 3

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int gas;
    int cost;
    Pair(int a, int b){
        this.gas = a;
        this.cost = b;
    }
}

public class CircularTourProblem {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int res = getCircularTourUsingQueue(gas,cost);
        if(res==-1){
            System.out.println("The person can not start from any gas station");
        }
        else{
            System.out.println("The person should start from gas station " + res + " to reach all the gas stations");
        }

        // The person should start from gas station 3 to reach all the gas stations

    }

    public static int getCircularTourUsingQueue(int[] gas, int[] cost){
        int n = gas.length;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            Pair p = new Pair(gas[i], cost[i]);
            q.offer(p);
        }

        for(int i=0;i<n;i++){
            int totalSum = 0;
            int flag = 0;
            if(q.peek().cost <= q.peek().gas){

                for(int j=0;j<n;j++){
                    Pair temp = q.poll();
                    totalSum += (temp.gas - temp.cost);
                    if(totalSum<0) flag = 1;
                    q.offer(temp);
                }
            }
            if(flag==0) ans = i;
            q.offer(q.poll());
        }

        return ans;
    }

    public static int getCircularTour(int[] gas, int[] cost){
        int n = gas.length;
        int totalSum = 0;
        int sum = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            totalSum += gas[i]-cost[i];
            sum = gas[i]-cost[i];
            if(sum<0){
                sum = 0;
                ans = i+1;
            }
        }
        if(totalSum<0) return -1;
        return ans;
    }
}