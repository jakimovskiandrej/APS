package aud2;
import java.util.Scanner;

public class RotateList {
    public static void rotate(DLL<Integer> list, int k) {
        DLLNode<Integer> dvizi = list.getLast();
        int counter = 0;

        while(counter < k) {
            list.insertFirst(dvizi.element);
            dvizi = dvizi.pred;
            list.delete(dvizi);
            counter++;
        }

        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int k = sc.nextInt();
        sc.close();

        System.out.println(lista);

        rotate(lista,k);
    }
}
