package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KolokZadaca {
    public static void putWordsTogether(SLL<String> list) {
        SLLNode<String> dvizi = list.getFirst();
        SLLNode<String> prev = null;

        while (dvizi!=null) {
            StringBuilder word = new StringBuilder();
            while (dvizi!=null && !dvizi.element.equals(",")) {
                word.append(dvizi.element);
                dvizi = dvizi.succ;
            }

            if(!word.isEmpty()) {
                if(prev == null) {
                    list.getFirst().element = word.toString();
                    prev = list.getFirst();
                } else {
                    list.insertAfter(word.toString(), prev);
                    prev = prev.succ;
                }
            }
            if(dvizi!=null) {
                dvizi = dvizi.succ;
            }

            if(prev!=null) {
                prev.succ = null;
            }
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        SLL<String> list = new SLL<>();
        for(int i=0;i<s.length();i++){
            if(!Character.isWhitespace(s.charAt(i))){
                list.insertLast(String.valueOf(s.charAt(i)));
            }
        }
        putWordsTogether(list);
    }
}
