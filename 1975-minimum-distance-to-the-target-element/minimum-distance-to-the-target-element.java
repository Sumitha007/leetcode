class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int result = 100000;
        int distance = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                distance = Math.abs(i-start);
                result = Math.min(result, distance);
                
            }
        }
        return result;
    }
}