class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int matched = 0;

        while (matched < n &&
               freq[target.charAt(matched) - 'a'] > 0) {

            freq[target.charAt(matched) - 'a']--;
            matched++;
        }

        for (int i = matched; i >= 0; i--) {

            if (i < n) {

                for (int c = target.charAt(i) - 'a' + 1;
                     c < 26;
                     c++) {

                    if (freq[c] > 0) {

                        StringBuilder ans = new StringBuilder();

                        ans.append(target.substring(0, i));

                        ans.append((char) ('a' + c));
                        freq[c]--;

                        for (int j = 0; j < 26; j++) {
                            while (freq[j] > 0) {
                                ans.append((char) ('a' + j));
                                freq[j]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }

            if (i > 0) {
                freq[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}