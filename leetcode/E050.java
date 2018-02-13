class Solution {
  public double myPow(double x, int n) {
    long n_long = n;
    if (n < 0) {
        x = 1/x;
        n_long = - n_long;
      }
    return fastPow(x, n_long);     

  }
  private double fastPow(double x, long n) {
    if (n == 0) {
      return 1.0;
    }
    double half = fastPow(x, n/2);
    if (n % 2 == 0) {
      return half * half;
    }
    else {
      return half * half * x;
    }
  }
}

//
class Solution {
  public double myPow(double x, int n) {
      long N = n;
      if (N < 0) {
          x = 1 / x;
          N = -N;
      }
      double ans = 1;
      double current_product = x;
      for (long i = N; i > 0; i /= 2) {
          if ((i % 2) == 1) {
              ans = ans * current_product;
          }
          current_product = current_product * current_product;
      }
      return ans;
  }
};