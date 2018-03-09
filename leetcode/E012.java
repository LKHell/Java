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