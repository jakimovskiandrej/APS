package aud1;

import java.util.Scanner;

public class Zadaca2 {

    public static void deleteLString(SLL<String> list, int L) {
        SLLNode<String> dvizi = list.getFirst();
        while (dvizi != null) {
            if(dvizi.element.length() < L) {
                list.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        SLL<String> list = new SLL<>();
        for (int i = 0; i < N; i++) {
            String element = scanner.nextLine();
            list.insertLast(element);
        }
        int L = Integer.parseInt(scanner.nextLine());
        System.out.println(list);
        deleteLString(list, L);
        System.out.println(list);
        scanner.close();
    }
}
