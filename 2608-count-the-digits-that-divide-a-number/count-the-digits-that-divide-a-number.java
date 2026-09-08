class Solution {
    public int countDigits(int num) {
        int value = num;
        int count = 0;
        while(value>0)
        {
            int digit = value%10;
            if(num%digit == 0)
            {
                count++;
            }
            value = value/10;
        }
        return count;
    }
}