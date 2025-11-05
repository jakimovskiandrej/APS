package aud1;

import java.util.Scanner;

public class PutWordsTogether {

    public static void putWordsTogether(SLL<String> list) {
        SLL<String> result = new SLL<>();
        String zbor = "";
        SLLNode<String> dvizi = list.getFirst();

        while (dvizi!=null) {
            if(dvizi.element.equals(",")) {
                result.insertLast(zbor);
                zbor = "";
            } else {
                zbor+=dvizi.element;
            }
            dvizi = dvizi.succ;
        }
        result.insertLast(zbor);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();//cin.getLine()
        //sc.next() e isto so cin>>string
        //c a t , d o g , c o w == line
        // parts[0]=c  parts[1]=a  parts[2]=t  parts[3]=,  .... parts[parts.length-1]=w
        SLL<String> lista = new SLL<>();
        String[] parts = line.split("\\s+");//\\s+ znaci edno ili poveke prazni mesta
        for (int i = 0; i < parts.length; i++) {
            lista.insertLast(parts[i]);
        }
        putWordsTogether(lista);
    }
}
