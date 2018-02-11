// Given an integer, write a function to determine if it is a power of three.

// Follow up:
// Could you do it without using any loop / recursion?

class Solution {
  public boolean isPowerOfThree(int n) {
      if (n < 1) {
        return false;
      }
      while (n % 3 == 0 ) {
        n /= 3;
      }
      return n == 1 ;
  }
}


// Mathematics
public class Solution {
  public boolean isPowerOfThree(int n) {
      return (Math.log10(n) / Math.log10(3)) % 1 == 0;
  }
}
return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;

//Base Conversion
public class Solution {
  public boolean isPowerOfThree(int n) {
      return Integer.toString(n, 3).matches("^10*$");
  }
}

// Integer Limitations  the fastest
public class Solution {
  public boolean isPowerOfThree(int n) {
      return n > 0 && 1162261467 % n == 0; // Math.pow(3,19);
  }
}