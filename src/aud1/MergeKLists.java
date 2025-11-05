package aud1;


import java.util.Scanner;

public class MergeKLists {
    public static void mergeK(SLL<SLL<Integer>> list) {

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        SLL<SLL<Integer>> list = new SLL<SLL<Integer>>();
        for (int i = 0; i < n; i++) {
            SLL<Integer> tmp = new SLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        mergeK(list);
        System.out.println(list);
    }
}
