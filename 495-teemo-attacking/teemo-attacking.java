
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            int gap = timeSeries[i] - timeSeries[i - 1];

            if (gap >= duration) {
                count += duration;
            } else {
                count += gap;
            }
        }

        if (timeSeries.length > 0) {
            count += duration;
        }

        return count;
    }
}
