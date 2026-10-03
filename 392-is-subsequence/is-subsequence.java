class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int count = 0;
        if(s.length() == 0)
        {
            return true;
        }
        for(int i = 0; i<t.length(); i++)
        {
            if(j==s.length())
            {
                return true;
            }
            char ch1 = s.charAt(j);
            char ch2 = t.charAt(i);
            if(ch1 == ch2)
            {
                count++;
                j++;
            }
            if(count == s.length())
            {
                return true;
            }
        }
        return false;
    }
}