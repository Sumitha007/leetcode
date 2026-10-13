
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long score = 0;

        for (int i = 0; i < n; i++) {
            if (i < (n + 1) / 2) {
                score += arr[n - 1 - i];
            } else {
                score -= arr[i - (n + 1) / 2];
            }
        }

        return score;
    }
}