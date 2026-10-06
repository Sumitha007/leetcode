class Solution {
    public int compareVersion(String version1, String version2) {
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");
        int max = Math.max(num1.length, num2.length);
        for(int i = 0; i<max; i++)
        {
            int value1 = 0;
            int value2 = 0;
            if(i<num1.length)
            {
                value1 = Integer.parseInt(num1[i]);
            }
            if(i<num2.length)
            {
                value2 = Integer.parseInt(num2[i]);
            }
            if(value1<value2)
            {
                return -1;
            }
            else if(value1>value2)
            {
                return 1;
            }
        }
        return 0;
        
        

    }
}