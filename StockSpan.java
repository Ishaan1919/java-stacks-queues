//The stock span problem is a financial problem where we have a series of
// daily price quotes for a stock and we need to calculate the span of stock
// price for all days. The span arr[i] of the stocks price on a given day i
// is defined as the maximum number of consecutive days just before the given day,
// for which the price of the stock on the given day is less than or equal to its price
// on the current day.

// Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
// Output: [1, 1, 1, 2, 1, 4, 6]

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] result = getStockspan(arr);
        display(result);
    }

    public static void display(int[] arr){
        for(int i:arr){
            System.out.print(i + " ");
        }
    }

    public static int[] getStockspan(int[] arr){
        int size = arr.length;
        int[] res = new int[size];
        Stack st = new Stack(size);
        for(int i=0;i<size;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = i+1;
            }
            else{
                res[i] = i - st.peek();
            }
            st.push(i);
        }
        return res;
    }
}