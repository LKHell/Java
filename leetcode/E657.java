
import java.util.*;

class Solution {
  public boolean judgeCircle(String moves) {
    int x=0,y=0 ;
    for (char z: moves.toCharArray())
      {
        if (z=='U') x++;
        if (z=='D') x--;
        if (z=='L') y++;
        if (z=='R') y--;
      }

    if (x==0 && y==0)return true;
    else return false;
  }
}
public class E657{
  public static void main(String[] args) {
   
    Scanner intype=new Scanner(System.in);

    System.out.println("set UDLR:");
    String S=intype.nextLine();

    intype.close();

    Solution b=new Solution();

    boolean ans_main =b.judgeCircle(S);
    
    System.out.println(ans_main);


    }

}

