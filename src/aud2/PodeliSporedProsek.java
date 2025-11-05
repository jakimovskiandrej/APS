package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSporedProsek {
    public static void podeliSporedProsek(DLL<Integer> lista, DLL<Integer> rez1, DLL<Integer> rez2) {
        DLLNode<Integer> dvizi = lista.getFirst();
        int counter = 0;
        int sum = 0;

        while(dvizi!=null){
            sum+=dvizi.element;
            counter++;
            dvizi = dvizi.succ;
        }

        float avg = (float)sum/counter;

        dvizi = lista.getFirst();

        while(dvizi!=null){
            if(dvizi.element<=avg){
                rez1.insertFirst(dvizi.element);
            }else{
                rez2.insertFirst(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        DLL<Integer> lista = new DLL<>();
        DLL<Integer> rez1 = new DLL<>();
        DLL<Integer> rez2 = new DLL<>();
        int N = Integer.parseInt(s);
        s = br.readLine();
        String[] split = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(split[i]));
        }

        podeliSporedProsek(lista,rez1,rez2);

        DLLNode<Integer> tmp = rez1.getFirst();
        while(tmp!=null){
            System.out.println(tmp.element);
            if(tmp.succ!=null){
                System.out.println(" ");
            }
            tmp = tmp.succ;
        }
        tmp = rez2.getFirst();
        while(tmp!=null){
            System.out.println(tmp.element);
            if(tmp.succ!=null){
                System.out.println(" ");
            }
            tmp = tmp.succ;
        }
    }
}
