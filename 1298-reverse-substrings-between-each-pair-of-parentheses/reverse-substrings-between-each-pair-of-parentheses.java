class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')') {

                String temp = "";

                while (stack.peek() != '(') {
                    temp += stack.pop();
                }

                stack.pop(); 

                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }

            } else {
                stack.push(s.charAt(i));
            }
        }

        String ans = "";

        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}