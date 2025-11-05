package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class podeliSporedParnost {
    public static void podeliParnost(DLL<Integer> lista, DLL<Integer> parni, DLL<Integer> neparni) {
        DLLNode<Integer> pom1 = lista.getFirst();
        DLLNode<Integer> pom2 = lista.getLast();

        while(pom1!=pom2 && pom2.succ!=pom1)
        {
            if(pom1.element%2==0)
            {
                parni.insertLast(pom1.element);
            }
            else
            {
                neparni.insertLast(pom1.element);
            }
            if(pom2.element%2==0)
            {
                parni.insertLast(pom2.element);
            }
            else
            {
                neparni.insertLast(pom2.element);
            }
            pom1 = pom1.succ;
            pom2 = pom2.pred;
        }

        if(pom1==pom2)
        {
            if(pom1.element%2==0)
            {
                parni.insertLast(pom1.element);
            }
            else
            {
                neparni.insertLast(pom2.element);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>(), parni = new DLL<Integer>(),
                neparni = new DLL<Integer>();
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
         String s = stdin.readLine();
         int N = Integer.parseInt(s);
         s = stdin.readLine();
         String[] pomniza = s.split(" ");
         for (int i = 0; i < N; i++) {
             lista.insertLast(Integer.parseInt(pomniza[i]));
         }

         podeliParnost(lista, parni, neparni);

         // Pecatenje parni
         DLLNode<Integer> tmp = parni.getFirst();
         while (tmp != null) {
             System.out.print(tmp.element);
             if (tmp.succ != null)
                 System.out.print(" ");
             tmp = tmp.succ;
         }
        System.out.println();
         // Pecatenje neparni
         tmp = neparni.getFirst();
         while (tmp != null) {
             System.out.print(tmp.element);
             if (tmp.succ != null)
                 System.out.print(" ");
              tmp = tmp.succ;
             }
         System.out.println();
        }
    }

