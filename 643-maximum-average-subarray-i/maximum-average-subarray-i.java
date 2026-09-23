class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        double maxavg = 0;
        double sum = 0;
        for(int i = 0; i<k; i++)
        {
            sum += nums[i];
        }
        avg = sum/k;
        maxavg = avg;
        for(int i = k; i<nums.length; i++)
        {
            sum += nums[i]-nums[i-k];
            avg = sum/k;
            if(avg>maxavg)
            {
                maxavg = avg;
            }
        }
        return maxavg;
    }
}