package aud2;

import java.util.Scanner;

public class JunskaSesija {
    public static void vmetniTochki(DLL<String> list) {
        DLLNode<String> dvizi = list.getFirst();

        while (dvizi!=null) {
            String value = dvizi.element;
            for(int i=0;i<value.length();i++) {
                if(Character.isUpperCase(value.charAt(0))) {
                    list.insertBefore(".", dvizi);
                    break;
                }
            }
            dvizi = dvizi.succ;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        for (int t = 1; t <= tests; t++) {
            System.out.println("Test case " + t);
            input.next();
            int n = input.nextInt();

            DLL<String> list = new DLL<>();

            for (int i = 0; i < n; i++) {
                list.insertLast(input.next());
            }

            System.out.println(list);

            vmetniTochki(list);

            System.out.println(list);

        }
    }
}
