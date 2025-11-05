package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class MostFrequentSubstring {
    public static void main (String[] args) throws IOException {
        CBHT<String,Integer> tabela = new CBHT<String,Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();

        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<=word.length();j++){
                String substring = word.substring(i,j);
                SLLNode<MapEntry<String,Integer>> node = tabela.search(substring);
                if(node == null) {
                    tabela.insert(substring,1);
                } else {
                    tabela.insert(substring,node.element.value+1);
                }
            }
        }

        String maxWord = "";
        int maxFreq = 0;
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<=word.length();j++){
                String substring = word.substring(i,j);
                SLLNode<MapEntry<String,Integer>> node = tabela.search(substring);
                if(node != null) {
                    int freq = node.element.value;
                    if(freq > maxFreq || freq == maxFreq && substring.length() > maxWord.length() ||
                            (freq == maxFreq && substring.length() == maxWord.length() && substring.compareTo(maxWord) < 0)
                    ) {
                        maxWord = substring;
                        maxFreq = freq;
                    }
                }
            }
        }
        System.out.println(maxWord);
    }
}
