class Solution {
    public int missingMultiple(int[] nums, int k) {
        int [] multiple = new int[nums.length];
        int mul = 1;
        for(int i = 0; i<nums.length; i++)
        {
            multiple[i] = k*mul;
            for(int j = 0; j<nums.length; j++)
            {
                if(multiple[i]==nums[j])
                {
                    break;
                }
                if(j == nums.length-1)
                {
                    return multiple[i];
                }
            }
            mul++;
        }
        return k*mul;

    }
}