// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


//Dynamic Programming  18ms
class Solution {
  public int longestValidParentheses(String s) {
    int ans = 0;
    int[] dp = new int[s.length()];

    for(int i = 1; i<s.length(); i++) {
      if(s.charAt(i)==')') {
        if(s.charAt(i-1) == '(') {
          dp[i]=( i>=2 ? dp[i-2] : 0)+2;

        }
        else if(i - dp[i-1] >0 && s.charAt(i-dp[i-1]-1) == '(') {
          dp[i] = dp[i-1] +(( i- dp[i-1]) >= 2 ?  dp[i-dp[i-1]-2] : 0) +2;
        }
        ans = Math.max(ans,dp[i]);
      }
    }
    return ans;
  }
}

//Stack 26ms
class Solution {
  public int longestValidParentheses(String s) {
   int ans = 0;
   Stack<Integer> stack = new Stack<>();
   stack.push(-1);
   for(int i = 0; i<s.length(); i++) {
     if(s.charAt(i) == '(') {
       stack.push(i);
     }
     else{  // == ')'
       stack.pop();
       if(stack.empty()){
         stack.push(i);
       }
       else{
         ans = Math.max(ans, i-stack.peek());
       }
     }
   }
   return ans;
  }
}

//Without extra space 21ms
public class Solution {
  public int longestValidParentheses(String s) {
    int left = 0, right= 0, maxlength = 0;
    for(int i =0; i<s.length(); i++) {
      if(s.charAt(i) == '(') {
        left ++;
      } else {
        right ++;
      }
      if(left == right) {
        maxlength = Math.max(maxlength, 2*right);
      } else if (right > left){  // care  right > left
        left = right = 0;
      }
    }
    left = right = 0;
    for(int i = s.length()-1; i>=0; i--) {
      if(s.charAt(i) == '(') {
        left ++;
      } else {
        right ++;
      }
      if(left == right) {
        maxlength = Math.max(maxlength, 2*right);
      } else if (right < left){  // care right < left
        left = right = 0;
      }
    }
    return maxlength;
  }
}

//
class Solution {
  public int longestValidParentheses(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    if (len < 2)
      return 0;
    int[] counters = new int[len+1];
    int c = 0;
    counters[0] = -1;
    int max = 0;
    int i = 0;
    while(i < len) {
      if ('(' == chars[i]) {
        c = c + 1;
        counters[c] = i;
        i = i +1;
        continue;
            
      }
      if (c > 0) {
                c = c - 1;
                int m = i - counters[c];
        if(m > max)
                    max = m;
                i = i +1;
                continue;
      }
        counters[0] = i;
            i = i +1;
    }
    return max;
  }
}