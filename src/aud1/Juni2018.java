package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juni2018 {

    public static void juni(SLL<Integer> list, int delMid) {
        SLLNode<Integer> dvizi = list.getFirst();

        for(int i = 0; i < delMid; i++) {
            if(dvizi == null) {
                break;
            }
        }

        int n = list.size();
        dvizi = list.getFirst();

        if(n%2!=0) {
            for(int i=0;i<n/2;i++) {
                dvizi = dvizi.succ;
            }
            list.delete(dvizi);
        } else {
            for(int i=0;i<n/2-1;i++) {
                dvizi = dvizi.succ;
            }
            if(dvizi.element <= dvizi.succ.element) {
                list.delete(dvizi);
            } else {
                list.delete(dvizi.succ);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        int brElem = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        int delMid = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElem; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        juni(list, delMid);
    }
}
