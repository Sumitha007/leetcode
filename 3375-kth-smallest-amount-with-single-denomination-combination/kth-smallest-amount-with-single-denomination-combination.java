import java.util.*;

class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        // Find a safe upper bound
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = count(mid, coins);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        long count = 0;
        int n = coins.length;

        // Check every subset
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;
                    lcm = lcm(lcm, coins[i]);

                    if (lcm > x) break;
                }
            }

            if (lcm > x) continue;

            if (bits % 2 == 1) {
                count += x / lcm;
            } else {
                count -= x / lcm;
            }
        }

        return count;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}