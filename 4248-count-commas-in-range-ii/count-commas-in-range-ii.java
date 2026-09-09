class Solution {
    public long countCommas(long n) {
        long totalcomma = 0;
        long threshold = 1000;
        while(n>= threshold)
        {
            totalcomma += (n-threshold)+1;
            threshold *= 1000;
        }
        return totalcomma;
        
    }
}