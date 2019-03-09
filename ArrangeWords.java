/*Code submitted by: Vikram Varun
Submitted for: rippling
*/

/*Problem statement

A sentence is composed of words and each word is composed of letters.
Assuming value of each letter equals its position in the alphabet and value of each word is the sum of the value of the letters, write a function to  order the words of the sentence in the ascending order. 
(a=1, b=2,... etc)
cat = 3 + 1 + 20 = 24

In case two words have the same value, then position them in the order of their occurrence.

Eg 1: 
a cat runs faster than the tortoise
converts to:
1 24  72   69       43    33  121
and on ordering the sentence becomes:
a cat the than faster runs tortoise

Eg 2.
the enemy is rooting for a dot ball 
converts to:
33  62        28  98      39 1 39  27
and on ordering the sentence becomes:
a ball is the for dot enemy rooting */

import java.io.*;
public class ArrangeWords {
    static int valueOfWord (String word){
        int value = 0;
        for (int i=0; i<word.length(); i++){
            int indexValue = (int) (word.charAt(i));
            /*ASCII value of ith character in word*/
            if (indexValue > 90){
                /*If the character is a small letter, its ASCII code takes values from 97-122 for a-z and thus reducing 96 gives required value*/
                indexValue -= 96;
            }
            else{
                /*If the character is a small letter, its ASCII code takes values from 65-90 for A-Z and thus reducing 64 gives required value*/
                indexValue -= 64;
            }
            value += indexValue;
        }
        return value;
    }
    public static void main(String args[] ) throws Exception {
        InputStreamReader in = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(in);
        String[] words = br.readLine().split(" ");
        /*words[] is the array that stores all words in give string at a separate index*/
        int[] values = new int[words.length];   
        /*words.length is length of array i.e. number of words in the given string*/
        for (int i=0; i<words.length-1; i++) {           
            for (int j=0; j<words.length-i-1; j++) {
                int value1 = valueOfWord(words[j]);
                int value2 = valueOfWord(words[j+1]);
                if (value2 < value1){
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }   
        for (int i=0; i<words.length; i++) {
            System.out.print(words[i]+" ");
        }
    }
}
