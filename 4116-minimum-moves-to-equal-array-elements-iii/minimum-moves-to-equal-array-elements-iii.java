class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i<nums.length; i++)
        {
            max = Math.max(nums[i], max);
        }
        for(int i = 0; i<nums.length; i++)
        {
            ans += max - nums[i];
        }
        return ans;

    }
}