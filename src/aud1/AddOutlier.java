package aud1;

import java.io.IOException;
import java.util.Scanner;

public class AddOutlier {

    public static void addOutlier(SLL<String> list, int L) {
        SLL<String> res = new SLL<>();
        SLLNode<String> dvizi = list.getFirst();
        while (dvizi!=null) {
            if(dvizi.element.length() != L) {
                res.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        dvizi = list.getFirst();
        while (dvizi!=null) {
            if(dvizi.element.length() == L) {
                res.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        SLL<String> list = new SLL<>();
        for(int i=0;i<n;i++){
            String value = scanner.nextLine();
            list.insertLast(value);
        }
        int L = scanner.nextInt();
        scanner.close();
        System.out.println(list);
        addOutlier(list,L);
    }
}
