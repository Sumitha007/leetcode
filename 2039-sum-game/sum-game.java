class Solution {

    public boolean sumGame(String num) {

        int n = num.length();
        int mid = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQuestion = 0;
        int rightQuestion = 0;

        for(int i = 0; i < n; i++) {

            if(i < mid) {

                if(num.charAt(i) == '?') {
                    leftQuestion++;
                } else {
                    leftSum += num.charAt(i) - '0';
                }

            } else {

                if(num.charAt(i) == '?') {
                    rightQuestion++;
                } else {
                    rightSum += num.charAt(i) - '0';
                }
            }
        }

        if((leftQuestion + rightQuestion) % 2 != 0) {
            return true;
        }

        return (leftSum - rightSum) * 2 !=
               (rightQuestion - leftQuestion) * 9;
    }
}