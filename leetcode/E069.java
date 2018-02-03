//Binary Search
class Solution {
  public int mySqrt(int x) {
   if (x<1) return 0;

   int left = 1, right = x;

   while (true){
     int mid = left + (right - left)/2;
     if (mid > x/mid){
       right = mid - 1;
     }else {
       if ((mid + 1)> x/(mid+1))
        return mid;
        left = mid + 1;
     }
   }

  }
}



//
class Solution {
  public int mySqrt(int x) {
    if(x < 1) return 0;
    int i = 1;
    while(i*i<x) {
      
      i++;
      if(i*i>x){
        i--;
        break;
      }
    }
    return i;
  }
}