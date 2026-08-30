class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = nums[0];
        int max = nums[0];

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int option1 = right + 1;

        int option2 = n - left;

        int option3 = (left + 1) + (n - right);

        return Math.min(option1, Math.min(option2, option3));
    }
}