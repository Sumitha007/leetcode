class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack = new Stack<>();
        int value = 0;
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                stack.push(ch);
            }
            if(ch == ')')
            {
                if(!stack.isEmpty() && stack.peek()=='(')
                {
                    stack.pop();
                }
                else
                {
                    value++;
                }
            }
            
        }
        return value+stack.size();
    }
}