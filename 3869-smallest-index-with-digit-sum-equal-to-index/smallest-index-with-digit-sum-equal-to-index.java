class Solution {
    public int smallestIndex(int[] nums) {
        
        for(int i = 0; i<nums.length; i++)
        {
            int sum = 0;
            int digit = 0;
            while(nums[i]>0)
            {
                digit = nums[i]%10;
                nums[i] /= 10;
                sum += digit;
            }
            if(sum==i)
            {
                return i;
            }
        }
        return -1;
    }
}