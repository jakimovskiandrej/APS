package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juni2020 {

    public static void modified(DLL<Integer> list) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        for(int i=0;i<list.getSize()/2;i++) {
            if(first.element > last.element) {
                list.insertAfter(first.element, first);
            } else {
                list.insertAfter(last.element, first);
            }

            first.element = first.element + last.element;

            first = first.succ.succ;
            last = last.pred;
        }

        System.out.println(list);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();
        int num = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        modified(list);
    }
}
