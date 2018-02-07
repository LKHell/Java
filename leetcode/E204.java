// Description:

// Count the number of prime numbers less than a non-negative number, n.

class Solution {
  public int countPrimes(int n) {
      boolean [] notPrime = new boolean[n];
      int count = 0;
      for (int i = 2; i<n; i++) {
        if(notPrime[i] == false) {
          count++;
          for(int j = 2; i*j<n; j++) {
            notPrime[i*j] = true;
          }
        }
      }
      return count;
  }
}

//
class Solution{
  public int countPrimes(int n) {
    if(n <=1 ) return 0;
    
    boolean[] notPrime = new boolean[n];        
    notPrime[0] = true; 
    notPrime[1] = true; 

    for(int i = 2; i < Math.sqrt(n); i++){
        if(!notPrime[i]){
            for(int j = 2; j*i < n; j++){
                notPrime[i*j] = true; 
            }
        }
    }
    
    int count = 0; 
    for(int i = 2; i< notPrime.length; i++){
        if(!notPrime[i]) count++;
    }
    return count; 
  }
}


class Solution {
  public int countPrimes(int n) {
      if (n < 3) {
        return 0;
      }
      boolean [] notPrime = new boolean[n];

      int count = n/2;
      for(int i = 3; i*i<n ; i+=2) {
        if (notPrime[i]) {
          continue;
        }
        for (int j = i*i; j<n; j+=2*i) {
          if (!notPrime[j]){
            count --;
            notPrime[j]=true;
          }
        }
      }
      return count;
  }
}