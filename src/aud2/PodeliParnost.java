package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliParnost {
    public static void podeliSporedParnost(DLL<Integer> lista, DLL<Integer> parni,
                                           DLL<Integer> neparni){
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();

        while(prv!=posleden && posleden.succ!=prv){
            if(prv.element%2==0){
                parni.insertLast(prv.element);
            }else{
                neparni.insertLast(prv.element);
            }
            if(posleden.element%2==0){
                parni.insertLast(posleden.element);
            }else{
                neparni.insertLast(posleden.element);
            }
            prv = prv.succ;
            posleden = posleden.pred;
        }
        if(prv==posleden){
            if(prv.element%2==0){
                parni.insertLast(prv.element);
            }else{
                neparni.insertLast(prv.element);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        DLL<Integer> parni = new DLL<Integer>();
        DLL<Integer> neparni = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }
        podeliSporedParnost(lista,parni,neparni);

        DLLNode<Integer> tmp = parni.getFirst();
        while(tmp!=null){
            System.out.println(tmp.element);
            if(tmp.succ!=null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
        tmp = neparni.getFirst();
        while(tmp!=null){
            System.out.println(tmp.element);
            if(tmp.succ!=null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
    }
}
