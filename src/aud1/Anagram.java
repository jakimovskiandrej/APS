package aud1;

import java.util.Scanner;

public class Anagram {
    public static void anagrams(SLL<Character> list) {
        SLLNode<Character> dvizi = list.getFirst();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        SLL<Character> list1 = new SLL<Character>();

        //todo: enter code here
        for(int i=0;i<N;i++) {
            list1.insertLast(scanner.next().charAt(0));
        }

        anagrams(list1);
        //todo: enter code here
    }
}
