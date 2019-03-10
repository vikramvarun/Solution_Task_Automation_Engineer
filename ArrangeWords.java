/*Code submitted by: Vikram Varun
Submitted for: Rippling
Submitted on: 3rd March 2019*/

import java.io.*;
public class ArrangeWords {
    static int valueOfWord (String word){
        int value = 0;
        for (int i=0; i<word.length(); i++){
            value += ((int) (word.charAt(i))) % 32;
            /*ASCII value of ith character in word
            If the character is a small letter, its ASCII code takes values from 97-122 for a-z. If the character is a small letter, its ASCII code takes values from 65-90 for A-ZBoth 97 and 65 can be written as 32*x+1 (x= 3 and 2 respectively). Similarly b/B - z/Z can be written as (32*x + i). It is athenadded to existing value of the word to get cumulative value */
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
