// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.


class Solution {
  public String intToRoman(int num) {
      if(num > 3999) {
        return null;
      }
      String m[] = {"","M","MM","MMM"};
      // num / 1000
      String c[] = {"","C","CC","CCC","CD",
                    "D","DC","DCC","DCCC","CM"};
      // (num % 1000) / 100
      String x[] = {"","X","XX","XXX","XL",
                    "L","LX","LXX","LXXX","XC"};   
      // (num %100) / 10       
      String i[] = {"","I","II","III","IV",
                    "V","VI","VII","VIII","IX"};
      // (num % 10) 
      
      String res = new StringBuilder().append(m[num/1000]).append(c[(num % 1000) / 100]).append(x[(num %100) / 10]).append(i[(num % 10) ]).toString();
      
      return res;
  }
}

//
class Solution {
  private static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String intToRoman(int num) {
      StringBuilder res = new StringBuilder();
      for (int i  = 0 ; i<nums.length; i++) {
          while (num >= nums[i]) {
              res.append(strings[i]);
              num -= nums[i];
          }
      }

      return res.toString();
  }
}