class Solution {
    public int missingInteger(int[] nums) {
        int end = 1;
        int sum = nums[0];
        while(end<nums.length && nums[end] == nums[end-1]+1)
        {
            sum += nums[end];
            end++;
        }
        while(true)
        {
            boolean found = false;
            for(int i = 0; i<nums.length; i++)
            {
                if(nums[i] == sum)
                {
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                return sum;
            }
            sum++;
        }

    }
}