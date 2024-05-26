/* Count number of word in a string
*Note : Always ignore the spaces if more than 1 space given between two word

Sample Input : 1
------------------------
Kalyani Goverment Engineering College

Process
---------------------------
[Kalyani, Goverment, Engineering, College]

Output
---------------------------
Number of word : 4
*************************************
Sample Input : 2
------------------------
Kalyani Goverment  Engineering College

Process
---------------------------
[Kalyani, Goverment, , Engineering, College]

Output
---------------------------
Number of word : 4
*/

import java.util.Scanner;

public class Count_word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []s = sc.nextLine().split(" ");
        int c =0;
        for(int i = 0 ; i<s.length ; i++){
            if(s[i] ==""){c++;}
        }
        System.out.println(s.length - c);
    }
}
