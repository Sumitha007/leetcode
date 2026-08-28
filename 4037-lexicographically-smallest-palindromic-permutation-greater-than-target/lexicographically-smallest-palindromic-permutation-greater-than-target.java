class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int halfLength = s.length() / 2;

        char[] targetHalf = new char[halfLength];

        for (int i = 0; i < halfLength; i++) {
            targetHalf[i] = target.charAt(i);
        }

        int[] temp = halfCount.clone();
        boolean possible = true;

        for (char ch : targetHalf) {
            if (temp[ch - 'a'] == 0) {
                possible = false;
                break;
            }

            temp[ch - 'a']--;
        }

        if (possible) {

            String candidate = buildPalindrome(
                targetHalf,
                middle,
                s.length() % 2 == 1
            );

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int i = halfLength - 1; i >= 0; i--) {

            int[] remaining = halfCount.clone();
            boolean prefixPossible = true;

            for (int j = 0; j < i; j++) {

                int index = target.charAt(j) - 'a';

                if (remaining[index] == 0) {
                    prefixPossible = false;
                    break;
                }

                remaining[index]--;
            }

            if (!prefixPossible) {
                continue;
            }

            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    char[] answerHalf = new char[halfLength];

                    for (int j = 0; j < i; j++) {
                        answerHalf[j] = target.charAt(j);
                    }

                    answerHalf[i] = (char) ('a' + c);
                    remaining[c]--;

                    int pos = i + 1;

                    for (int k = 0; k < 26; k++) {
                        while (remaining[k] > 0) {
                            answerHalf[pos++] = (char) ('a' + k);
                            remaining[k]--;
                        }
                    }

                    return buildPalindrome(
                        answerHalf,
                        middle,
                        s.length() % 2 == 1
                    );
                }
            }
        }

        return "";
    }

    private String buildPalindrome(
            char[] half,
            char middle,
            boolean hasMiddle) {

        StringBuilder result = new StringBuilder();

        for (char ch : half) {
            result.append(ch);
        }

        if (hasMiddle) {
            result.append(middle);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            result.append(half[i]);
        }

        return result.toString();
    }
}