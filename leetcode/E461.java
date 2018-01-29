import java.util.*;


class Solution {
  public int hammingDistance(int x, int y) {

    int z = x^y;              
    int res = 0;
    while(z != 0) {            
      if (z%2 == 1) {
        res++;
      }
      z = z/2;
    }
    return res;


  }
}


public class E461{
  public static void main(String[] args) {
   

    int a = 1;
    int b = 4;

    Solution z=new Solution();
    int  c =z.hammingDistance(a,b);

    System.out.println("hammingDistance="+c);


    }

}

