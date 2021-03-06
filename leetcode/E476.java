import com.sun.xml.internal.fastinfoset.util.ValueArray;

/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 
*/
class Solution {
  public int findComplement(int num) {

    
    String str= "";
    while(num!=0)
    {
      if(num%2==0){
        str=1+str;
      }else{
        str=0+str;
      }
      num=num/2;
    }
    int ans_int=0;

    ans_int=Integer.parseInt(str,2);

    return ans_int;
  }
}
// 1 line answer
/*public class Solution {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
/*public class Solution {
    public int findComplement(int num) {
       return num ^((Integer.highestOneBit(num) << 1) - 1);
    }
}

*/

//100110, its complement is 011001, the sum is 111111. So we only need get the min number large or equal to num, then do substraction
/*
 public int findComplement(int num) 
    {
        int i = 0;
        int j = 0;
        
        while (i < num)
        {
            i += Math.pow(2, j); //(2^j)
            j++;
        }
        
        return i - num;
    }

*/