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

