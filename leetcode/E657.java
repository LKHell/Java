// Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

// The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

// Example 1:
// Input: "UD"
// Output: true
// Example 2:
// Input: "LL"
// Output: false

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

