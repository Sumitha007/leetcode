class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] prev = new int[26][n];

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = word1.charAt(i) - 'a';
            last[c] = i;

            for (int j = 0; j < 26; j++) {
                prev[j][i] = last[j];
            }
        }

        int[] exact = new int[m];
        int[] one = new int[m];

        Arrays.fill(exact, -1);
        Arrays.fill(one, -1);

        int c = word2.charAt(m - 1) - 'a';

        exact[m - 1] = prev[c][n - 1];

        one[m - 1] = n - 1;

        for (int j = m - 2; j >= 0; j--) {

            c = word2.charAt(j) - 'a';

            int limit1 = one[j + 1] - 1;

            int option1 = -1;

            if (limit1 >= 0) {
                option1 = prev[c][limit1];
            }

            int limit2 = exact[j + 1] - 1;

            int option2 = limit2;

            one[j] = Math.max(option1, option2);

            if (exact[j + 1] > 0) {
                exact[j] = prev[c][exact[j + 1] - 1];
            }
        }

        int[] ans = new int[m];

        int j = 0;
        int usedMismatch = 0;

        for (int i = 0; i < n && j < m; i++) {

            boolean mismatch = word1.charAt(i) != word2.charAt(j);

            if (mismatch && usedMismatch == 1) {
                continue;
            }

            boolean possible;

            if (j == m - 1) {
                possible = true;
            }
            else if (mismatch) {
                possible = exact[j + 1] > i;
            }
            else {
            
                possible = one[j + 1] > i;
            }

            if (possible) {
                ans[j] = i;
                j++;

                if (mismatch) {
                    usedMismatch++;
                }
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}