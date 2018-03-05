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




class Solution {
  public double findMedianSortedArrays(int A[], int B[]) {
          if (A == null || B == null) {
              return 0;
          }
          
          int len = A.length + B.length;
          
          double ret = 0;
          // 偶数个元素
          if (len % 2 == 0) {
              ret = (findKth(A, B, 0, 0, len / 2) + findKth(A, B, 0, 0, len / 2 + 1)) / (double)2.0;
          } else {
              // 奇数个元素
              ret = findKth(A, B, 0, 0, len / 2 + 1);            
          }
          
          return ret;
      }
      
      // Find the Kth large number.
      public int findKth(int A[], int B[], int indexA, int indexB, int k) {
          int lenA = A.length;
          int lenB = B.length;
          
          //if A = [], indexA=0; so return B[indexB + k - 1]; 
          if (indexA >= lenA) {
              return B[indexB + k - 1];
          } else if (indexB >= lenB) {
              return A[indexA + k - 1];
          }
          
          // Base Case, pay attention. 在这里必须要退出。因为k = 1的时候，不可能再分了。
          if (k == 1) {
              return Math.min(A[indexA], B[indexB]);
          }
          
          // -1是因为索引本身是从0开始的。而前k大元素含有k个元素。
          int mid = k / 2 - 1; // k = 4. mid = 1. so indexA, indexA + 1, indexB, indexB + 1, compare A[indexA+1] and B[indexB+1]
          
          // 注意，越界条件是 >= lenA. 怎么老是犯这个错误。。
        // 如果A不够 k/2 个，把B的前k/2删除，所以相当于把keyA弄到最大
          int keyA = (indexA + mid >= lenA ? Integer.MAX_VALUE: A[indexA + mid]);
          int keyB = (indexB + mid >= lenB ? Integer.MAX_VALUE: B[indexB + mid]);
          
          // 因为丢弃了k / 2个元素
          int kNew = k - k / 2;
          
          if (keyA < keyB) {
              return findKth(A, B, indexA + k / 2, indexB, kNew);
          } else {
              return findKth(A, B, indexA, indexB + k / 2, kNew);
          }
      }
  }