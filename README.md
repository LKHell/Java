# Java Content


## leetcode 
- 001 Two Sum //Rw_1
- 002 Add Two Numbers //Rw_1
- 003 Longest Substring Without Repeating Characters // Rw_1
- 004 Median of Two Sorted Arrays // Rw_1
- 005 Longest Palindromic Substring //Rw_1
- 007 Reverse Integer
- 008 String to Integer (atoi)
- 009 Palindrome Number
- 010 Regular Expression Matching
- 011 Container With Most Water
- 013 Roman to Integer
- 014 Longest Common Prefix
- 015 3Sum
- 017 Letter Combinations of a Phone Number
- 019 Remove Nth Node From End of List
- 020 Valid Parentheses
- 021 Merge Two Sorted Lists
- 022 Generate Parentheses
- 023 Merge k Sorted Lists
- 026 Remove Duplicates from Sorted Array
- 027 Remove Element
- 029 Divide Two Integers
- 031 Next Permutation
- 032 Longest Valid Parentheses
- 033 Search in Rotated Sorted Array
- 034.Search for a Range
- 035 Serach Insert Position
- 036 Valid Sudoku
- 038 Count and Say
- 039 Combination Sum
- 041 First Missing Positive
- 042 Trapping Rain Water
- 046 Permutations
- 048 Rotate Image    
- 049 Group Anagrams
- 050 Pow(x, n)
- 053 Maximum Subarray
- 054 Spiral Matrix
- 055 Jump Game
- 056 Merge Intervals
- 062 Unique Paths
- 066 Plus One
- 069 Sqrt(x)
- 070 Climbing Stairs
- 073 Set Matrix Zeroes
- 075 Sort Colors
- 076 Minimum Window Substring
- 078 Subsets
- 079 Word Search
- 084 Largest Rectangle in Histogram
- 088 Merge Sorted Array
- 091 Decode Ways
- 094 Binary Tree Inorder Traversal
- 098 Validate Binary Search Tree 
*
- 101 Symmetric Tree
- 102 Binary Tree Level Order Traversal
- 103 Binary Tree Zigzag Level Order Traversal
- 104 Maximum Depth of Binary Tree
- 105 Construct Binary Tree from Preorder and Inorder Traversal
- 108 Convert Sorted Array to Binary Search Tree

- 116 Populating Next Right Pointers in Each Node
- 118 Pascal's Triangle 
- 121 Best Time to Buy and Sell Stock
- 122 Best Time to Buy and Sell Stock II
- 124 Binary Tree Maximum Path Sum
- 125 Valid Palindrome
- 127 Word Ladder   // NF
- 130 Surrounded Regions
- 131 Palindrome Partitioning
- 134 Gas Station
- 138 Copy List with Random Pointer // NF
- 139 Word Break
- 141 Linked List Cycle
- 148 Sort List
- 155 Min Stack
- 160 Intersection of Two Linked Lists
- 169 Majority Element
- 171 Excel Sheet Column Number
- 172 Factorial Trailing Zeroes
- 189 Rotate Array
- 190 Reverse Bits
- 191 Number of 1 Bits
- 198 House Robber
*
- 202 Happy Number
- 204 Count Primes
- 206 Reverse Linked List
- 207 Course Schedule
- 217 Contains Duplicate
- 226 Invert Binary Tree
- 234 Palindrome Linked List
- 237 Delete Node in a Linked List
- 242 Valid Anagram
- 268 Missing Number
- 283 Move Zeroes
*
- 326 Power of Three
- 338 Counting Bits
- 344 Reverse String
- 350 Intersection of Two Arrays II
- 371 Sum of Two Integers
- 387 First Unique Character in a String
*
- 412 Fizz Buzz
- 461 HammingDistance
- 476 Number Complement
*
- 500 Keyboard Row
- 557 Reverse Words in a String III
- 561 Array Partition I
*
- 617 Merge Two Binary Trees
- 657 Judge Route Circle
- 669 Trim a Binary Search Tree
- 682 Baseball Game
*
- 728 Self Dividing Numbers
- 760 Find Anagram Mappings
- 766 Toeplitz Matrix 
- 771 Jewels and Stones

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
  取反

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
// Java中的String Object的值实际上是不可变的，是一个final的变量?
// 所以我们每次对String做出任何改变，都是初始化了一个全新的String Object并将原来的变量指向了这个新String??
// 而Java对使+运算符处理String相加进行了方法重载
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
## Integer and int
* 1、Integer是int的包装类，
int则是java的一种基本数据类型 
* 2、Integer变量必须实例化后才能使用，而int变量不需要 
* 3、Integer实际是对象的引用，当new一个Integer时，实际上是生成一个指针指向此对象；而int则是直接存储数据值 
* 4、Integer的默认值是null，int的默认值是0

```java
1.
Integer i = new Integer(100);
Integer j = new Integer(100);
System.out.print(i == j); //false

2.
Integer i = new Integer(100);
int j = 100；
System.out.print(i == j); //true

3.
Integer i = new Integer(100);
Integer j = 100;
System.out.print(i == j); //false

4.
Integer i = 100;
Integer j = 100;
System.out.print(i == j); //true
Integer i = 128;
Integer j = 128;
System.out.print(i == j); //false

```
### Queue
* add        增加一个元索                     如果队列已满，则抛出一个 IIIegaISlabEepeplian异常
* remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
* element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
* offer     添加一个元素并返回true       如果队列已满，则返回false
* poll      移除并返问队列头部的元素    如果队列为空，则返回null
* peek      返回队列头部的元素          如果队列为空，则返回null
* put       添加一个元素               如果队列满，则阻塞
* take      移除并返回队列头部的元素     如果队列为空，则阻塞


#### Midterm_test:  
 *  三个算法，算法 三角，以及圆和三角组成的阴影面积，用接口I定义方法A，实现算法，同时抛出自定义异常类，循环判断

#### Lab2: 
 * 用继承类实现最大公约数以及最小公倍数

#### Lab3: 
 * 用接口回调，异常类实现最大公约数以及最小公倍数  

#### Lab4:
 * 读取txt内容   

#### Example: JAVA大学实用教程（第三版）
#####  Chapter 9
 * 1  File 判断文件类型，显示文件名和大小，删除第一个文件
 * 3  FileInputStream, FileOutputStream  将内容写入txt，读取
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

