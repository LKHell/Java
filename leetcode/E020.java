// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<>();
    
        for (char c : s.toCharArray() ) {
            switch (c){
                case '[' : stack.push(')'); break;
                
                case '{' : stack.push(); break;
                
                case '(' : d++; break;
                
                default  :  break;
            }
            if (stack.empty() || stack.pop() != c)
        
        }
        return stakc.isEmpty();
    }
}