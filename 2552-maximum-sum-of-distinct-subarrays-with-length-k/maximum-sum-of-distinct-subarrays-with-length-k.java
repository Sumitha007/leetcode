class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0; 
        long max = 0;
        for(int i = 0; i<k; i++)
        {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==k)
        {
            max = sum;
        }
        for(int i = k; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k], map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0)
            {
                map.remove(nums[i-k]);
            }
            sum += nums[i]-nums[i-k];
            if(map.size()==k)
            {
                max = Math.max(sum, max);
            }
        }
        return max;
        
        
    }
}