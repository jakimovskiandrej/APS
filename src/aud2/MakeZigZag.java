package aud2;

import java.util.Scanner;

public class MakeZigZag {
    public static void makeZigZag(DLL<Integer> list) {
        DLLNode<Integer> dvizi = list.getFirst();


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        for (int t = 1; t <= tests; t++) {
            System.out.println("Test case " + t);
            input.next();
            int n = input.nextInt();

            DLL<Integer> list = new DLL<>();

            for (int i = 0; i < n; i++) {
                list.insertLast(input.nextInt());
            }

            System.out.println(list);

            makeZigZag(list);

            System.out.println(list);

        }

        input.close();
    }
}
