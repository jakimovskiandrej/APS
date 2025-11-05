package aud1;

import java.util.Scanner;

public class Vezhbi {

    public static void insertTarget(SLL<String> list, int L) {
        SLLNode<String> dvizi = list.getFirst();
        SLLNode<String> last = null;

        while (dvizi!=null) {
            if(dvizi.element.length() == L) {
                last = dvizi;
            }
            dvizi = dvizi.succ;
        }

        if(last!=null) {
            list.delete(last);
            list.insertFirst(last.element);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        SLL<String> list = new SLL<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            list.insertLast(word);
        }

        int L = scanner.nextInt();
        scanner.close();

        System.out.println(list);

        insertTarget(list, L);

        SLLNode<String> node = list.getFirst();
        while (node != null) {
            System.out.print(node.element);
            if (node.succ != null) {
                System.out.print("->");
            }
            node = node.succ;
        }
    }
}
