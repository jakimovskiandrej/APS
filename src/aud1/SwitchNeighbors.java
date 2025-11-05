package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SwitchNeighbors {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        String line = br.readLine();
        String parts[] = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> tmp = dvizi;

        while(dvizi.succ!=null)
        {
            tmp = dvizi;
            list.insertAfter(tmp.element, tmp.succ);
            dvizi = dvizi.succ;
            list.delete(tmp);
            dvizi = dvizi.succ;
            if(dvizi.succ!=null)
            {
                dvizi = dvizi.succ;
            }
        }
        System.out.println(list);
    }
}