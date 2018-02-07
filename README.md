# Java Content


## leetcode. 
* 001. Two Sum 
* 002. Add Two Numbers
* 003. Longest Substring Without Repeating Characters
* 007. Reverse Integer
* 009. Palindrome Number
* 013. Roman to Integer
* 014. Longest Common Prefix
* 020. Valid Parentheses
* 021. Merge Two Sorted Lists
* 026. Remove Duplicates from Sorted Array
* 027. Remove Element
* 035. Serach Insert Position
* 038. Count and Say
* 053. Maximum Subarray
* 066. Plus One
* 069. Sqrt(x)
* 070. Climbing Stairs
* 088. Merge Sorted Array 
*
* 101. Symmetric Tree
* 104. Maximum Depth of Binary Tree
* 108. Convert Sorted Array to Binary Search Tree
* 118. Pascal's Triangle 
* 121. Best Time to Buy and Sell Stock
* 122. Best Time to Buy and Sell Stock II
* 125. Valid Palindrome
* 141. Linked List Cycle
* 155. Min Stack
* 160. Intersection of Two Linked Lists
* 169. Majority Element
* 171. Excel Sheet Column Number
* 172. Factorial Trailing Zeroes
* 189. Rotate Array
* 190. Reverse Bits
* 191. Number of 1 Bits
* 198. House Robber
*
* 344. Reverse String
*
* 412. Fizz Buzz
* 461. HammingDistance
* 476. Number Complement
*
* 500. Keyboard Row
* 557. Reverse Words in a String III
* 561. Array Partition I
*
* 617. Merge Two Binary Trees
* 657. Judge Route Circle
* 669. Trim a Binary Search Tree
* 682. Baseball Game
*
* 728. Self Dividing Numbers
* 760. Find Anagram Mappings
* 766. Toeplitz Matrix 
* 771. Jewels and Stones

#
#### MyJava
* File_Buffer 
* File_Delete  
* File_file
* File_write
* File_in_dir  
* Menu
* MathSqrt   --Math.pow(n,1.0/2) -- 
* E13_5x
* GetPassword  --JTextField -> setTitle，JPasswordField ->JTextField

## About '& | ^ ~ << >>'

* \& 
   
  only 1 & 1 = 1;

*  \|  

  only 0 | 0 = 0;

* \^  XOR

  0 ^ 1 =1 and  1 ^ 0 = 1; 

* \~
  ȡ��

## char and String
```java
// String to char
1. String.charAt(index) //return char
2. String.tocharArray() //return char[]
 
//char to String
1. String s = String.valueOf('c'); //效率最高的方法

2. String s = String.valueOf(new char[]{'c'}); //将一个char数组转换成String

3. String s = Character.toString('c');
// Character.toString(char)方法实际上直接返回String.valueOf(char)

4. String s = new Character('c').toString();

5. String s = "" + 'c';
// 虽然这个方法很简单，但这是效率最低的方法
// Java中的String Object的值实际上是不可变的，是一个final的变量�?
// 所以我们每次对String做出任何改变，都是初始化了一个全新的String Object并将原来的变量指向了这个新String�??
// 而Java对使�??+运算符处理String相加进行了方法重载�?
// 字符串直接相加连接实际上调用了如下方法：
// new StringBuilder().append("").append('c').toString();


6. String s = new String(new char[]{'c'});
```

## int and String
```java
// int to String
1.num + ""
2.String.valueOf(num)   // can be null
3.Integer.toString(num) // can't be null
// String to int
1.Integer.parseInt(str)
2.Integer.valueOf(str).intValue() //String => Integer => int
```

#### Midterm_test:  
 *  三个算法，算�?? 三角，以及圆和三角组成的阴影面积，用接口I定义方法A，实现算法，同时抛出自定义异常类，循环判�??

#### Lab2: 
 * 用继承类实现最大公约数以及最小公倍数

#### Lab3: 
 * 用接口回调，异常类实现最大公约数以及最小公倍数  

#### Lab4:
 * 读取txt内容   

#### Example: JAVA大学实用教程（第三版�?? 
#####  Chapter 9
  * 1  File 判断文件类型，显示文件名和大小，删除第一个文�??
  * 3  FileInputStream, FileOutputStream  将内容写入txt，读�??
  * 4  FileReader, FileWriter 
  * 5  BufferedReader, BufferedWriter  
    

####
#### Chapter 10
  * 01  JFrame窗口
  * 02  JmenuBar JMenu JMenuItem 菜单窗口
  * 06  BoxLayout 3个平行box createVertucalBox,createHorizontalBox
  * 08  JLabel JTextField 传递信息回终端 ActionListener in 2 class
  * 09  JPasswordField 密码框返回给文本框，文本框返回给标题 ActionListener in same class
  * 10  ActionListener in function
  * 11
  * 15
  * 17 
  * 23
  * 24
  * 25
  * 29
  * 33
  * 34
  * 35

