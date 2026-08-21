class Solution {
    public String sortSentence(String s) {

        String[] words = s.split(" ");

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = 0; j < words.length - 1 - i; j++) {

                int num1 = words[j].charAt(words[j].length() - 1) - '0';
                int num2 = words[j + 1].charAt(words[j + 1].length() - 1) - '0';

                if (num1 > num2) {

                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word.substring(0, word.length() - 1));
            result.append(" ");
        }

        return result.toString().trim();
    }
}