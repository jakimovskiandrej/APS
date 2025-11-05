package aud1;

import java.util.Scanner;

public class SplitList {
    public static void splitList(SLL<Integer> list, int k)
    {
        int length = 0;
        SLLNode<Integer> tmp = list.getFirst();
        while(tmp!=null) {
            length+=1;
            tmp = tmp.succ;
        }

        int part = length/k;
        int extra = length%k;

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        tmp = list.getFirst();

        for(int i=0;i<k;i++) {
            sb.append("[");

            int partSize = part + (i < extra ? 1 : 0);
            for(int j=0;j<partSize;j++) {
                if(tmp!=null) {
                    sb.append(tmp.element);
                    tmp = tmp.succ;
                    if(j < partSize - 1) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]");
            if(i < k - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int k = sc.nextInt();
        splitList(lista,k);
    }
}
