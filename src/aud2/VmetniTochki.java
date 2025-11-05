package aud2;

import java.util.Scanner;

public class VmetniTochki {

    public static void vmetniTochki(DLL<String> list) {
        DLLNode<String> dvizi = list.getFirst();
        if(dvizi != null) {
            dvizi = dvizi.succ;
        }
        while (dvizi != null) {
            if(Character.isUpperCase(dvizi.element.charAt(0))) {
                DLLNode<String> dot = new DLLNode<>(".",dvizi.pred,dvizi);
                dvizi.pred.succ = dot;
                dvizi.pred = dot;
                dvizi = dvizi.succ;
            } else {
                dvizi = dvizi.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input
        int n = scanner.nextInt(); // Number of nodes
        scanner.nextLine(); // Clear newline
        String[] inputs = scanner.nextLine().split(" ");

        // Create the doubly linked list
        DLL<String> list = new DLL<String>();
        for (String input : inputs) {
            list.insertLast(input);
        }

        // Print original list
        System.out.println(list);

        // Perform insertion of "." before nodes starting with uppercase letters
        vmetniTochki(list);

        // Print modified list
        System.out.println(list);
    }
}
