
import java.util.*;

class Solution  {
    // public int numJewelsInStones(String J, String S)
    public int numJewelsInStones(String J, String S) {
      int ans_int = 0;
      for (char s: S.toCharArray()) // For each stone...
          for (char j: J.toCharArray()) // For each jewel...
              if (j == s) {  // If the stone is a jewel...
                  ans_int++;
                  break; // Stop searching whether this stone 's' is a jewel
              }

     // System.out.println(ans_int);
       return ans_int;
  }
}

public class E771{
  public static void main(String[] args) {
   
    Scanner intype=new Scanner(System.in);

    System.out.println("set stone");
    String S=intype.nextLine();
    System.out.println("set jewel");
    String J=intype.nextLine();
    intype.close();

     Solution b=new Solution();

    int ans_main =b.numJewelsInStones(J,S);
    
    System.out.println(ans_main);
      // int aa = numJewelsInStones(J,S);
      //b.numJewelsInStones(J,S);

    }

}

