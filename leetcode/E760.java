/*
Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
*/
import java.util.*;

class Solution {
  public int[] anagramMappings(int[] A, int[] B) {
    Map<Integer,Integer> h_table= new HashMap<>();
   
    for (int i=0;i<B.length;i++)
      h_table.put(B[i],i);
    
    int [] c =new int[A.length]; 
    int t =0;
    // int [] d=new int[1];
    // d[0]=h_table.get(1);
    // System.out.println(d[0]);
    
    for(int x :A){
      System.out.println("before t = "+t+", x = "+x);
      c[t++]=h_table.get(x);
      System.out.println("after t ="+t+", x = "+x+"\n");
    }
    // for(int x =0;x<A.length;x++)
    // {
    //   c[t]=h_table.get(x);
    //   t++;
    // }
    
    return c;
  }
}




public class E760{
  public static void main(String[] args) {
   

    int [] a = {12,28,46,32,50};
    int [] b = {50,12,32,46,28};

    Solution z=new Solution();
    int [] c =z.anagramMappings(a,b);
    for (int i=0;i<c.length;i++)
    System.out.println("c["+i+"]="+c[i]);


    }

}

