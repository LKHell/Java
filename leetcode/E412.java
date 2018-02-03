import java.awt.List;

// Write a program that outputs the string representation of numbers from 1 to n.

// But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

// Example:

// n = 15,

// Return:
// [
//     "1",
//     "2",
//     "Fizz",
//     "4",
//     "Buzz",
//     "Fizz",
//     "7",
//     "8",
//     "Fizz",
//     "Buzz",
//     "11",
//     "Fizz",
//     "13",
//     "14",
//     "FizzBuzz"
// ]

class Solution {
  public List<String> fizzBuzz(int n) {
    List<String> ans_list = new ArrayList<String>();  
    for (int i = 1; i<=n; i++) {
      
      if (i%3 == 0 || i%5 == 0){
        if (i%3 == 0 && i%5 == 0){
          ans_list.add("FizzBuzz");
        }else if(i%3 == 0){
          ans_list.add("Fizz");
        }else {
          ans_list.add("Buzz");
        }
      }else {
        ans_list.add(String.valueOf(i));
      }   
    }
    return ans_list;
  }
}

// not using %
public class Solution {
  public List<String> fizzBuzz(int n) {
      List<String> ret = new ArrayList<String>(n);
      for(int i=1,fizz=0,buzz=0;i<=n ;i++){
          fizz++;
          buzz++;
          if(fizz==3 && buzz==5){
              ret.add("FizzBuzz");
              fizz=0;
              buzz=0;
          }else if(fizz==3){
              ret.add("Fizz");
              fizz=0;
          }else if(buzz==5){
              ret.add("Buzz");
              buzz=0;
          }else{
              ret.add(String.valueOf(i));
          }
      } 
      return ret;
  }
}