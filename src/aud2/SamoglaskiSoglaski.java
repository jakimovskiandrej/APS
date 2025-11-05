package aud2;

import java.util.Scanner;

public class SamoglaskiSoglaski {
    public static void splitVowels(DLL<Character> list,DLL<Character> list_sam, DLL<Character> list_sog) {
        DLLNode<Character> front = list.getFirst();
        DLLNode<Character> rear = list.getLast();

        while (true) {
            if(front.element == 'a' || front.element == 'e' || front.element == 'i' || front.element == 'o' || front.element == 'u') {
                list_sam.insertLast(front.element);
            } else {
                list_sog.insertLast(front.element);
            }

            if(front == rear) {
                break;
            }
            front = front.succ;

            if(rear.element == 'a' || rear.element == 'e' || rear.element == 'i' || rear.element == 'o' || rear.element == 'u') {
                list_sam.insertLast(rear.element);
            } else {
                list_sog.insertLast(rear.element);
            }
            rear = rear.pred;
            if(rear.succ == front) {
                break;
            }

        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= Integer.parseInt(input.nextLine());
        String bukvi= input.nextLine();
        DLL<Character> lista= new DLL<>();
        DLL<Character> lista_sam= new DLL<>();
        DLL<Character> lista_sog= new DLL<>();
        for(int i=0;i<2*n;i+=2){
            lista.insertLast((bukvi.charAt(i)));
        }
        splitVowels(lista,lista_sam,lista_sog);
        System.out.println(lista_sam);
        System.out.println(lista_sog);
    }
}
