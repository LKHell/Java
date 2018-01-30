/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.

char 0 = int 48
so char 1 = int 49

char - '0'=int

*/

class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
 
    List<Integer> list_ans =new ArrayList();
    for (int num=left;num<=right;num++)
    {
      if(checkDN(num)) list_ans.add(num);
    }
    return list_ans;
  }

  public boolean checkDN(int num)
  {
    for (char c : String.valueOf(num).toCharArray())
    {
      if (c == '0'||(num%(c-'0')>0))
      return false;
    }
    return true;
  }

}