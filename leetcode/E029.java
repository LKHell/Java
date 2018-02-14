class Solution {
  public int divide(int dividend, int divisor) {
      if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
        return Integer.MAX_VALUE;
      }

      int res = 0;
      int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

      long dvd = Math.abs((long)dividend);
      long dvs = Math.abs((long)divisor);
      
      while (dvs <= dvd) {
        long temp = dvs , mul = 1;
        while (dvd >= temp <<1) {
          temp<<=1;
          mul<<=1;
        }
        dvd -= temp;
        res += mul;
      }
      
      return sign == 1 ? res:-res;
  }
}

/* --------------------------------------- */

class Solution {
  public int divide(int dividend, int divisor) {
      // write your code here

      int sign = 1;
      if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
          sign = -1;
      }
      //Reduce the problem to positive long integer to make it easier.
    //Use long to avoid integer overflow cases.
      long TempDividend = Math.abs((long)dividend);
      long TempDivisor = Math.abs((long)divisor);
      
      if (TempDivisor == 0){
          return Integer.MAX_VALUE;
      }
      if (TempDividend == 0 || (TempDividend < TempDivisor)){
          return 0;
      }
      
      long tempResult = helper(TempDividend, TempDivisor);
      int result;
      
      if (tempResult > Integer.MAX_VALUE){
          result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }else {
          result  = (int)(sign * tempResult);
      }
      
      return result;
  }
  
  public long helper (long dividend, long divisor){
      if (dividend < divisor){
          return 0;
      }
      
      long sum = divisor;
      long multiple = 1;
      
      while ((sum + sum) <= dividend){
          sum += sum;
          multiple += multiple;
      }
      
      return multiple + helper(dividend - sum, divisor);
  }
}