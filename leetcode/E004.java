import com.sun.prism.Image;

// There are two sorted arrays nums1 and nums2 of size m and n respectively.

// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// Example 1:
// nums1 = [1, 3]
// nums2 = [2]

// The median is 2.0
// Example 2:
// nums1 = [1, 2]
// nums2 = [3, 4]

// The median is (2 + 3)/2 = 2.5

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;

      if (m > n) {  // ensure m <= n
        int [] temp = nums1; 
        nums1 = nums2;
        nums2 = temp;

        int temp_int = m;
        m = n;
        n = temp_int;
      }
      
      int i_min = 0, i_max = m, half_len = m + (n - m +1)/2;

      while(i_min <= i_max) {
        int i = i_min + (i_max - i_min) /2 ;
        int j = half_len - i;

        if(i < i_max && nums2[j-1] > nums1[i]) {
          i_min++;  //i too small
        }
        else if(i > i_min && nums1[i-1] > nums2[j]) {
          i_max--; // i too big
        }
        else {  // i is perfect
          int max_left = 0;
          if (i == 0) {
            max_left = nums2[j-1]; 
          }
          else if(j == 0) {
            max_left = nums1[i-1]; 
          }
          else { 
            max_left = Math.max( nums1[i-1], nums2[j-1]); 
          }

          if ((m+n) % 2 == 1) {
            return max_left; 
          }

          int min_right = 0;
          if(i == m) {
            min_right = nums2[j]; 
          }
          else if(j == n) {
            min_right = nums1[i];
          }
          else {
            min_right = Math.min( nums2[j], nums1[i]);
          }
          return (max_left + min_right )/ 2.0;
        }
      }
      return 0.0;
  }
}


//
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1 == null || nums1.length == 0){
          return findMedianSortedArrays(nums2);             
      }
      if (nums2 == null || nums2.length == 0){
          return findMedianSortedArrays(nums1);             
      }
      int l1 = nums1.length, l2 = nums2.length;
      int l = l1 + l2;
      int[] arr = new int[l];
      int p = l1 - 1, q = l2 - 1, i = l - 1;
      while ( p >= 0 && q >= 0){
          if (nums1[p] > nums2[q]){
              arr[i--] = nums1[p--];
          } else {
              arr[i--] = nums2[q--];
          }
      }
      while (p >= 0){
          arr[i--] = nums1[p--];
      } 
      while (q >= 0){
          arr[i--] = nums2[q--];
      }
      if (l % 2 != 0){
          return arr[l/2];
      } else {
          return (arr[ l/ 2 - 1] + arr[l/2])/2.0;
      }
   
  }
  public double findMedianSortedArrays(int[] arr ) {
      int l = arr.length;
      if (l % 2 != 0){
          return arr[l/2];
      } else {
          return (arr[ l/ 2 - 1] + arr[l/2])/2.0;
      }
  }
}