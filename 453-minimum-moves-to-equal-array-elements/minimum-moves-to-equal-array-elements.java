class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i]<min)
            {
                min = nums[i];
            }
        }
        for(int i = 0; i<nums.length; i++)
        {
            count += nums[i]-min;
        }
        return count;
    }
}