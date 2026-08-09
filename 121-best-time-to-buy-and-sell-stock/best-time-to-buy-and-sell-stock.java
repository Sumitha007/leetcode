class Solution {
    public int maxProfit(int[] arr) {

        int minprize = arr[0];
        int maxprofit = 0;
        for(int i = 1 ; i<arr.length; i++)
        {
            int profit = arr[i] - minprize;
            if(profit > maxprofit)
            {
                maxprofit = profit;
            }
            if(arr[i]<minprize)
            {
                minprize = arr[i];
            }
        }
        return maxprofit;
    }
}